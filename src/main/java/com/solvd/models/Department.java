package com.solvd.models;

import com.sun.xml.txw2.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlType;
import lombok.*;

import java.util.ArrayList;
import java.util.List;


@XmlType(propOrder = {"name","location"})
public class Department {
    private int id;
    private String name;
    private Location location;

    public Department(int id, String name, Location location ) {
        this.id = id;
        this.name = name;
        this.location = location;
    }

    public Department() {
    }

    public Department(String name, Location location ) {
        this.name = name;
        this.location = location;
    }

    @Override
    public String toString() {
        return "Department{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", location=" + location +
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
    public void setLocation(Location location) {
        this.location = location;
    }

    public int getId() {
        return id;
    }

    public Location getLocation() {
        return location;
    }

    public String getName() {
        return name;
    }
}
