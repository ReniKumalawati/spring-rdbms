package com.mitrais.gundalatem.springrdbms.service;

import com.mitrais.gundalatem.springrdbms.model.Carrot;
import com.mitrais.gundalatem.springrdbms.repository.CarrotRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarrotServiceUsingDb implements CarrotService {
    private CarrotRepository carrotRepository;

    public CarrotServiceUsingDb(CarrotRepository carrotRepository) {
        this.carrotRepository = carrotRepository;
    }

    @Override
    public List<Carrot> create(Carrot carrot) {
        carrotRepository.save(carrot);
        return carrotRepository.findAll();
    }

    @Override
    public List<Carrot> fetch() {
        List<Carrot> listCarrots = carrotRepository.findAll();
        return listCarrots;
    }
}
