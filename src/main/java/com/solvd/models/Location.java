package com.solvd.models;

import lombok.*;

@ToString
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Location {
    private int id;
    private String city;
    private String street;

    public Location(String city, String street){
        this.city=city;
        this.street=street;
    }
}
