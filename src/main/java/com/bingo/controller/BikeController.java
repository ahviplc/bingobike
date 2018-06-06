package com.bingo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bingo.model.Bike;

@Controller
public class BikeController {
	
	@PostMapping(value = {"/addBike"})
	@ResponseBody
	public String addBike(Bike bike) {
		
		return null;
	}
}
