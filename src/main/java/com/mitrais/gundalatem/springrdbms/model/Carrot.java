package com.mitrais.gundalatem.springrdbms.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Carrot {
    @Id
    private int id;
    private String type;

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
}
