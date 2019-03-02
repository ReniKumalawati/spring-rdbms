package com.mitrais.gundalatem.springrdbms.repository;

import com.mitrais.gundalatem.springrdbms.model.Carrot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


public interface CarrotRepository extends JpaRepository<Carrot, Integer> {

}
