package com.qianqian.common.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qianqian.common.mapper.CategoryMapper;
import com.qianqian.common.model.Category;
import com.qianqian.common.model.CategoryExample;
import com.qianqian.common.service.ICategoryService;
@Service("categoryService")
public class CategoryServiceImpl implements ICategoryService {
	@Resource
	private CategoryMapper categoryMapper;
	@Override
	public List<Category> getCategoryByParentId(Long categoryId) {
		CategoryExample example=new CategoryExample();
		example.createCriteria().andParentIdEqualTo(categoryId);
		List<Category>categorys=categoryMapper.selectByExample(example);
		return categorys;
	}
	@Override
	public List<Category> getCategoryLevelOne() {
		CategoryExample example=new CategoryExample();
		example.createCriteria().andParentCategoryNameIsNull().andParentIdIsNull();
		List<Category>categorys=categoryMapper.selectByExample(example);
		return categorys;
	
	}

}
