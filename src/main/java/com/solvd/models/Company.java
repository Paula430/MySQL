package com.solvd.models;

import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;
import lombok.*;

import java.util.List;

@XmlRootElement(name="company")
public class Company {
    private String name;
    private Clients clients=new Clients();
    private Employees employees=new Employees();

    public Company() {
    }

    public Company(String name, Clients clients, Employees employees) {
        this.name = name;
        this.clients = clients;
        this.employees = employees;
    }

    @Override
    public String toString() {
        return "Company{" +
                "name='" + name + '\'' +
                ", clients=" + clients +
                ", employees=" + employees +
                '}';
    }

    @XmlElement(name="clients")
    public void setClients(Clients clients) {
        this.clients = clients;
    }

    @XmlElement(name="employees")
    public void setEmployees(Employees employeesList) {
        this.employees = employeesList;
    }

    @XmlAttribute
    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Clients getClients() {
        return clients;
    }

    public Employees getEmployees() {
        return employees;
    }
}
