package com.mitrais.gundalatem.springrdbms.service;

import com.mitrais.gundalatem.springrdbms.model.Carrot;

import java.util.List;

public interface CarrotService {
    List<Carrot> create(Carrot carrot);
    List<Carrot> fetch();
}
