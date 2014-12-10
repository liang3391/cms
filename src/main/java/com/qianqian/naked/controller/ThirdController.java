package com.qianqian.naked.controller;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.qianqian.cms.service.IMapAdTaskService;
import com.qianqian.common.model.AdLocation;
import com.qianqian.common.model.Category;
import com.qianqian.common.model.CommodityAd;
import com.qianqian.common.model.ImageAd;
import com.qianqian.common.service.ICategoryService;
import com.qianqian.common.service.ICommodityAdService;
import com.qianqian.common.service.IImageAdService;

/**
 * 裸价体验三级页面的控制器
 * @Project 	: cms.maxtp
 * @Program Name: com.qianqian.naked.controller.ThirdController.java
 * @ClassName	: FirstController 
 * @Author 		: shenzhenxing 
 * @CreateDate  : 2014年5月28日 下午4:59:12
 */
@Controller
@RequestMapping("naked/third")
public class ThirdController {
	/**
	 * 获取顶部轮播的返回路径
	 */
	private static final String TOP_CAROUSEL="naked/third/topCarousel";
	private  static final String RECOMMEND_PRODUCT ="naked/third/recommendProduct";
	@Resource
	private IImageAdService imageAdService;
	@Resource
	private ICommodityAdService commodityAdService;
	@Resource
	private IMapAdTaskService mapAdTaskService;
	@Resource
	 private ICategoryService categoryService;
	private Logger log=LoggerFactory.getLogger(ThirdController.class);
	/**
	 * pageType :301001 裸价体验三级页面
	 * locationType：1，顶部轮播
	 *               7，最热商品推荐
	 */
	/**
	 * 获得三级页面的顶部轮播图
	 *  @Method_Name    : getTopCarousel
	 *  @return 
	 *  @return         : String
	 *  @Creation Date  : 2014年5月28日 下午4:48:50
	 *  @version        : v1.00
	 *  @Author         : shenzhenxing 
	 *  @Update Date    : 
	 *  @Update Author  :
	 */
	@RequestMapping("getTopCarousel")
	public String getTopCarousel(long categoryOne,long categoryId,Model model){
		AdLocation location=new AdLocation();
		location.setCategory(categoryId);
		location.setLocationType(1);
		location.setPageType(301001);
		location.setFloor(0);
		List<ImageAd> imageAds=imageAdService.getImageAdList(location);
		List<Category>categorys=categoryService.getCategoryByParentId(categoryOne);
		model.addAttribute("imageAds", imageAds);
		model.addAttribute("categoryId", categoryId);
		model.addAttribute("categoryOne", categoryOne);
		model.addAttribute("categorys", categorys);
		return TOP_CAROUSEL;
		
	}
	
	
	
	/**
	 * 获得最热商品推荐
	 *  @Method_Name    : getCommodityAd
	 *  @param categoryId
	 *  @param model
	 *  @return 
	 *  @return         : String
	 *  @Creation Date  : 2014年5月28日 下午5:11:55
	 *  @version        : v1.00
	 *  @Author         : shenzhenxing 
	 *  @Update Date    : 
	 *  @Update Author  :
	 */
	@RequestMapping("getRecommendProduct")
	public String getCommodityAd(long categoryOne,long categoryId,Model model){
		AdLocation adLocation=new AdLocation();
		adLocation.setLocationType(7);
		adLocation.setPageType(301001);
		adLocation.setCategory(categoryId);
		adLocation.setFloor(0);
		List<CommodityAd> commodityAds=commodityAdService.getCommodityAdListByLocation(adLocation);
		List<Category>categorys=categoryService.getCategoryByParentId(categoryOne);
		log.debug("三级类目的条数"+categorys.size());;
		model.addAttribute("categorys",categorys);
		model.addAttribute("commodityAds", commodityAds);
		model.addAttribute("categoryId", categoryId);
		model.addAttribute("categoryOne", categoryOne);
		
		return RECOMMEND_PRODUCT;
	}
	
}
