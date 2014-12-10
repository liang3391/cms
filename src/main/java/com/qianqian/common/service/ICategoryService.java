package com.qianqian.common.service;

import java.util.List;

import com.qianqian.common.model.Category;
/**
 * 操作类目的接口
 * @Project 	: cms.maxtp
 * @Program Name: com.qianqian.naked.service.impl.ICategoryService.java
 * @ClassName	: ICategoryService 
 * @Author 		: shenzhenxing 
 * @CreateDate  : 2014年5月30日 下午4:43:43
 */
public interface ICategoryService {
	List<Category> getCategoryByParentId(Long categoryId);
	List<Category> getCategoryLevelOne();
}
