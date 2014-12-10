package com.qianqian.product.dao;

import java.util.Map;


/**
 * Title:IProductDao
 * @Description:产品详情接口
 * @Create_by:yinsy
 * @Create_date:2014-5-15
 * @Last_Edit_By:
 * @Edit_Description:
 * @version:detail.maxtp 1.0
 */
public interface IProductDao {
	
	/**
	 * 更新产品回收站状态
	 * @Create_by:yinsy
	 * @Create_date:2014-10-15
	 * @param productCode 产品Code
	 * @param version 产品版本
	 * @param status 产品回收站状态
	 * @return
	 * @throws Exception
	 * @Last_Edit_By:
	 * @Edit_Description:
	 * @Create_Version:goods.maxtp 1.0
	 */
	void modifyPrdRecycleBin(Long productCode, Integer version,Integer status) throws Exception;
	
	/**
	 * 修改活动结束状态
	 * @Create_by:yinsy
	 * @Create_date:2014-10-15
	 * @param productCode
	 * @param version
	 * @param status 活动状态
	 * @param endStatus 活动终止状态
	 * @return
	 * @throws Exception
	 * @Last_Edit_By:
	 * @Edit_Description:
	 * @Create_Version:goods.maxtp 1.0
	 */
	void modifyPrdEndStatus(Long productCode, Integer version, Integer status, Integer endStatus) throws Exception;
}
