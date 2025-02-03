package com.solvd;

import com.solvd.models.*;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class JAXB {
//    public static void main(String[] args) throws JAXBException, IOException, ParseException {
//        Company company = unmarshal();
//        System.out.println(company);
//
//        marshal();
//    }
//
//    public static Company unmarshal() throws JAXBException, IOException {
//        JAXBContext context = JAXBContext.newInstance(Company.class);
//        return (Company) context.createUnmarshaller().unmarshal(new FileReader("company.xml"));
//    }
//
//    public static void marshal() throws JAXBException, IOException {
//        Location location = new Location(2, "London", "River Street");
//        Department department = new Department(1, "IT", location);
//
//        Employee employee1 = new Employee(1, "John", "Brown", "123456789", "john@example.com", new Date(), department);
//        Employee employee2 = new Employee(2, "Alex", "Smith", "980437927", "alex@example.com", new Date(), department);
//        Employees employees = new Employees();
//        List<Employee> employeeList = new ArrayList<>();
//        employeeList.add(employee1);
//        employeeList.add(employee2);
//        employees.setEmployeeList(employeeList);
//
//        Client client1 = new Client(1, "999999999", "candy@email.com","Smith" , "Candy");
//        Client client2 = new Client(2, "111111111", "tom@example.com", "Big", "Tom");
//        Clients clients = new Clients();
//        List<Client> clientList = new ArrayList<>();
//        clientList.add(client1);
//        clientList.add(client2);
//        clients.setClientList(clientList);
//
//        Company company = new Company("MyCompany", clients, employees);
//
//        JAXBContext context = JAXBContext.newInstance(Company.class);
//        Marshaller mar = context.createMarshaller();
//        mar.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
//        mar.marshal(company, new File("src/main/resources/company2.xml"));
//    }
}
