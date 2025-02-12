package com.solvd.daos;

import com.solvd.models.Client;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface IClientDAO extends IBaseDAO<Client> {

    @Select("select * from mydb.Clients where id=#{index}")
    @Results(value={
            @Result(property="id", column="id"),
            @Result(property = "name", column="name"),
            @Result(property = "lastName", column="last_name"),
            @Result(property = "email", column="email"),
            @Result(property = "phoneNumber", column="phone_number")
    })
    @Override
    Client getEntityById(int index);


    @Select("select * from mydb.Clients")
    @Results(value={
            @Result(property="id", column="id"),
            @Result(property = "name", column="name"),
            @Result(property = "lastName", column="last_name"),
            @Result(property = "email", column="email"),
            @Result(property = "phoneNumber", column="phone_number")
    })
    @Override
    List<Client> getEntities();

    @Insert("Insert into mydb.Clients (name, last_name, email, phone_number) values (#{name}, #{lastName}, #{email}, #{phoneNumber})")
    @Options(useGeneratedKeys = true, keyProperty="id")
    @Results(value={
            @Result(property = "id", column="id"),
            @Result(property = "name", column="name"),
            @Result(property = "lastName", column="last_name"),
            @Result(property = "email", column="email"),
            @Result(property = "phoneNumber", column="phone_number")
    })
    @Override
    Client insert(Client client);

    @Update("Update mydb.Clients set name=#{name}, last_name=#{lastName}, email=#{email}, phone_number=#{phoneNumber} where id=#{id}")
    @Results(value={
            @Result(property = "id", column="id"),
            @Result(property = "name", column="name"),
            @Result(property = "lastName", column="last_name"),
            @Result(property = "email", column="email"),
            @Result(property = "phoneNumber", column="phone_number")
    })
    @Override
    Client update(int id, Client client);


    @Delete("Delete from mydb.Clients where id=#{id}")
    @Results(value={
            @Result(property = "id", column="id"),
            @Result(property = "name", column="name"),
            @Result(property = "lastName", column="last_name"),
            @Result(property = "email", column="email"),
            @Result(property = "phoneNumber", column="phone_number")
    })
    @Override
    boolean removeById(int id);


}
