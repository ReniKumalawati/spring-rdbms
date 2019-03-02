package com.mitrais.gundalatem.springrdbms.controller;

import com.mitrais.gundalatem.springrdbms.model.Carrot;
import com.mitrais.gundalatem.springrdbms.service.CarrotServiceUsingDb;
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
            List<Carrot>  cr = carrotServiceUsingDb.findAllByType(type);
            return cr;
        }
        List<Carrot>  cr = carrotServiceUsingDb.fetchCarrotJPQL();
        return cr;
    }
}
