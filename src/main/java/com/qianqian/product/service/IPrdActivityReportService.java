package com.qianqian.product.service;

import java.util.List;

import com.qianqian.product.common.PageObject;
import com.qianqian.product.dto.PrdActivityDTO;
import com.qianqian.product.model.ProductActivityWrapper;

/**
 * 活动重新申报管理接口
 * @Name IPrdActivityReportService
 * @Creation 2014-8-14下午03:41:42
 * @Version v1.0.0
 * @author wangchangsheng
 * @UpdateDate:
 * @UpdateAuthor:
 */
public interface IPrdActivityReportService {

	/**
	 * 获取重新申报活动列表（待售）
	 * @Method_Name getPrdActReportList
	 * @param act
	 * @param pageNo
	 * @return
	 * @Creation 2014-8-14下午04:00:10
	 * @Version v1.0.0
	 * @author wangchangsheng
	 * @throws Exception 
	 * @UpdateDate:
	 * @UpdateAuthor:
	 */
	PageObject getPrdActReportList(ProductActivityWrapper act, int pageNo) throws Exception;

	/**
	 * 查询活动复核记录
	 * @Method_Name getActCheckRecord
	 * @param act
	 * @param pageNo
	 * @return
	 * @Creation 2014-8-19下午02:06:13
	 * @Version v1.0.0
	 * @author wangchangsheng
	 * @throws Exception 
	 * @UpdateDate:
	 * @UpdateAuthor:
	 */
	PageObject getActCheckRecord(ProductActivityWrapper act, int pageNo) throws Exception;
	

}
