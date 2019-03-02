package com.mitrais.gundalatem.springrdbms.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.transaction.Transactional;

@Entity
@Transactional
public class Carrot {
    @Id
    private int id;
    private String type;
    private int idFrom;
    private int idTo;
    private int carrotAmt;

    public Carrot() {}

    public Carrot(int id, String type, int idFrom, int idTo, int carrotAmt) {
        this.id = id;
        this.type = type;
        this.idFrom = idFrom;
        this.idTo = idTo;
        this.carrotAmt = carrotAmt;
    }

    public int getCarrotAmt() {
        return carrotAmt;
    }

    public void setCarrotAmt(int carrotAmt) {
        this.carrotAmt = carrotAmt;
    }

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

    public int getIdFrom() {
        return idFrom;
    }

    public void setIdFrom(int idFrom) {
        this.idFrom = idFrom;
    }

    public int getIdTo() {
        return idTo;
    }

    public void setIdTo(int idTo) {
        this.idTo = idTo;
    }
}
