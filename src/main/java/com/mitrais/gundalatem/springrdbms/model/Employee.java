package com.mitrais.gundalatem.springrdbms.model;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import javax.persistence.*;
import javax.transaction.Transactional;
import java.util.HashSet;
import java.util.Set;

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

    @ManyToMany (fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            })
    @JoinTable(name="employee_transactions",
            joinColumns = {@JoinColumn(name = "employee_id")},
            inverseJoinColumns = {@JoinColumn(name = "trans_id")})
    private Set<Carrot> carrots = new HashSet<>();


    @ManyToOne
    @JoinColumn (name = "freezer_id",unique = true)
    @NotFound(action= NotFoundAction.IGNORE)
    private Freezer freezer;

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
