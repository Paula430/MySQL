package com.solvd.models;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;


public class Employees {
    private List<Employee> employeeList=new ArrayList<>();

    public Employees() {
    }

    public Employees(List<Employee> employeeList) {
        this.employeeList = employeeList;
    }

    @XmlElement(name="employee")
    public void setEmployeeList(List<Employee> employeeList) {
        if (employeeList != null) {
            this.employeeList.addAll(employeeList);
        }
    }

    @Override
    public String toString() {
        return "Employees{" +
                "employeeList=" + employeeList +
                '}';
    }

    public List<Employee> getEmployeeList() {
        return employeeList;
    }
}
