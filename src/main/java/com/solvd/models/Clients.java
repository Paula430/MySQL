package com.solvd.models;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;


public class Clients {
    private List<Client> clientList= new ArrayList<>();

    public Clients() {

    }

    public Clients(List<Client> clientList) {
        this.clientList = clientList;
    }

    @Override
    public String toString() {
        return "Clients{" +
                "clientList=" + clientList +
                '}';
    }

    @XmlElement(name = "client")
    public void setClientList(List<Client> clientList) {
        if (clientList != null) {
            this.clientList.addAll(clientList);
        }
    }

    public List<Client> getClientList() {
        return clientList;
    }
}
