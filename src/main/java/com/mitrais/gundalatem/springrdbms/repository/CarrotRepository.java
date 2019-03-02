package com.mitrais.gundalatem.springrdbms.repository;

import com.mitrais.gundalatem.springrdbms.model.Carrot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CarrotRepository extends JpaRepository<Carrot, Integer> {
    @Query("select c from Carrot c where c.type like :type")
    List<Carrot> findAllByType(String type);

    @Query("select c from Carrot c")
    List<Carrot> fetchCarrotJPQL();

//
//    @Query("insert into Carrot (id, type, idFrom, idTo, carrotAmt) values (:id, :type, :idFrom, :idTo, :carrotAmt)")
//    List<Carrot> createCarrotJPQL(int id, String type, int idFrom, int idTo, int carrotAmt);
//
//    @Query("select c from Carrot c where c.type like :type")
//    List<Carrot> updateCarrotJPQL(Carrot carrot);
//
//    @Query("select c from Carrot c where c.type like :type")
//    List<Carrot> deleteCarrotJPQL(int id);
}
