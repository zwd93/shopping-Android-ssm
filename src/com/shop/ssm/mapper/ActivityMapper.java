package com.shop.ssm.mapper;

import java.util.List;

import com.shop.ssm.po.HomeResult;

public interface ActivityMapper {
	/**
	 * 查询活动下的类别：一对多
	 *  <select id="selectActivityCategories" resultMap="activityAndCategoriesResultMap">
	 */
	
	public List<HomeResult> selectActivityCategories();

}
