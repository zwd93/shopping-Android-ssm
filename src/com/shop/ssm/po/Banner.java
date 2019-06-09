package com.shop.ssm.po;

/**
 * 轮播商品中的图片
 * @author Administrator
 *
 */
public class Banner {
	private int id;
	private String name;
    private String imgUrl;
    private String description;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getImgUrl() {
		return imgUrl;
	}
	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	@Override
	public String toString() {
		return "Banner [id=" + id + ", name=" + name + ", imgUrl=" + imgUrl + ", description=" + description + "]";
	}
	
}
