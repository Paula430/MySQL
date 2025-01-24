package com.solvd;

import com.solvd.daos.jdbc.ClientDAO;
import com.solvd.daos.jdbc.DepartmentsDAO;
import com.solvd.daos.jdbc.LocationsDAO;
import com.solvd.models.Client;
import com.solvd.models.Department;
import com.solvd.models.Location;

public class App {
    public static void main(String[] args) {
        ClientDAO clientDAO = new ClientDAO();
        Client client = clientDAO.getEntityById(5);
        System.out.println(client);

        System.out.println(clientDAO.getEntities());

        Client client2 = new Client("Joanna", "Dobija", "123456123", "paula@gmail.com");
        clientDAO.insert(client2);
        clientDAO.update(12, client2);
        System.out.println(client2.toString());

        clientDAO.removeById(22);


        DepartmentsDAO departmentsDAO = new DepartmentsDAO();
        System.out.println(departmentsDAO.getEntities());

        System.out.println(departmentsDAO.getEntityById(6));

        Department dep = new Department("IT", 5);
        departmentsDAO.insert(dep);
        departmentsDAO.update(8, dep);

        System.out.println(departmentsDAO.removeById(8));


        LocationsDAO locationDAO = new LocationsDAO();
        System.out.println(locationDAO.getEntities());
        System.out.println(locationDAO.getEntityById(6));

        Location loc = new Location("Cracow", "Cracovska");
        System.out.println(locationDAO.insert(loc));
        locationDAO.update(5, loc);

        System.out.println(locationDAO.removeById(8));


    }
}
