package com.mitrais.gundalatem.springrdbms.repository;

import com.mitrais.gundalatem.springrdbms.model.Carrot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

import java.util.List;


public interface CarrotRepository extends JpaRepository<Carrot, Integer> {
    @Query("select c from Carrot c where c.type like :type")
    List<Carrot> findAllByTypeJPQL(String type);

    @Query("select c from Carrot c")
    List<Carrot> fetchCarrotJPQL();


    @Modifying
    @Query(value = "insert into Carrot (id,type,id_from,id_to,carrot_amt) values (:id,:type ,:idFrom,:idTo,:carrotAmt)", nativeQuery = true)
    @Transactional
    void createCarrotJPQL(@Param("id") int id, @Param("type") String type, @Param("idFrom") int idFrom, @Param("idTo") int idTo, @Param("carrotAmt") int carrotAmt);


    @Transactional
    @Modifying
    @Query("Update Carrot c set c.type = :type, c.idFrom = :idFrom, c.idTo = :idTo, c.carrotAmt = :carrotAmt where c.id = :id")
    void updateCarrotJPQL(@Param("id") int id, @Param("type") String type, @Param("idFrom") int idFrom, @Param("idTo") int idTo, @Param("carrotAmt") int carrotAmt);

    @Transactional
    @Modifying
    @Query("Delete from Carrot c where c.id = :id")
    void deleteCarrotJPQL(@Param("id") int id);

}
