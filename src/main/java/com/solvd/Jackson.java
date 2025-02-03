package com.solvd;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.solvd.models.*;

import java.awt.image.AreaAveragingScaleFilter;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Jackson {
    public static void main(String[] args) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        objectMapper.setDateFormat(df);

        //Write to json file
        Location location = new Location(2, "London", "River Street");
        Department department = new Department(1, "IT", location);
        Department department2 = new Department(2, "HR", location);

        Employee employee1 = new Employee(1, "John", "Brown", "123456789", "john@example.com", new Date(), department);
        Employee employee2 = new Employee(2, "Sam", "Black", "3456788911", "sam@example.com", new Date(), department2);
        List<Employee> employeeList= Arrays.asList(employee1,employee2);

        Map<String,List<Employee>> employeeMap= new HashMap<>();
        employeeMap.put("employees", employeeList);

        objectMapper.writerWithDefaultPrettyPrinter().writeValue(new File("src/main/resources/employee.json"), employeeMap);

        //Read  from json file
        Map<String,List<Employee>> employeeFromJson = objectMapper.readValue(new File("src/main/resources/employee.json"), new TypeReference<Map<String,List<Employee>>>() {});
        System.out.println(employeeFromJson);

        //JSON to JsonNode, print all departments in json file:
        JsonNode jsonNode = objectMapper.readTree(new File("src/main/resources/employee.json"));
        JsonNode employeesArray = jsonNode.get("employees");
        for(JsonNode empl: employeesArray){
            JsonNode hireDate=empl.get("department");
            System.out.println(hireDate);
        }
    }
}
