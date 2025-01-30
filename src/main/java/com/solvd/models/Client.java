package com.solvd.models;

import com.sun.xml.txw2.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlAttribute;
import lombok.*;

public class Client {
    private int id;
    private String name;
    private String lastName;
    private String email;
    private String phoneNumber;

    public Client(String name, String lastName, String phoneNumber, String email){
        this.name=name;
        this.lastName=lastName;
        this.phoneNumber=phoneNumber;
        this.email=email;
    }

    public Client(int id, String phoneNumber, String email, String lastName, String name) {
        this.id = id;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.lastName = lastName;
        this.name = name;
    }

    public Client() {
    }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }

    @XmlAttribute
    public void setId(int id) {
        this.id = id;
    }
    @XmlElement
    public void setName(String name) {
        this.name = name;
    }
    @XmlElement
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    @XmlElement
    public void setEmail(String email) {
        this.email = email;
    }
    @XmlElement
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
}
