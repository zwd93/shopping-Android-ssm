package com.shop.ssm.po;

import java.util.List;

public class HomeResult extends Activity{
	
	List<Categories> categories;

	public List<Categories> getCategories() {
		return categories;
	}

	public void setCategories(List<Categories> categories) {
		this.categories = categories;
	}

	@Override
	public String toString() {
		return "HomeResult [categories=" + categories + "]";
	}
}
