package com.mitrais.gundalatem.springrdbms.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/carrots")
public class CarrotController {
    @GetMapping
    public void get() {
        System.out.println("aaaa");
    }
}
