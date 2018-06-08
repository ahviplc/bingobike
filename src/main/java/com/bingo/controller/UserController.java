package com.bingo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bingo.service.UserService;

@Controller
@RequestMapping(value = {"/user"})
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping(value = {"/genCode"})
	@ResponseBody
	public boolean genVerifyCode(String countryCode, String phoneNum) {
		return userService.sendMsg(countryCode, phoneNum);
	}
	
	@PostMapping(value = {"/verify"})
	@ResponseBody
	public boolean verify(String phoneNum, String verifyCode) {
		return userService.verify(phoneNum, verifyCode);
	}
	
}
