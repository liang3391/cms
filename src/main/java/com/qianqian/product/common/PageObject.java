package com.qianqian.product.common;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;

public class PageObject {
	
	public static final int DEFAULT_PAGE_SIZE = 20;	//默认每页记录数
	
	private int currentPage = 1; // 当前页数

	private int pageSize = DEFAULT_PAGE_SIZE; // 每页记录数

	private List<?> list; // 具体的记录集合

	private int totalCount;	//总记录数
	
	private int totalPage; // 所有页数
	
	public PageObject(){
		
	}
	
	/**
	 * 构造函数
	 * @param list 查询集合
	 * @param pageBounds 分页插件
	 */
	public PageObject(List<?> list,PageBounds pageBounds,Integer pageNo) {
		this.list = list;
		PageList<?> pageList = (PageList<?>) list;
		currentPage = pageNo;
		totalCount = pageList.getPaginator().getTotalCount();
		totalPage = pageList.getPaginator().getTotalPages();
	}

	/**
	 * 获取当前页数
	 * @Create_by:yinsy
	 * @Create_date:2014-6-20
	 * @param request
	 * @return
	 * @Last_Edit_By:
	 * @Edit_Description:
	 * @Create_Version:manager.maxtp 1.0
	 */
	public static int getPageNum(HttpServletRequest request) {
		int page = 0;
		try {
			String pageNum = request.getParameter("pagenum");
			if (pageNum==null||"".equals(pageNum)) {
				page = 1;
			}else {
				page = Integer.parseInt(request.getParameter("pagenum"));
			}
		} catch (Exception e) {
			page = 1;
		}
		return page;
	}


	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public List<?> getList() {
		return list;
	}

	public void setList(List<?> list) {
		this.list = list;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}
}
