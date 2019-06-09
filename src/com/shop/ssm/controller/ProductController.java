package com.shop.ssm.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.xml.ws.RequestWrapper;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.shop.ssm.po.Banner;
import com.shop.ssm.po.ProductCustom;
import com.shop.ssm.service.ProductService;

/**
 * 商品
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/product")
public class ProductController {

	@Resource(name="productServiceImpl")
	private ProductService  productService;
	/**
	 * 获取轮播数据
	 * @return
	 */
	@RequestMapping(value="/getBanner",method = {RequestMethod.GET,RequestMethod.POST})
	public @ResponseBody List<Banner> getBanner(){
		List<Banner> bannerImags = productService.selectBannerImags();
		System.out.println(bannerImags);
		return bannerImags;
	}
//	/**
//	 * 分页数据的获取
//	 * @return
//	 */
//	@RequestMapping(value="/getPageData",method = {RequestMethod.GET,RequestMethod.POST})
//	public @ResponseBody ProductCustom getPageData(@RequestParam(value="currentPage",required=true) int currentPage,
//			                         @RequestParam(value="pageSize",required=true) int pageSize){
//	
//		System.out.println(currentPage);
//		System.out.println(pageSize);
//		ProductCustom pageData = productService.getPageData(currentPage, pageSize);
//		System.out.println(pageData);
//		return pageData;	
//	}
	
	/**
	 * 分页数据的获取:restful风格的url
	 * @return
	 */
	@RequestMapping(value="/getPageData/{currentPage}/{pageSize}",method = {RequestMethod.GET,RequestMethod.POST})
	public @ResponseBody ProductCustom getPageDataRestFul(@PathVariable("currentPage") int currentPage,
			@PathVariable("pageSize") int pageSize){
	
		System.out.println(currentPage);
		System.out.println(pageSize);
		ProductCustom pageData = productService.getPageData(currentPage, pageSize);
		System.out.println(pageData);
		return pageData;	
	}

}
