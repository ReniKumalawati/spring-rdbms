package com.mitrais.gundalatem.springrdbms.model;

import javax.persistence.Id;
import javax.persistence.Entity;

import javax.persistence.OneToOne;
import javax.transaction.Transactional;
import java.util.Set;

@Entity
@Transactional
public class Basket {

    @Id
    private int id;
    private String name;
    private String type;

    @OneToOne(mappedBy = "basket")
    private Employee employee;

    public Basket() {
    }

    public int getBasketId() {
        return id;
    }

    public void setBasketId(int basketId) {
        this.id = id;
    }

}
