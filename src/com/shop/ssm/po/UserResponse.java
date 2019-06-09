package com.shop.ssm.po;

public class UserResponse extends User{
	private int status;//0:失败；1：成功
    private String message;//0：登录失败！；1：登录成功！
    private String token;
    private User data;
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public User getData() {
		return data;
	}
	public void setData(User data) {
		this.data = data;
	}
    
    
}
