package com.qianqian.brand.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qianqian.brand.mapper.*; 
import com.qianqian.brand.model.PrdBrand;
import com.qianqian.brand.model.PrdCategory;
import com.qianqian.brand.service.IBrandCategoryService;

/**
 * @author YangWan
 *
 */
@Service("iBrandCategoryService")
public class BrandCategoryServiceImpl implements IBrandCategoryService {

	@Resource
	private PrdCategoryMapper prdCategoryMapper;
 
	@Resource
	private PrdBrandMapper prdBrandMapper;
	
	/**
	 * 操作类目表
	 */
	@Override
	public List<PrdCategory> queryCategorysByParentId(Long parentId) {
		// TODO Auto-generated method stub
		return prdCategoryMapper.queryByParentId(parentId);
	}
	 
	/**
	 * 操作品牌表
	 */
	@Override
	public List<PrdBrand> queryPrdbrands(PrdBrand prdBrand) {
		// TODO Auto-generated method stub
		return prdBrandMapper.queryByPrdBrand(prdBrand);
	}
	
	 

}
