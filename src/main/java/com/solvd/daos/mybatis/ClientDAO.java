package com.solvd.daos.mybatis;

import com.solvd.MyBatisConf;
import com.solvd.daos.IClientDAO;
import com.solvd.models.Client;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ClientDAO implements IClientDAO {

    static SqlSessionFactory sqlSessionFactory= MyBatisConf.buildSqlSessionFactory();

    @Override
    public Client getEntityById(int index) {

        //interface
        try(SqlSession session=sqlSessionFactory.openSession()){
            Client client= session.selectOne("com.solvd.daos.IClientDAO.getEntityById", index);
            return client;
        }

//        //XML
//        try(SqlSession session=sqlSessionFactory.openSession()){
//            Client client= session.selectOne("ClientMapper.getEntityById", index);
//            return client;
//        }
    }

    @Override
    public List<Client> getEntities() {
        //interface
        try(SqlSession session=sqlSessionFactory.openSession()){
            List<Client> clientsList= session.selectList("com.solvd.daos.IClientDAO.getEntities");
            return clientsList;
        }

//        //XML
//        try(SqlSession session=sqlSessionFactory.openSession()){
//           List<Client> clients= session.selectOne("ClientMapper.getEntities");
//            return clients;
//        }
    }

    @Override
    public Client insert(Client client) {
        //interface
        try(SqlSession session=sqlSessionFactory.openSession()){
           int rowsInserted= session.insert("com.solvd.daos.IClientDAO.insert", client);
           if(rowsInserted>0){
               session.commit();
               return client;
           }else{
               return null;
           }
        }
    }

    @Override
    public Client update(int id, Client client) {
        //interface
        try(SqlSession session=sqlSessionFactory.openSession()){
            int rowsUpdated= session.update("com.solvd.daos.IClientDAO.update", client);
            if(rowsUpdated>0){
                session.commit();
                return client;
            }else{
                return null;
            }
        }
    }

    @Override
    public boolean removeById(int id) {
        //interface
        try(SqlSession session=sqlSessionFactory.openSession()){
            int rowsDeleted= session.delete("com.solvd.daos.IClientDAO.removeById", id);
            if(rowsDeleted>0){
                session.commit();
                return true;
            }else{
                return false;
            }
        }
    }
}
