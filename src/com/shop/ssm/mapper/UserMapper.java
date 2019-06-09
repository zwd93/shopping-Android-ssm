package com.shop.ssm.mapper;

import java.util.List;

import com.shop.ssm.po.User;

/**
 * 用户
 * @author Administrator
 *
 */
public interface UserMapper {
	/**
	 * 根据用户属性值查找用户
	 *  <select id="findUserBy" parameterType="com.shop.ssm.po.User" resultType="com.shop.ssm.po.User" >
	 */
	public List<User> findUserBy(User user);
	
	/**
	 * 插入用户
	 *  <insert id="insertUser" parameterType="com.shop.ssm.po.User">
	 */
	public void insertUser(User user);
}
