package com.qianqian.common.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
/**
 * CMS的控制器，控制跳向模块管理界面
 * 
 * @Project : cms.maxtp
 * @Program Name: com.qianqian.common.controller.CMSController.java
 * @ClassName : CMSController
 * @Author : shenzhenxing
 * @CreateDate : 2014年5月28日 下午3:12:31
 */

@Controller
public class CMSController {

	/**
	 * 跳转至裸价体验管理界面的首页
	 * 
	 * @Method_Name : toNaked
	 * @return
	 * @return : String
	 * @Creation Date : 2014年5月28日 下午3:13:36
	 * @version : v1.00
	 * @Author : shenzhenxing
	 * @Update Date :
	 * @Update Author :
	 */
	@RequestMapping("toNaked")
	public ModelAndView toNaked() {
		return new ModelAndView("redirect:naked/first/getTopCarousel.htm");
	}
	/**
	 * 跳往免费体验管理的首页
	 *  @Method_Name    : toFree
	 *  @return 
	 *  @return         : ModelAndView
	 *  @Creation Date  : 2014年6月9日 下午5:36:52
	 *  @version        : v1.00
	 *  @Author         : shenzhenxing 
	 *  @Update Date    : 
	 *  @Update Author  :
	 */
	@RequestMapping("toFree")
	public ModelAndView toFree(){
		return new ModelAndView("redirect:free/first/getTopCarousel.htm");
	}

	/**
	 * 根据类目id来区分跳转到二级页面还是三级页面
	 * 
	 * @Method_Name : getCategoryPage
	 * @param categoryOne
	 * @param categoryTwo
	 * @return
	 * @return : ModelAndView
	 * @Creation Date : 2014年6月6日 上午10:41:29
	 * @version : v1.00
	 * @Author : shenzhenxing
	 * @Update Date :
	 * @Update Author :
	 */
	@RequestMapping("naked/getTopCarousel")
	public ModelAndView getCategoryPage(long categoryOne, long categoryTwo) {
		if (categoryTwo == 0) {
			// 跳往二级页面的首页
			return new ModelAndView(
					"redirect:/naked/second/getTopCarousel.htm?categoryId="
							+ categoryOne);
		} else {
			// 跳往三级页面的首页
			return new ModelAndView(
					"redirect:/naked/third/getTopCarousel.htm?categoryId="
							+ categoryTwo + "&categoryOne=" + categoryOne);
		}

	}
	@RequestMapping("free/getTopCarousel")
	public ModelAndView getCategoryFreePage(long categoryOne, long categoryTwo) {
		if (categoryTwo == 0) {
			// 跳往二级页面的首页
			return new ModelAndView(
					"redirect:/free/second/getTopCarousel.htm?categoryId="
							+ categoryOne);
		} else {
			// 跳往三级页面的首页
			return new ModelAndView(
					"redirect:/free/third/getTopCarousel.htm?categoryId="
							+ categoryTwo + "&categoryOne=" + categoryOne);
		}

	}

	/**
	 * 跳往页面管理首页
	 * 
	 * @Method_Name : toPage
	 * @return
	 * @return : String
	 * @Creation Date : 2014年6月6日 下午12:23:24
	 * @version : v1.00
	 * @Author : caozhifei
	 * @Update Date :
	 * @Update Author :
	 */
	@RequestMapping("toPage")
	public String toPage() {
		return "index";
	}
}
