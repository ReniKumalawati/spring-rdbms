package com.mitrais.gundalatem.springrdbms.model;

import javax.persistence.*;
import javax.transaction.Transactional;

@Entity
@Transactional

public class Employee {

    @Id
    private int id;

    private String name;
    private String address;
    private String grade;

    @OneToOne(cascade = { CascadeType.ALL })
    @JoinColumn (name = "basketId", referencedColumnName = "id")
    private Basket basket;

    public Employee(){
    }


    //Getter Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }
}