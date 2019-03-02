package com.mitrais.gundalatem.springrdbms.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Carrot {
    @Id
    private int id;
    private String type;
    private int idFrom;
    private int idTo;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getIdFrom() { return idFrom; }

    public void setIdFrom(int idFrom) { this.idFrom = idFrom; }

    public int getIdTo() { return idTo; }

    public void setIdTo(int idTo) { this.idTo = idTo; }
}
