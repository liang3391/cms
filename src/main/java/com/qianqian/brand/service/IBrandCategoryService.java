/**
 * 
 */
package com.qianqian.brand.service;

import java.util.List;

import com.qianqian.brand.model.PrdBrand;
import com.qianqian.brand.model.PrdCategory;

/**
 * @author YangWan
 * 
 */
public interface IBrandCategoryService  {

	/**
	 * 查询子类目信息
	 * 
	 * @param parentId
	 * @return
	 */
	public List<PrdCategory> queryCategorysByParentId(Long parentId);


	/**
	 * 查詢品牌信息
	 * 
	 * @param brandId
	 * @return
	 */
	public List<PrdBrand> queryPrdbrands(PrdBrand prdBrand);

}
