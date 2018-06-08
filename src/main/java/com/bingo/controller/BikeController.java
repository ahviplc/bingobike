package com.bingo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bingo.model.Bike;
import com.bingo.service.BikeService;

@Controller
@RequestMapping(value = {"/bike"})
public class BikeController {
	
	@Autowired
	private BikeService bikeService;
	
	@PostMapping(value = {"/add"})
	@ResponseBody
	public String addBike(@RequestBody Bike bike) {
		// System.out.println(bike);
		
		// 调用service层，将单车信息保存到mongodb中
		bikeService.save(bike);
		return "hello";
	}
}
