package com.bingo.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.github.qcloudsms.SmsSingleSender;
import com.github.qcloudsms.SmsSingleSenderResult;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

@Service
public class UserServiceImpl implements UserService {
	private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
	private static JedisPool pool = new JedisPool("redis://localhost:6379/3");
	
	@Override
	public boolean sendMsg(String countryCode, String phoneNum) {
		// 调用腾讯云的短信API
		Jedis jedis = pool.getResource();
		
		// 从redis中获取之前存储的appid与appkey
		int appid = Integer.parseInt(jedis.get("appid"));
		String appkey = jedis.get("appkey");
		
		boolean flag = true;
		try {
			// 生成短信验证码(4位)
		    int code = (int)((Math.random() * 9 + 1) * 1000);
		    SmsSingleSender ssender = new SmsSingleSender(appid, appkey);
		    // 向对应手机号的用户发送短信
		    SmsSingleSenderResult result = ssender.send(0, countryCode, phoneNum, "【为悦bike】你的验证码为：" + code + "。如非本人操作，请忽略本短信。" , "", "");
		    
			// 将发送的手机号作为key,验证码作为value保存到redis中(有效时长300s)
		    jedis.setex(phoneNum, 300, code + "");
		    
		} catch (Exception e) {
		    flag = false;
		    logger.error("调用短信接口异常" + e.getMessage());
		    
		} finally {
			jedis.close();
		}
		
		return flag;
	}

	@Override
	public boolean verify(String phoneNum, String verifyCode) {
		Jedis jedis = pool.getResource();
		String code = jedis.get(phoneNum);
		jedis.close();
		return code != null && code.equals(verifyCode);
		
	}
	
}
