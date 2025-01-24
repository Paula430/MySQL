package com.solvd.models;

import lombok.*;

@ToString
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Department {
    private int id;
    private String name;
    private int locationID;

    public Department(String name, int locationID){
        this.name=name;
        this.locationID=locationID;
    }
}
