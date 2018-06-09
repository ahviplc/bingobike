package com.bingo.controller;

import com.bingo.model.Bike;
import com.bingo.service.BikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = {"/bike"})
public class BikeController {

    @Autowired
    private BikeService bikeService;

    @PostMapping(value = {"/add"})
    public String addBike(Bike bike) {
        bikeService.save(bike);
        return "success";
    }
}
