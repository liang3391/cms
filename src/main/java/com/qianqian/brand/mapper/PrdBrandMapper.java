/**
 * 
 */
package com.qianqian.brand.mapper;

import java.util.List;

import com.qianqian.brand.model.PrdBrand;

/**
 * 品牌基本信息DB操作类
 * 
 * @author YangWan
 * 
 */
public interface PrdBrandMapper {

	/**
	 * 根据条件查询品牌信息
	 * @param prdBrand
	 * @return
	 */
	public List<PrdBrand> queryByPrdBrand(PrdBrand prdBrand);
	
}
