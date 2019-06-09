package com.shop.ssm.service;

import java.util.List;
import java.util.Map;

import com.shop.ssm.po.Banner;
import com.shop.ssm.po.Product;
import com.shop.ssm.po.ProductCustom;
/**
 * 商品
 * @author Administrator
 *
 */
public interface ProductService {
	/**
	 * 获取商品的图片用于轮播
	 * @return
	 */
	public List<Banner> selectBannerImags();
	
	/**
	 * 获取指定页的商品并包括商品总数，当前页...
	 * @return
	 */
	public ProductCustom getPageData(int currentPage,int pageSize); 
	
	
}
