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

    @Transactional
    @Modifying
    @Query("Update Carrot c set c.type = :type, c.idFrom = :idFrom, c.idTo = :idTo, c.carrotAmt = :carrotAmt where c.id = :id")
    void updateCarrotJPQL(@Param("id") int id, @Param("type") String type, @Param("idFrom") int idFrom, @Param("idTo") int idTo, @Param("carrotAmt") int carrotAmt);

}
