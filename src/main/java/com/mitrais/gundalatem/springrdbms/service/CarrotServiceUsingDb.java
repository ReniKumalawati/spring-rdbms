package com.mitrais.gundalatem.springrdbms.service;

import com.mitrais.gundalatem.springrdbms.model.Carrot;
import com.mitrais.gundalatem.springrdbms.repository.CarrotRepository;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaDelete;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;
import java.sql.SQLException;
import java.util.List;

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
    public List<Carrot> findAllByType(String type) {
        System.out.println(type);
        return carrotRepository.findAllByType("%" + type + "%");
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

    @Transactional
    @Override
    public List<Carrot> deleteCarrotJPQL(int id) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaDelete<Carrot> delete = cb.createCriteriaDelete(Carrot.class);
        Root<Carrot> carrot = delete.from(Carrot.class);
        delete.where(cb.equal(carrot.get("id"), id));
        em.createQuery(delete).executeUpdate();
        return carrotRepository.fetchCarrotJPQL();
    }
//
//    @Override
//    public List<Carrot> deleteCarrotJPQL(int id) {
//        return carrotRepository.deleteCarrotJPQL(id);
//    }

}
