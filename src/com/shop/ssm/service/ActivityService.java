package com.shop.ssm.service;

import java.util.List;

import com.shop.ssm.po.HomeResult;

public interface ActivityService {
	/**
	 * 查询每个活动下的商品类别
	 * @return
	 */
	public List<HomeResult> selectActivityCategories();
}
