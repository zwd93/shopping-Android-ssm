package com.shop.ssm.service;

import java.util.List;

import com.shop.ssm.po.User;

public interface UserService {
	/**
	 * 根据用户属性的值查询用户信息
	 * @param user
	 * @return
	 */
	public List<User> findUserBy(User user);

	/**
	 * 用户注册
	 */
	public void insertUser(User user);
}
