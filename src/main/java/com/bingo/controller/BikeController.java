package com.bingo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.bingo.model.Bike;
import com.bingo.service.BikeService;

@RestController
@RequestMapping(value = {"/bike"})
public class BikeController {
	
	@Autowired
	private BikeService bikeService;
	
	@PostMapping(value = {"/add"})
	public String addBike(Bike bike) {
		// 调用service层，将单车信息保存到mongodb中
		bikeService.save(bike);
		return "hello";
	}
}
