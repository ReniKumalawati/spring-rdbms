package com.mitrais.gundalatem.springrdbms.service;

import com.mitrais.gundalatem.springrdbms.model.Carrot;

import javax.transaction.Transactional;
import java.util.List;

public interface CarrotService {
    List<Carrot> create(Carrot carrot);
    List<Carrot> fetch();
    List<Carrot> delete(int id);
    List<Carrot> findAllByType(String type);

//    void  createCarrotJPQL(int id, String type, int idFrom, int idTo, int carrotAmt);
    List<Carrot> fetchCarrotJPQL();
    void updateCarrotJPQL(int id, String type, int idFrom, int idTo, int carrotAmt);
    List<Carrot> deleteCarrotJPQL(int id);
}
