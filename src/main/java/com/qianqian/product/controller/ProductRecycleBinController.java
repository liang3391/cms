package com.qianqian.product.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.qianqian.product.common.Constants;
import com.qianqian.product.common.PageObject;
import com.qianqian.product.model.ProductActivityWrapper;
import com.qianqian.product.service.IProductRecycleBinService;

/**
 * 产品回收站管理
 * @Name productRecycleBinController
 * @Creation 2014-9-1下午02:35:44
 * @Version v1.0.0
 * @author wangchangsheng
 * @UpdateDate:
 * @UpdateAuthor:
 */
@Controller
public class ProductRecycleBinController {

	@Autowired
	IProductRecycleBinService productRecycleBinService;
	
	/**
	 * 获取产品回收站列表
	 * @Method_Name getPrdRecycleBinList
	 * @return
	 * @throws Exception
	 * @Creation 2014-9-1下午02:43:43
	 * @Version v1.0.0
	 * @author wangchangsheng
	 * @UpdateDate:
	 * @UpdateAuthor:
	 */
	@RequestMapping("/prd/getRecycleBinList")
	public String getPrdRecycleBinList(ProductActivityWrapper act,HttpServletRequest request,ModelMap modelMap) throws Exception{
		int pageNo = PageObject.getPageNum(request);
		PageObject pageObject = productRecycleBinService.getRecycleBinList(act,pageNo);
		
		modelMap.put("searchAct", act);
		modelMap.put("po", pageObject);
		
		String returnUrl = "";
		int type = act.getType();
		if(Constants.PRD_STD==type){
			returnUrl = "product/naked/prdRecycleBin";
		}else if(Constants.PRD_STD_FREE==type){
			returnUrl = "product/free/prdRecycleBin";
		}
		return returnUrl;
	}
	
	/**
	 * 批量将产品从回收站恢复到原来状态
	 * @Method_Name recoverPrdFromRecycle
	 * @param productCodes
	 * @return
	 * @Creation 2014-9-3下午02:24:04
	 * @Version v1.0.0
	 * @author wangchangsheng
	 * @throws Exception 
	 * @UpdateDate:
	 * @UpdateAuthor:
	 */
	@RequestMapping("/prd/recoverPrdFromRecycle")
	public String recoverPrdFromRecycle(long[] productCode,String type,int status) throws Exception{
		int ret = productRecycleBinService.modifyPrdRecover(productCode,status);
		return "redirect:/prd/getRecycleBinList.htm?type="+type;
	}
}
