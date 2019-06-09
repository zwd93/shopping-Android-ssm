package com.shop.ssm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shop.ssm.mapper.UserMapper;
import com.shop.ssm.po.User;
import com.shop.ssm.service.UserService;

@Service("userServiceImpl")
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserMapper userMapper;
    
	@Override
	public List<User> findUserBy(User user) {
		return userMapper.findUserBy(user);
	}

	@Override
	public void insertUser(User user) {
		userMapper.insertUser(user);
	}
	
}
