package com.mitrais.gundalatem.springrdbms.controller;

import com.mitrais.gundalatem.springrdbms.model.Carrot;
import com.mitrais.gundalatem.springrdbms.service.CarrotRepositoryImpl;
import com.mitrais.gundalatem.springrdbms.service.CarrotServiceUsingDb;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/carrots")
public class CarrotController {

  private CarrotServiceUsingDb carrotServiceUsingDb;

    public CarrotController(CarrotServiceUsingDb carrotServiceUsingDb) {
        this.carrotServiceUsingDb = carrotServiceUsingDb;
    }

    @GetMapping
    public List<Carrot> get(@RequestParam(required = false) String type) {
        if (type != null) {
            List<Carrot>  cr = carrotServiceUsingDb.findAllByType(type);
            return cr;
        }
        List<Carrot>  cr = carrotServiceUsingDb.fetch();
        return cr;
    }

    @PostMapping
    public  void createCarrot (@RequestBody  Carrot carrot) {
        carrotServiceUsingDb.create(carrot);
    }

/*    @PostMapping
    public void createNewCarrot(@RequestBody Carrot carrot){carrotRepositoryImpl.create(carrot);}*/
    public List<Carrot> deleteCarrot (@PathVariable int id) {
        return carrotServiceUsingDb.delete(id);
    }
}
