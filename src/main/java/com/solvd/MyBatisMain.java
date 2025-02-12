package com.solvd;

import com.solvd.daos.IClientDAO;
import com.solvd.models.Client;
import com.solvd.services.ClientService;

public class MyBatisMain {
    public static void main(String[] args) {
        IClientDAO clientDAO = ClientService.getClientSelect();

        //get entity by id
        System.out.println(clientDAO.getEntityById(3));

        //get all clients
        System.out.println(clientDAO.getEntities());

        //insert into clients
        Client client = new Client("Lucy", "Lean", "222222222", "lucy@mail.com");
        System.out.println(clientDAO.insert(client));

        //update
        Client client2 = new Client(13,"222222222", "lucy@email.com", "Lean", "Lucy");
        System.out.println(clientDAO.update(13,client2));

        //delete
  //      System.out.println(clientDAO.removeById(13));



    }
}
