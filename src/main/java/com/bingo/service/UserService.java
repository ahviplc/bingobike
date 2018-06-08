package com.bingo.service;

public interface UserService {
	boolean sendMsg(String countryCode, String phoneNum);

	boolean verify(String phoneNum, String verifyCode);
}
