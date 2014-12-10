package com.qianqian.product.service;

import java.util.List;

import com.qianqian.product.common.PageObject;
import com.qianqian.product.model.ProductActivityWrapper;


/**
 * 在售产品管理
 * @Name IProductOnSaleService
 * @Creation 2014-8-20下午02:53:35
 * @Version v1.0.0
 * @author wangchangsheng
 * @UpdateDate:
 * @UpdateAuthor:
 */
public interface IProductOnSaleService {

	/**
	 * 查询体验中活动产品
	 * @Method_Name getOnSaleProductList
	 * @param act
	 * @param pageNo
	 * @return
	 * @Creation 2014-8-25下午03:50:54
	 * @Version v1.0.0
	 * @author wangchangsheng
	 * @throws Exception 
	 * @UpdateDate:
	 * @UpdateAuthor:
	 */
	PageObject getOnSaleProductList(ProductActivityWrapper act, int pageNo) throws Exception;

	/**
	 * 终止体验/试用在售中的产品活动
	 * @Method_Name stopOnSaleProduct
	 * @param actIds
	 * @param type
	 * @return
	 * @Creation 2014-8-26下午03:34:34
	 * @Version v1.0.0
	 * @author wangchangsheng
	 * @throws Exception 
	 * @UpdateDate:
	 * @UpdateAuthor:
	 */
	int modifyStopOnSaleProduct(List<String> actIds, String type) throws Exception;

	/**
	 * 查询体验结束产品列表
	 * @Method_Name getEndSaleProductList
	 * @param act
	 * @param pageNo
	 * @return
	 * @Creation 2014-9-4下午03:14:31
	 * @Version v1.0.0
	 * @author wangchangsheng
	 * @throws Exception 
	 * @UpdateDate:
	 * @UpdateAuthor:
	 */
	PageObject getEndSaleProductList(ProductActivityWrapper act, int pageNo) throws Exception;

	/**
	 * 查询编辑中产品列表
	 * @Method_Name getEditingProductList
	 * @param act
	 * @param pageNo
	 * @return
	 * @Creation 2014-9-11上午11:12:41
	 * @Version v1.0.0
	 * @author wangchangsheng
	 * @throws Exception 
	 * @UpdateDate:
	 * @UpdateAuthor:
	 */
	PageObject getEditingProductList(ProductActivityWrapper act, int pageNo) throws Exception;

}
