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
import com.qianqian.common.service.ILocationService;

/**
 * 裸价体验1级页面的控制器
 * @Project 	: cms.maxtp
 * @Program Name: com.qianqian.naked.controller.FirstController.java
 * @ClassName	: FirstController 
 * @Author 		: shenzhenxing 
 * @CreateDate  : 2014年5月28日 下午4:59:12
 */
@Controller
@RequestMapping("naked/second")
public class SecondController {
	/**
	 * 获取顶部轮播的返回路径
	 */
	private static final String TOP_CAROUSEL="naked/second/topCarousel";
	/**
	 * 获得焦点轮播的返回路径
	 */
	private  static final String FOCUS_CAROUSEL ="naked/second/focusCarousel";
	private  static final String RECOMMEND_PRODUCT ="naked/second/recommendProduct";
	// 右侧轮播
	private static final String RIGHT_CAROUSEL = "naked/second/rightCarousel";
	// 6个标准广告
	private static final String IMAGE6AD = "naked/second/image6Ad";

	@Resource
	private IImageAdService imageAdService;
	@Resource
	private ICommodityAdService commodityAdService;
	@Resource
	private IMapAdTaskService mapAdTaskService;
	@Resource
	private ICategoryService categoryService;
	@Resource
	private ILocationService locationService;
	private Logger log=LoggerFactory.getLogger(SecondController.class);
	/**
	 * pageType :301 裸价体验二级页面
	 * locationType：1，顶部轮播
	 * 	             2，焦点轮播
	 *               5，右侧轮播
	 *               6，右侧标准广告位
	 *               7，最热商品推荐
	 */
	/**
	 * 获得一级页面的顶部轮播图
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
	public String getTopCarousel(Model model,long categoryId){
		AdLocation location=new AdLocation();
		location.setCategory(categoryId);
		location.setLocationType(1);
		location.setPageType(301);
		location.setFloor(0);
		log.debug("adLocation="+location.toString());
		List<ImageAd> imageAds=imageAdService.getImageAdList(location);
		List<Category>categorys=categoryService.getCategoryByParentId(categoryId);
		model.addAttribute("imageAds", imageAds);
		model.addAttribute("categoryId", categoryId);
		model.addAttribute("categorys", categorys);
		return TOP_CAROUSEL;
	}
	
	/**
	 * 获得焦点轮播
	 *  @Method_Name    : getFocusCarousel
	 *  @return 
	 *  @return         : String
	 *  @Creation Date  : 2014年5月28日 下午4:56:26
	 *  @version        : v1.00
	 *  @Author         : shenzhenxing 
	 *  @Update Date    : 
	 *  @Update Author  :
	 */
	@RequestMapping("getFocusCarousel")
	public String getFocusCarousel(Model model,long categoryId){
		AdLocation location=new AdLocation();
		location.setCategory(categoryId);
		location.setLocationType(2);
		location.setPageType(301);
		location.setFloor(0);
		List<ImageAd> imageAds=imageAdService.getImageAdList(location);
		List<Category>categorys=categoryService.getCategoryByParentId(categoryId);
		model.addAttribute("categorys", categorys);
		model.addAttribute("imageAds", imageAds);
		model.addAttribute("categoryId", categoryId);
		return FOCUS_CAROUSEL;
		
	}
	@RequestMapping("getRecommendProduct")
	public String getCommodityAd(Long categoryId,Model model){
		AdLocation adLocation=new AdLocation();
		adLocation.setLocationType(7);
		adLocation.setPageType(301);
		adLocation.setCategory(categoryId);
		adLocation.setFloor(0);
		List<CommodityAd> commodityAds=commodityAdService.getCommodityAdListByLocation(adLocation);
		List<Category>categorys=categoryService.getCategoryByParentId(categoryId);
		model.addAttribute("categorys", categorys);
		model.addAttribute("commodityAds", commodityAds);
		model.addAttribute("categoryId", categoryId);
		
		return RECOMMEND_PRODUCT;
	}
/**
 * 获得右侧的轮播广告
 *  @Method_Name    : getImage2Ad
 *  @param model
 *  @param categoryId
 *  @param locationFloor
 *  @return 
 *  @return         : String
 *  @Creation Date  : 2014年6月3日 下午3:14:27
 *  @version        : v1.00
 *  @Author         : shenzhenxing 
 *  @Update Date    : 
 *  @Update Author  :
 */
	@RequestMapping("getRightCarousel")
	public String getImage2Ad(Model model,long categoryId,int locationFloor){
		AdLocation location=new AdLocation();
		location.setCategory(categoryId);
		location.setLocationType(5);
		location.setPageType(301);
		location.setFloor(locationFloor);
		List<ImageAd> imageAds=imageAdService.getImageAdList(location);
		List<Category>categorys=categoryService.getCategoryByParentId(categoryId);
		model.addAttribute("categorys", categorys);
		model.addAttribute("imageAds", imageAds);
		model.addAttribute("categoryId", categoryId);
		model.addAttribute("locationFloor", locationFloor);
		return RIGHT_CAROUSEL;
	}
	/**
	 * 获得右侧的六个标准广告
	 *  @Method_Name    : getImage6Ad
	 *  @return 
	 *  @return         : String
	 *  @Creation Date  : 2014年5月28日 下午4:58:39
	 *  @version        : v1.00
	 *  @Author         : shenzhenxing 
	 *  @Update Date    : 
	 *  @Update Author  :
	 */
	@RequestMapping("getImage6Ad")
	public String getImage6Ad(Model model,long categoryId,int locationFloor){
		AdLocation location=new AdLocation();
		location.setCategory(categoryId);
		location.setLocationType(6);
		location.setPageType(301);
		location.setFloor(locationFloor);
		List<ImageAd> imageAds=imageAdService.getImageAdList(location);
		List<Category>categorys=categoryService.getCategoryByParentId(categoryId);
		int count =locationService.getLocationCount(6,301,categoryId);
		model.addAttribute("categorys", categorys);
		model.addAttribute("imageAds", imageAds);
		model.addAttribute("categoryId",categoryId);
		model.addAttribute("count", count);
		model.addAttribute("locationFloor",locationFloor);
		return IMAGE6AD;
		
	}
	
}
