package com.mitrais.gundalatem.springrdbms.service;

import com.mitrais.gundalatem.springrdbms.repository.CarrotRepository;
import org.springframework.stereotype.Service;

@Service
public class CarrotServiceUsingDb implements CarrotService {
    private CarrotRepository carrotRepository;

    public CarrotServiceUsingDb(CarrotRepository carrotRepository) {
        this.carrotRepository = carrotRepository;
    }
}
