package com.shop.ssm.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.shop.ssm.po.HomeResult;
import com.shop.ssm.service.ActivityService;

/**
 * 活动
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/activity")
public class ActivityController {
	
	@Resource(name="activityServiceImpl")
	private ActivityService activityService;
	
	@RequestMapping(value = "/getActivityCategories",method={RequestMethod.GET,RequestMethod.POST})
	public @ResponseBody List<HomeResult> getActivityCategories(){
		List<HomeResult> lists = activityService.selectActivityCategories();
		return lists;
	}
}
