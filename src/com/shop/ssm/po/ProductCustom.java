package com.shop.ssm.po;

import java.util.List;

public class ProductCustom {
	private int totalCount;     //商品数量
    private int currentPage;    //当前页面
    private int totalPage;      //页面数量
    private int pageSize;       //页面中展示商品容量
    private List<Product> list;
	public int getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public List<Product> getList() {
		return list;
	}
	public void setList(List<Product> list) {
		this.list = list;
	}
	@Override
	public String toString() {
		return "ProductCustom [totalCount=" + totalCount + ", currentPage=" + currentPage + ", totalPage=" + totalPage
				+ ", pageSize=" + pageSize + ", list=" + list + "]";
	}

}
