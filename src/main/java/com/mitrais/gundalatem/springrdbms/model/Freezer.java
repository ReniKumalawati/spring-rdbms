package com.mitrais.gundalatem.springrdbms.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.transaction.Transactional;

@Entity
@Transactional
public class Freezer {
    @Id
    private int id;
    private String name;
    private String type;

}
