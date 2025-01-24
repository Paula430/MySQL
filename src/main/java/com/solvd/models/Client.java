package com.solvd.models;

import lombok.*;

@ToString
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
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
}
