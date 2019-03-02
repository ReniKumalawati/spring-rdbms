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
        return fetch();
    }

    @Override
    public List<Carrot> fetch() {
        List<Carrot> listCarrots = carrotRepository.findAll();
        return listCarrots;
    }

    @Override
    public List<Carrot> delete(int id) {
        carrotRepository.deleteById(id);
        return fetch();
    }

    @Override
    public List<Carrot> findAllByType(String type) {
        System.out.println(type);
        return carrotRepository.findAllByType("%" + type + "%");
    }

//    @Override
//    public List<Carrot> createCarrotJPQL(Carrot carrot) {
//        return carrotRepository.createCarrotJPQL(carrot);
//    }
//
    @Override
    public List<Carrot> fetchCarrotJPQL() {
        return carrotRepository.fetchCarrotJPQL();
    }
//
//    @Override
//    public List<Carrot> deleteCarrotJPQL(int id) {
//        return carrotRepository.deleteCarrotJPQL(id);
//    }

}
