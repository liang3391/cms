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
import com.qianqian.common.model.CommodityAd;
import com.qianqian.common.model.ImageAd;
import com.qianqian.common.service.ICommodityAdService;
import com.qianqian.common.service.IImageAdService;
import com.qianqian.common.service.ILocationService;


/**
 * 裸价体验1级页面的控制器
 * 
 * @Project : cms.maxtp
 * @Program Name: com.qianqian.naked.controller.FirstController.java
 * @ClassName : FirstController
 * @Author : shenzhenxing
 * @CreateDate : 2014年5月28日 下午4:59:12
 */
@Controller
@RequestMapping("naked/first")
public class FirstController {

	// 顶部轮播的返回路径
	private static final String TOP_CAROUSEL = "naked/first/topCarousel";
	// 焦点轮播的返回路径
	private static final String FOCUS_CAROUSEL = "naked/first/focusCarousel";
	// 类目通栏的路径
	private static final String CATEGORY_COLUMN = "naked/first/categoryColumn";
	// 右侧轮播
	private static final String RIGHT_CAROUSEL = "naked/first/rightCarousel";
	// 6个标准广告
	private static final String IMAGE6AD = "naked/first/image6Ad";
	// 类目钻展
	private static final String CATEGORY_SHOW = "naked/first/categoryShow";

	@Resource
	private IImageAdService imageAdService;
	@Resource
	private ICommodityAdService commodityAdService;
	@Resource
	private IMapAdTaskService mapAdTaskService;
	@Resource
	private ILocationService locationService;
	private Logger log = LoggerFactory.getLogger(FirstController.class);
	/**
	 * pageType :3  裸价体验首页
	 * locationType：1，顶部轮播
	 * 	             2，焦点轮播
	 *               3，类目钻展
	 *               4，类目通栏
	 *               5，右侧轮播
	 *               6，右侧标准广告位
	 */
	/**
	 * 获得一级页面的顶部轮播图
	 * 
	 * @Method_Name : getTopCarousel
	 * @return
	 * @return : String
	 * @Creation Date : 2014年5月28日 下午4:48:50
	 * @version : v1.00
	 * @Author : shenzhenxing
	 * @Update Date :
	 * @Update Author :
	 */
	@RequestMapping("getTopCarousel")
	public String getTopCarousel(Model model) {
		AdLocation location = new AdLocation();
		location.setPageType(3);
		location.setLocationType(1);
		List<ImageAd> imageAds = imageAdService.getImageAdList(location);
		log.debug("imageAds size="+imageAds.size());
		model.addAttribute("imageAds", imageAds);
		return TOP_CAROUSEL;
	}

	

	/**
	 * 获得焦点轮播
	 * 
	 * @Method_Name : getFocusCarousel
	 * @return
	 * @return : String
	 * @Creation Date : 2014年5月28日 下午4:56:26
	 * @version : v1.00
	 * @Author : shenzhenxing
	 * @Update Date :
	 * @Update Author :
	 */
	@RequestMapping("getFocusCarousel")
	public String getFocusCarousel(Model model) {
		AdLocation location = new AdLocation();
		location.setPageType(3);
		location.setLocationType(2);
		List<ImageAd> imageAds = imageAdService.getImageAdList(location);
		model.addAttribute("imageAds", imageAds);
		return FOCUS_CAROUSEL;

	}

	/**
	 * 得到栏目通栏
	 * 
	 * @Method_Name : getCategoryColumn
	 * @return
	 * @return : String
	 * @Creation Date : 2014年5月28日 下午5:02:53
	 * @version : v1.00
	 * @Author : shenzhenxing
	 * @Update Date :
	 * @Update Author :
	 */
	@RequestMapping("getCategoryColumn")
	public String getCategoryColumn(Model model,String locationFloor) {
		AdLocation location = new AdLocation();
		location.setPageType(3);
		location.setLocationType(4);
		int floor;
		if(locationFloor==null){
			floor=1;
		}
		floor=Integer.parseInt(locationFloor);
		location.setFloor(floor);
		List<ImageAd> imageAds = imageAdService.getImageAdList(location);
		int count =locationService.getLocationCount(4,3,0);
		model.addAttribute("count", count);
		model.addAttribute("imageAds", imageAds);
		model.addAttribute("locationFloor", locationFloor);
		return CATEGORY_COLUMN ;
	}

	/**
	 * 获得类目钻展
	 * @Method_Name : getCommodityAd
	 * @param locationFloor
	 *            楼层
	 * @param model
	 * @return
	 * @return : String
	 * @Creation Date : 2014年5月28日 下午5:38:13
	 * @version : v1.00
	 * @Author : shenzhenxing
	 * @Update Date :
	 * @Update Author :
	 */
	@RequestMapping("getCategoryShow")
	public String getCommodityAd(int locationFloor, Model model) {
		AdLocation location = new AdLocation();
		location.setPageType(3);
		location.setLocationType(3);
		location.setFloor(locationFloor);
		List<CommodityAd> ads = commodityAdService
				.getCommodityAdListByLocation(location);
		model.addAttribute("ads", ads);
		return CATEGORY_SHOW;
	}

	/**
	 * 获得右侧的两个轮播广告
	 * 
	 * @Method_Name : getImage2Ad
	 * @return
	 * @return : String
	 * @Creation Date : 2014年5月28日 下午4:57:52
	 * @version : v1.00
	 * @Author : shenzhenxing
	 * @Update Date :
	 * @Update Author :
	 */
	@RequestMapping("getRightCarousel")
	public String getImage2Ad(Model model, int locationFloor) {
		AdLocation location = new AdLocation();
		location.setPageType(3);
		location.setLocationType(5);
		location.setFloor(locationFloor);
		List<ImageAd> imageAds = imageAdService.getImageAdList(location);
	
		model.addAttribute("imageAds", imageAds);
		model.addAttribute("locationFloor", locationFloor);
		return RIGHT_CAROUSEL;
	}

	/**
	 * 获得右侧的六个标准广告
	 * 
	 * @Method_Name : getImage6Ad
	 * @return
	 * @return : String
	 * @Creation Date : 2014年5月28日 下午4:58:39
	 * @version : v1.00
	 * @Author : shenzhenxing
	 * @Update Date :
	 * @Update Author :
	 */
	@RequestMapping("getImage6Ad")
	public String getImage6Ad(Model model,int locationFloor) {
		AdLocation location = new AdLocation();
		location.setPageType(3);
		location.setLocationType(6);
		location.setFloor(locationFloor);
		
		List<ImageAd> imageAds = imageAdService.getImageAdList(location);
		int count =locationService.getLocationCount(6,3,0);
		model.addAttribute("imageAds", imageAds);
		model.addAttribute("count", count);
		model.addAttribute("locationFloor", locationFloor);
		return IMAGE6AD;

	}

}
