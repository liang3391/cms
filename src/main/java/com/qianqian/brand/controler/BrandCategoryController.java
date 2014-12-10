/**
 * 
 */
package com.qianqian.brand.controler;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.qianqian.brand.model.PrdBrand;
import com.qianqian.brand.model.PrdCategory;
import com.qianqian.brand.service.IBrandCategoryService;

/**
 * 商品发布时，选择品牌、类目信息
 * 
 * @author YangWan /bcCtrl/querybyLetter
 */
@Controller
@RequestMapping("/bcCtrl")
public class BrandCategoryController {

	@Resource
	private IBrandCategoryService iBrandCategoryService;

	/**
	 * 默认查询第一页的首字母品牌列表
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/queryBrandList", method = RequestMethod.GET)
	public ModelAndView queryBrandList(HttpServletRequest request,
			HttpServletResponse response) {
		PrdBrand prdBrand = new PrdBrand();
		prdBrand.setStartLetter("a");
		List<PrdBrand> list = iBrandCategoryService.queryPrdbrands(prdBrand);
		PrdBrand prdBrand2 = new PrdBrand();
		prdBrand2.setStartLetter("b");
		List<PrdBrand> list2 = iBrandCategoryService.queryPrdbrands(prdBrand);  
		
		return new ModelAndView("choiceBrand.jsp");
	}

	/**
	 * 根据品牌号查询品牌信息
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/querybyBrandId", method = RequestMethod.GET)
	public ModelAndView querybyBrandId(HttpServletRequest request,
			HttpServletResponse response) {
		String brandId = request.getParameter("brandId");
		PrdBrand prdBrand = new PrdBrand();
		prdBrand.setId(Long.valueOf(brandId));
		List<PrdBrand> list = iBrandCategoryService.queryPrdbrands(prdBrand);
		PrdBrand PrdBrand2 = null;
		if (list != null) {
			PrdBrand2 = list.get(0);
		}
		return new ModelAndView("choiceBrand.jsp");
	}

	/**
	 * 根据首字母查询品牌信息
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/querybyLetter", method = RequestMethod.GET)
	public ModelAndView querybyLetter(HttpServletRequest request,
			HttpServletResponse response) {
		String letter = request.getParameter("letter");
		PrdBrand prdBrand = new PrdBrand();
		prdBrand.setStartLetter(letter);
		List<PrdBrand> list = iBrandCategoryService.queryPrdbrands(prdBrand);
		
		return new ModelAndView("choiceBrand.jsp");
	}

	/**
	 * 从品牌跳入到选择类目页面
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/nextCategoryView", method = RequestMethod.POST)
	public ModelAndView nextCategoryView(HttpServletRequest request,
			HttpServletResponse response) {
		// 获取品牌信息 不全
		String pbname = request.getParameter("PrdBrandname");

		// 查询一级类目信息
		List<PrdCategory> pcList = iBrandCategoryService
				.queryCategorysByParentId(Long.valueOf(0));
		return new ModelAndView("");
	}

	/**
	 * 根据parentId查询分类信息
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/queryCategory", method = RequestMethod.POST)
	public void queryCategory(HttpServletRequest request,
			HttpServletResponse response) {

		String parentId = request.getParameter("parentId");
		List<PrdCategory> list = iBrandCategoryService
				.queryCategorysByParentId(Long.valueOf(parentId));
	}

}
