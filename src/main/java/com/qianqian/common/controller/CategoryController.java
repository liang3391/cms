package com.qianqian.common.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.qianqian.common.model.Category;
import com.qianqian.common.service.ICategoryService;
/**
 * 类目相关的控制器
 * @Project 	: cms.maxtp
 * @Program Name: com.qianqian.common.controller.CategoryController.java
 * @ClassName	: CategoryController 
 * @Author 		: shenzhenxing 
 * @CreateDate  : 2014年6月6日 上午10:38:56
 */
@Controller
@RequestMapping("/category")
public class CategoryController {
	@Resource
	private ICategoryService categoryService;
	/**
	 * 
	 * 根据类目Id来获取子类目
	 *  @Method_Name    : getCategory
	 *  @param model
	 *  @param categoryId
	 *  @return 
	 *  @return         : String
	 *  @Creation Date  : 2014年6月6日 上午10:39:23
	 *  @version        : v1.00
	 *  @Author         : shenzhenxing 
	 *  @Update Date    : 
	 *  @Update Author  :
	 */
	@RequestMapping("getCategory")
	public String getCategory(Model model,long categoryId){
		List<Category>categorys;
		if(categoryId==0){
			//一级类目没有categoryid
			categorys=categoryService.getCategoryLevelOne();
		}
		else{
			categorys=categoryService.getCategoryByParentId(categoryId);
		}
		model.addAttribute("categorys", categorys);
		model.addAttribute("categoryId", categoryId);
		return null;
		
	}
}
