package com.bingo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bingo.model.User;
import com.bingo.service.UserService;

@RestController
@RequestMapping(value = {"/user"})
public class UserController {
	
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	private UserService userService;
	
	@GetMapping(value = {"/genCode"})
	public boolean genVerifyCode(String countryCode, String phoneNum) {
		return userService.sendMsg(countryCode, phoneNum);
	}
	
	@PostMapping(value = {"/verify"})
	public boolean verify(String phoneNum, String verifyCode) {
		return userService.verify(phoneNum, verifyCode);
	}
	
	@PostMapping(value = {"/register"})
	public boolean register(User user) {
		// 调用useService保存用户信息
		try {
			userService.register(user);
			return true;
		} catch (Exception e) {
			logger.error("注册失败" + e.getMessage());
		}
		return false;
	}
	
	@PostMapping(value = {"/deposit"})
	public boolean deposit(User user) {
		try {
			// 更新用户信息
			userService.update(user);
			return true;
		} catch (Exception e) {
			logger.error("更新信息失败" + e.getMessage());
		}
		return false;
	}
	
}
