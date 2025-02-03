package com.solvd.models;

import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import lombok.*;

import java.util.Date;


@XmlType(propOrder = {"firstName", "lastName","email", "phone","hireDate","department"})
public class Employee {
    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private Date hireDate;
    private Department department;

    public Employee(String firstName, String lastName, String phone, String email, Date hireDate, Department department){
        this.firstName=firstName;
        this.lastName=lastName;
        this.phone=phone;
        this.email=email;
        this.hireDate=hireDate;
        this.department=department;
    }


    public Employee(int id, String firstName, String lastName,String phone, String email, Date hireDate, Department department) {
        this.department = department;
        this.hireDate = hireDate;
        this.phone = phone;
        this.email = email;
        this.lastName = lastName;
        this.firstName = firstName;
        this.id = id;
    }
    public Employee() {
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", hireDate=" + hireDate +
                ", department=" + department +
                '}';
    }

    @XmlAttribute
    public void setId(int id) {
        this.id = id;
    }

    @XmlElement(name="firstname")
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    @XmlElement(name="lastname")
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    @XmlElement
    public void setEmail(String email) {
        this.email = email;
    }
    @XmlElement
    public void setPhone(String phone) {
        this.phone = phone;
    }

    @XmlJavaTypeAdapter(DateAdapter.class)
    @XmlElement(name="hiredate")
    public void setHireDate(Date hireDate) {
        this.hireDate = hireDate;
    }

    @XmlElement
    public void setDepartment(Department department) {
        this.department = department;
    }

    public Department getDepartment() {
        return department;
    }

    public Date getHireDate() {
        return hireDate;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public int getId() {
        return id;
    }
}
