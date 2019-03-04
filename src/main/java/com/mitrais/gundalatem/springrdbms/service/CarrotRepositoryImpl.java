package com.mitrais.gundalatem.springrdbms.service;

import com.mitrais.gundalatem.springrdbms.model.Carrot;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.*;
import javax.transaction.Transactional;
import java.util.List;

@Service
public class CarrotRepositoryImpl implements CarrotService {

    @PersistenceContext
    private EntityManager em;


    @Override
    public List<Carrot> carrotByType() {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Carrot> cq = cb.createQuery(Carrot.class);

        Root<Carrot> carrot = cq.from(Carrot.class);
        cq.select(carrot);
        TypedQuery<Carrot> q = em.createQuery(cq);
        List<Carrot> allCarrots = q.getResultList();
        return allCarrots;
    }

    @Override
    public List<Carrot> carrotByType(String type) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Carrot> cq = cb.createQuery(Carrot.class);

/*        Root<Carrot>= q.from(Country.class);
        ParameterExpression<Integer> p = cb.parameter(Integer.class);
        q.select(c).where(cb.gt(c.get("population"), p));*/

        Root<Carrot> carrot = cq.from(Carrot.class);
        Predicate typePredicate = cb.equal(carrot.get("type"), type);
        cq.where(typePredicate);

        TypedQuery<Carrot> query = em.createQuery(cq);
        return query.getResultList();
    }

   /* @Override
    public void create(Carrot carrot){
        em.getTransaction().begin();

        Carrot crrt = new Carrot();
        crrt.setCarrotAmt(20);
        crrt.setId(109);
        crrt.setIdFrom(201);
        crrt.setIdTo(302);
        carrot.setType("freezing");

        em.persist(carrot);

        em.getTransaction().commit();
    }*/

   @Transactional
    public void deleteCarrot(int id) {
        CriteriaBuilder cb = em.getCriteriaBuilder();

        // create delete
        CriteriaDelete<Carrot> delete = cb.createCriteriaDelete(Carrot.class);

        // set the root class
        Root<Carrot> carrot = delete.from(Carrot.class);

        // set where clause
        delete.where(cb.equal(carrot.get("id"), id));

        // perform update
        em.createQuery(delete).executeUpdate();
    }

    @Transactional
    public void updateCarrot(int id, String type, int idFrom, int idTo, int carrotAmt ) {
        CriteriaBuilder cb = em.getCriteriaBuilder();

        // create update
        CriteriaUpdate<Carrot> update = cb.
                createCriteriaUpdate(Carrot.class);

        // set the root class
        Root<Carrot> carrot = update.from(Carrot.class);

        // set update and where clause
        update.set("type", type);
        update.where(cb.equal(carrot.get("id"), id));

        // perform update
        em.createQuery(update).executeUpdate();
    }

    @Override
    public List<Carrot> create(Carrot carrot) {
        return null;
    }

    @Override
    public List<Carrot> fetch() {
        return null;
    }

    @Override
    public List<Carrot> delete(int id) {
        return null;
    }

    @Override
    public List<Carrot> update(int id, Carrot carrot) {
        return null;
    }

    @Override
    public List<Carrot> findAllByType(String type) {
        return null;
    }

    @Override
    public List<Carrot> findAllById(int id) {
        return null;
    }

    @Override
    public List<Carrot> findAllByTypeJPQL(String type) {
        return null;
    }

    @Override
    public List<Carrot> fetchCarrotJPQL() {
        return null;
    }

    @Override
    public void updateCarrotJPQL(int id, String type, int idFrom, int idTo, int carrotAmt) {

    }

    @Override
    public void createCarrotJPQL(int id, String type, int idFrom, int idTo, int carrotAmt) {

    }

    @Override
    public List<Carrot> deleteCarrotJPQL(int id) {
        return null;
    }
}
