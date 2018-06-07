package com.bingo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bingo.service.UserService;

@Controller
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping(value = {"/user/genCode"})
	@ResponseBody
	public boolean genVerifyCode(String countryCode, String phoneNum) {
		boolean flag = userService.sendMsg(countryCode, phoneNum);
		return flag;
	}
}
