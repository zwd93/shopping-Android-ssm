package com.shop.ssm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.shop.ssm.po.User;
import com.shop.ssm.po.UserCustom;
import com.shop.ssm.po.UserResponse;
import com.shop.ssm.service.UserService;

/**
 * 用户控制层
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	/**
	 *用户登录：传入json数据，返回json数据
	 * @param user
	 * @return
	 */
	@RequestMapping(value = "/login",method={RequestMethod.GET,RequestMethod.POST})
	public @ResponseBody UserResponse login(@RequestBody User user){
		System.out.println(user);
		List<User> list = userService.findUserBy(user);
		UserResponse userResponse = new UserResponse();
		if(list.isEmpty()){
			userResponse.setStatus(0);
			userResponse.setMessage("登录失败！");
			userResponse.setToken("0");	
			
		}
		else{
			userResponse.setStatus(1);
			userResponse.setMessage("登录成功！");
			userResponse.setToken("1");	
		}
		userResponse.setData(user);
		System.out.println(userResponse);
		return userResponse;
	}
	
	/**
	 * 用户注册
	 * @param user
	 * @return
	 */
	@RequestMapping(value = "/register",method={RequestMethod.GET,RequestMethod.POST})
	public @ResponseBody UserResponse register(@RequestBody UserCustom userCustom){
		
		UserResponse userResponse = new UserResponse();
		System.out.println("post:" + userCustom);
		//1.先判断用户名是否已存在
		User userExist = new User();
		userExist.setPhone(userCustom.getPhone());
		System.out.println(userExist);
		List<User> list = userService.findUserBy(userExist);
		System.out.println("listsize:"+list.size());
		if(list.size() > 0){
			System.out.println("该手机号已存在！");
			System.out.println("list:"+list);
			userResponse.setStatus(0);
			userResponse.setMessage("该手机号已存在！");
			userResponse.setToken("0");
			return userResponse;
		}
		//2.判断两次密码是否一样
		else if(userCustom.getSecondPassword().equals(userCustom.getPassword()) == false){
			userResponse.setStatus(0);
			userResponse.setMessage("两次输入的密码不一致！");
			userResponse.setToken("0");
			System.out.println("两次输入的密码不一致！");
			return userResponse;
		}
		else{
			User user = new User();
			user.setUsername(userCustom.getUsername());
			user.setPhone(userCustom.getPhone());
			user.setPassword(userCustom.getPassword());
			user.setEmail(userCustom.getEmail());
			System.out.println(user);
			//插入用户
			userService.insertUser(user);
			System.out.println(user);
			userResponse.setStatus(1);
			userResponse.setMessage("注册成功！");
			System.out.println("注册成功!");
			userResponse.setToken("1");
			userResponse.setData(user);
			return userResponse;	
		}		
	}	
}
