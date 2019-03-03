package com.mitrais.gundalatem.springrdbms.controller;

import com.mitrais.gundalatem.springrdbms.model.Carrot;
import com.mitrais.gundalatem.springrdbms.service.CarrotServiceUsingDb;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/carrotsJPQL")
public class CarrotJPQLController {

    private CarrotServiceUsingDb carrotServiceUsingDb;

    public CarrotJPQLController(CarrotServiceUsingDb carrotServiceUsingDb) {
        this.carrotServiceUsingDb = carrotServiceUsingDb;
    }

    @GetMapping
    public List<Carrot> get(@RequestParam(required = false) String type) {
        if (type != null) {
            List<Carrot>  cr = carrotServiceUsingDb.findAllByTypeJPQL(type);
            return cr;
        }
        List<Carrot>  cr = carrotServiceUsingDb.fetchCarrotJPQL();
        return cr;
    }

    @PutMapping("{id}")
    void update(@RequestBody Carrot carrot, @PathVariable int id) {
        carrotServiceUsingDb.updateCarrotJPQL(id, carrot.getType(), carrot.getIdFrom(), carrot.getIdTo(), carrot.getCarrotAmt());
    }

    @PostMapping
    void create(@RequestBody Carrot carrot) {
        carrotServiceUsingDb.createCarrotJPQL(carrot.getId(), carrot.getType(), carrot.getIdFrom(), carrot.getIdTo(), carrot.getCarrotAmt());
    }

    @DeleteMapping("{id}")
    List<Carrot> delete(@PathVariable int id) {
        return carrotServiceUsingDb.deleteCarrotJPQL(id);
    }
}
