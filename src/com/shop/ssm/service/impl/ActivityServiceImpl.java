package com.shop.ssm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shop.ssm.mapper.ActivityMapper;
import com.shop.ssm.po.HomeResult;
import com.shop.ssm.service.ActivityService;
/**
 * 活动
 * @author Administrator
 *
 */
@Service("activityServiceImpl")
public class ActivityServiceImpl implements ActivityService{
	@Autowired
	ActivityMapper activityMapper;
	/**
	 * 查询每个活动下的商品类别
	 */
	@Override
	public List<HomeResult> selectActivityCategories() {
		return activityMapper.selectActivityCategories();
	}
}
