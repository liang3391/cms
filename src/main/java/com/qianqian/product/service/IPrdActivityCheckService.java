package com.qianqian.product.service;

import java.util.List;

import com.qianqian.product.common.PageObject;
import com.qianqian.product.dto.PrdActivityDTO;
import com.qianqian.product.model.ProductActivityWrapper;

/**
 * 复核活动管理接口
 * @Name IPrdActivityCheckService
 * @Creation 2014-8-12
 * @Version 
 * @author wangchangsheng
 * @UpdateDate:
 * @UpdateAuthor:
 */
public interface IPrdActivityCheckService {
	

	/**
	 * 查询复核活动管理列表(待售)
	 * @Method_Name getPrdActCheckListForSale
	 * @param act
	 * @param pageNo
	 * @return
	 * @Creation 2014-8-8上午10:10:04
	 * @Version 
	 * @author wangchangsheng
	 * @throws Exception 
	 * @Update Date:
	 * @Update Author:
	 */
	PageObject getPrdActCheckList(ProductActivityWrapper act, int pageNo) throws Exception;

	/**
	 * 修改活动运营确定状态
	 * @Method_Name modifyActivityConfirmState
	 * @param prdCode
	 * @param ver
	 * @return
	 * @Creation 2014-8-13上午11:58:25
	 * @Version v1.0.0
	 * @author wangchangsheng
	 * @throws Exception 
	 * @UpdateDate:
	 * @UpdateAuthor:
	 */
	int modifyActivityConfirmState(long prdCode, int ver) throws Exception;

	/**
	 * 批量重新申报活动
	 * @Method_Name modifyActReportBatch
	 * @param actCodeList
	 * @return
	 * @Creation 2014-8-14上午10:59:05
	 * @Version v1.0.0
	 * @author wangchangsheng
	 * @UpdateDate:
	 * @UpdateAuthor:
	 */
	int modifyActReportBatch(List<String> actCodeList) throws Exception;
}
