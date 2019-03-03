package com.mitrais.gundalatem.springrdbms.service;

import com.mitrais.gundalatem.springrdbms.model.Basket;

import java.util.List;

public interface BasketService {
    List<Basket> findAllById(int id);
}
