package com.shop.ssm.mapper;

import java.util.List;
import java.util.Map;

import com.shop.ssm.po.Banner;
import com.shop.ssm.po.Product;

/**
 * 商品
 * @author Administrator
 *
 */
public interface ProductMapper {
	
	/**
	 * <select id="selectBannerImags" resultType="com.shop.ssm.po.Banner">
	 */
	public List<Banner> selectBannerImags();
	
	/**
	 * 获取商品总数
	 *   <select id="getProductCount" resultType="java.lang.Integer">
	 */
	public int getProductCount();
	
	/**
	 * 获取指定页的商品数据
	 *   <select id="getCurrentPageProduct" parameterType="java.util.Map" resultType="com.shop.ssm.po.Product">
	 */
	public List<Product> getCurrentPageProduct(Map<String,Integer> map);
}
