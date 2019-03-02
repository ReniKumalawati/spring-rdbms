package com.mitrais.gundalatem.springrdbms.service;

import com.mitrais.gundalatem.springrdbms.model.Carrot;

import java.util.List;

public interface CarrotService {
    /*List<Carrot> create(Carrot carrot);
    List<Carrot> fetch();*/

    List<Carrot> carrotByType ();
    List<Carrot> carrotByType (String type);

    void deleteCarrot(int id);
    void updateCarrot(int id, String type, int idFrom, int idTo, int carrotAmt );
}
