package com.solvd.models;

import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

public class Location {
    private int id;
    private String city;
    private String street;

    public Location(String city, String street){
        this.city=city;
        this.street=street;
    }

    public Location() {
    }

    public Location(int id, String city, String street) {
        this.id = id;
        this.city = city;
        this.street = street;
    }

    @Override
    public String toString() {
        return "Location{" +
                "id=" + id +
                ", city='" + city + '\'' +
                ", street='" + street + '\'' +
                '}';
    }

    @XmlElement
    public void setStreet(String street) {
        this.street = street;
    }
    @XmlElement
    public void setCity(String city) {
        this.city = city;
    }

    @XmlAttribute
    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getStreet() {
        return street;
    }

    public String getCity() {
        return city;
    }
}
