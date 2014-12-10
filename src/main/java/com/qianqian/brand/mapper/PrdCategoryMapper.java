/**
 * 
 */
package com.qianqian.brand.mapper;

import java.util.List;

import com.qianqian.brand.model.PrdCategory;

/**
 * 类目信息
 * @author YangWan
 *
 */
public interface PrdCategoryMapper {
	
	/**
	 * 根据父ID查询,如果是一级分类则传入为0
	 * @param parentId
	 * @return
	 */
	public List<PrdCategory> queryByParentId(Long parentId);
	

}
