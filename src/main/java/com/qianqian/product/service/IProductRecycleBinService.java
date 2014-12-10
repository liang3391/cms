package com.qianqian.product.service;

import com.qianqian.product.common.PageObject;
import com.qianqian.product.model.ProductActivityWrapper;

/**
 * 产品回收站服务
 * @Name IProductRecycleBinService
 * @Creation 2014-9-1下午03:02:07
 * @Version v1.0.0
 * @author wangchangsheng
 * @UpdateDate:
 * @UpdateAuthor:
 */
public interface IProductRecycleBinService {

	/**
	 * 查询产品回收站列表
	 * @Method_Name getRecycleBinList
	 * @param act
	 * @param pageNo
	 * @return
	 * @Creation 2014-9-1下午03:37:18
	 * @Version v1.0.0
	 * @author wangchangsheng
	 * @throws Exception 
	 * @UpdateDate:
	 * @UpdateAuthor:
	 */
	PageObject getRecycleBinList(ProductActivityWrapper act, int pageNo) throws Exception;

	/**
	 * 将产品从回收站恢复
	 * @Method_Name modifyPrdRecover
	 * @param productCodes 产品编码
	 * @param status 产品状态
	 * @return
	 * @throws Exception
	 * @Creation 2014-9-3下午02:42:46
	 * @Version v1.0.0
	 * @author wangchangsheng
	 * @UpdateDate:
	 * @UpdateAuthor:
	 */
	int modifyPrdRecover(long[] productCodes,int status) throws Exception;

	
}
