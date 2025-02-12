package com.solvd.services;

import com.solvd.daos.IClientDAO;
import com.solvd.daos.mybatis.ClientDAO;

import java.util.ResourceBundle;

public class ClientService {

    public static IClientDAO getClientSelect() {
        ResourceBundle resourceBundle = ResourceBundle.getBundle("database");
        if  (resourceBundle.getString("type").equals("jdbc")){
            System.out.println("JDBC approach is used");
            return new com.solvd.daos.jdbc.ClientDAO();
        } else {
            System.out.println("MyBatis approach is used");
            return new ClientDAO();
        }
    }


}
