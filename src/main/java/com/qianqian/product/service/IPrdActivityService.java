package com.qianqian.product.service;

import com.qianqian.product.dto.PrdActivityDTO;
import com.qianqian.product.model.ProductPreview;

/**
 * Title:IPrdActivityService
 * @Description:产品活动接口
 * @Create_by:yinsy
 * @Create_date:2014-6-18
 * @Last_Edit_By:
 * @Edit_Description:
 * @version:manager.maxtp 1.0
 */
public interface IPrdActivityService {
	
	/**
	 * 获取产品活动信息
	 * @Create_by:yinsy
	 * @Create_date:2014-6-19
	 * @param prdCode 产品编号
	 * @param ver 版本号
	 * @return
	 * @Last_Edit_By:
	 * @Edit_Description:
	 * @Create_Version:manager.maxtp 1.0
	 */
	PrdActivityDTO getPrdActivity(Long prdCode,Integer ver) throws Exception;
	
	/**
	 * 新增或修改活动信息
	 * @Create_by:yinsy
	 * @Create_date:2014-6-19
	 * @param activityDTO 活动Dto
	 * @param flag 标识，0，保存，1提交复核活动
	 * @return
	 * @Last_Edit_By:
	 * @Edit_Description:
	 * @Create_Version:manager.maxtp 1.0
	 */
	Integer addOrModifyPrdActivity(PrdActivityDTO activityDTO,Integer flag) throws Exception;
	
	/**
	 * 获取活动状态
	 * @Create_by:yinsy
	 * @Create_date:2014-6-30
	 * @param prdCode
	 * @param ver
	 * @return
	 * @throws Exception
	 * @Last_Edit_By:
	 * @Edit_Description:
	 * @Create_Version:goods.maxtp 1.0
	 */
	Integer getPrdActStatus(Long prdCode,Integer ver) throws Exception;
	
	/**
	 * 获取活动预览信息
	 * @Create_by:yinsy
	 * @Create_date:2014-9-19
	 * @param activityDTO
	 * @return
	 * @throws Exception
	 * @Last_Edit_By:
	 * @Edit_Description:
	 * @Create_Version:goods.maxtp 1.0
	 */
	ProductPreview toActPrev(Long productCode, Integer version,PrdActivityDTO activityDTO) throws Exception;
	
	/**
	 * 获取产品活动详情
	 * @Create_by:yinsy
	 * @Create_date:2014-9-16
	 * @param productCode 产品编码
	 * @param version 版本号
	 * @return
	 * @throws Exception
	 * @Last_Edit_By:
	 * @Edit_Description:
	 * @Create_Version:goods.maxtp 1.0
	 */
	ProductPreview getActPrev(Long productCode,Integer version) throws Exception;

	/**
	 * 活动迁出新版本
	 * @Method_Name insertNewPrdActFromOld
	 * @param productCode 产品编码
	 * @param oldVersion 旧版本号
	 * @param newVersion 新版本号
	 * @return
	 * @throws Exception
	 * @Creation 2014-9-9下午01:43:05
	 * @Version v1.0.0
	 * @author wangchangsheng
	 * @UpdateDate:
	 * @UpdateAuthor:
	 */
	Integer insertNewPrdActFromOld(Long productCode, int oldVersion,int newVersion) throws Exception;
}
