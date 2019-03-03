package com.mitrais.gundalatem.springrdbms.service;

import com.mitrais.gundalatem.springrdbms.model.Basket;
import com.mitrais.gundalatem.springrdbms.repository.BasketRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BasketServiceImpl implements BasketService {
    private BasketRepository basketRepository;

    @Override
    public List<Basket> findAllById(int id) {
        System.out.println(id);
        return basketRepository.findAllById(id);
    }
}
