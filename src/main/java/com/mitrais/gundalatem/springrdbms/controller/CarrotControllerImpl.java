package com.mitrais.gundalatem.springrdbms.controller;

import com.mitrais.gundalatem.springrdbms.model.Carrot;
import com.mitrais.gundalatem.springrdbms.service.CarrotRepositoryImpl;
import com.mitrais.gundalatem.springrdbms.service.CarrotServiceUsingDb;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/carrotsImpl")
public class CarrotControllerImpl {
    private CarrotRepositoryImpl carrotRepositoryImpl;

    public CarrotControllerImpl(CarrotRepositoryImpl carrotRepositoryImpl){
        this.carrotRepositoryImpl = carrotRepositoryImpl;
    }

  @GetMapping
    public List<Carrot> get(){
      List<Carrot> cr = carrotRepositoryImpl.carrotByType();
      return cr;
  }

    @GetMapping ("{type}")
    public List<Carrot> findByType(@PathVariable String type){
        List<Carrot> cr = carrotRepositoryImpl.carrotByType(type);
        return cr;
    }

    @DeleteMapping("{id}")
    public void deleteCarrot(@PathVariable Integer id){
        carrotRepositoryImpl.deleteCarrot(id);
    }

    @PutMapping("{id}")
    public void updateCarrot(@PathVariable Integer id, @RequestBody Carrot carrot){
      carrotRepositoryImpl.updateCarrot(id, carrot.getType(), carrot.getIdFrom(), carrot.getIdTo(), carrot.getCarrotAmt());
    }
}
