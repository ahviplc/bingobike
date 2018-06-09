package com.bingo.controller;

import com.bingo.model.Bike;
import com.bingo.service.BikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.geo.GeoResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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

    @GetMapping(value = {"/findNear"})
    public List<GeoResult<Bike>> findNear(double longitude, double latitude) {
        return bikeService.findNear(longitude, latitude);
    }
}
