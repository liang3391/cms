package com.qianqian.product.service;



/**
 * Title:IProductMongoService
 * @Description:同步Mongo接口
 * @Create_by:yinsy
 * @Create_date:2014-6-12
 * @Last_Edit_By:
 * @Edit_Description:
 * @version:manager.maxtp 1.0
 */
public interface IProductMongoService {

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
	int modifyPrdRecycleBin(Long productCode, Integer version, Integer status) throws Exception;
	
	
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
	int modifyPrdEndStatus(Long productCode, Integer version, Integer status, Integer endStatus) throws Exception;
	
}
