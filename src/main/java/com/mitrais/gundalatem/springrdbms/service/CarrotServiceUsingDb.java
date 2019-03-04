package com.mitrais.gundalatem.springrdbms.service;

import com.mitrais.gundalatem.springrdbms.model.Carrot;
import com.mitrais.gundalatem.springrdbms.repository.CarrotRepository;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CarrotServiceUsingDb implements CarrotService {
    private CarrotRepository carrotRepository;

    @PersistenceContext
    private EntityManager em;

    public CarrotServiceUsingDb(CarrotRepository carrotRepository) {
        this.carrotRepository = carrotRepository;
    }

    @Override
    public List<Carrot> carrotByType() {
        return null;
    }

    @Override
    public List<Carrot> carrotByType(String type) {
        return null;
    }

    @Override
    public void deleteCarrot(int id) {

    }

    @Override
    public void updateCarrot(int id, String type, int idFrom, int idTo, int carrotAmt) {

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
    public List<Carrot> update(int id, Carrot carrot) {
//        return
              List<Carrot> myList = findAllById(id);
              myList.forEach((Carrot crt) -> {

                  crt.setId(id);
                  crt.setType(carrot.getType());
                  crt.setIdTo(carrot.getIdTo());
                  crt.setIdFrom(carrot.getIdFrom());
                  crt.setCarrotAmt(carrot.getCarrotAmt());
                  create(crt);
              });

              return fetch();
    }

    @Override
    public List<Carrot> findAllByType(String type) {
        System.out.println(type);
        return carrotRepository.findAll().stream().filter((e) -> e.getType().equals(type)).collect(Collectors.toList());
    }

    @Override
    public List<Carrot> findAllById(int id) {
        return carrotRepository.findAll().stream().filter((e) -> e.getId() == id).collect(Collectors.toList());
    }

    @Override
    public List<Carrot> findAllByTypeJPQL(String type) {
        System.out.println(type);
        return carrotRepository.findAllByTypeJPQL("%" + type + "%");
    }

//    @Override
//    public void createCarrotJPQL(int id, String type, int idFrom, int idTo, int carrotAmt) {
//        carrotRepository.createCarrotJPQL(id, type, idFrom, idTo, carrotAmt);
//    }
//
    @Override
    public List<Carrot> fetchCarrotJPQL() {
        return carrotRepository.fetchCarrotJPQL();
    }

    @Override
    public void updateCarrotJPQL(int id, String type, int idFrom, int idTo, int carrotAmt) {
        carrotRepository.updateCarrotJPQL(id, type, idFrom, idTo, carrotAmt);
    }

    @Override
    public void createCarrotJPQL(int id, String type, int idFrom, int idTo, int carrotAmt) {
        System.out.println(id + type + idTo);
        carrotRepository.createCarrotJPQL(id, type, idFrom, idTo, carrotAmt);
    }

    @Transactional
    @Override
    public List<Carrot> deleteCarrotJPQL(int id) {
        carrotRepository.deleteCarrotJPQL(id);
        return carrotRepository.fetchCarrotJPQL();
    }

}
