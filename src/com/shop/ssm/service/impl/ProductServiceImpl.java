package com.shop.ssm.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.shop.ssm.mapper.ProductMapper;
import com.shop.ssm.po.Banner;
import com.shop.ssm.po.Product;
import com.shop.ssm.po.ProductCustom;
import com.shop.ssm.service.ProductService;

/**
 * 商品实现类
 * 
 * @author Administrator
 *
 */
@Service
public class ProductServiceImpl implements ProductService {

	// @Autowired
	@Resource(name = "productMapper")
	private ProductMapper productMapper;

	@Override
	public List<Banner> selectBannerImags() {
		return productMapper.selectBannerImags();
	}

	// (pageNow-1)*pageSize,
	// pageSize);
	@Override
	public ProductCustom getPageData(int currentPage, int pageSize) {

		// 返回当前页的信息和数据
		ProductCustom productCustom = new ProductCustom();

		// 防止无限上一页（1的上一页）
		currentPage = currentPage < 1 ? 1 : currentPage;
		// 商品总数
		int totalCount = productMapper.getProductCount();
		//总页数
		int totalPage = totalCount % pageSize == 0 ? totalCount / pageSize : (totalCount / pageSize + 1);	
		//防止无限下一页
		currentPage = currentPage > totalPage ? totalPage : currentPage;		
						
		// 当前页面的商品记录
		Map<String, Integer> map = new HashMap<>();
		map.put("startData", (currentPage - 1) * pageSize);
		map.put("pageSize", pageSize);
		List<Product> pageProduct = productMapper.getCurrentPageProduct(map);
		
		productCustom.setTotalCount(totalCount);
		productCustom.setCurrentPage(currentPage);
		productCustom.setPageSize(pageSize);
		productCustom.setTotalPage(totalPage);		
		
		productCustom.setList(pageProduct);

		return productCustom;
	}
}
