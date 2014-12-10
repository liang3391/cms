package com.qianqian.product.controller;

import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.qianqian.product.common.Constants;
import com.qianqian.product.common.PageObject;
import com.qianqian.product.dto.ProductDTO;
import com.qianqian.product.model.ProductActivityWrapper;
import com.qianqian.product.service.IProductOnSaleService;
import com.qianqian.product.service.IProductService;

/**
 * 在售产品管理
 * @Name ProductOnSaleController
 * @Creation 2014-9-4下午03:05:58
 * @Version v1.0.0
 * @author wangchangsheng
 * @UpdateDate:
 * @UpdateAuthor:
 */
@Controller
public class ProductOnSaleController {

	@Autowired
	IProductOnSaleService prdOnSaleService;
	@Autowired
	IProductService productService;
	
	/**
	 * 体验中产品管理列表
	 * @Method_Name getOnSaleProductList
	 * @param act
	 * @param modelMap
	 * @param request
	 * @return
	 * @Creation 2014-8-25下午03:48:30
	 * @Version v1.0.0
	 * @author wangchangsheng
	 * @throws Exception 
	 * @UpdateDate:
	 * @UpdateAuthor:
	 */
	@RequestMapping("/prd/getOnSaleProductList")
	public String getOnSaleProductList(ProductActivityWrapper act,ModelMap modelMap,HttpServletRequest request) throws Exception{
		int pageNo = PageObject.getPageNum(request);
		PageObject po = prdOnSaleService.getOnSaleProductList(act,pageNo);
		
		modelMap.put("po", po);
		modelMap.put("searchAct", act);
		
		String returnUrl = "";
		Integer type = act.getType();
		if(Constants.PRD_STD == type){
			returnUrl = "product/naked/activityOnSale";
		}else{
			returnUrl = "product/free/activityOnSale";
		}
		return returnUrl;
	}
	
	/**
	 * 终止体验（试用）在售中产品
	 * @Method_Name stopOnSaleProduct
	 * @param stopActId
	 * @param type
	 * @return
	 * @Creation 2014-8-26下午03:20:37
	 * @Version v1.0.0
	 * @author wangchangsheng
	 * @throws Exception 
	 * @UpdateDate:
	 * @UpdateAuthor:
	 */
	@RequestMapping("/prd/stopOnSaleProduct")
	public String stopOnSaleProduct(String[] stopActId,String type) throws Exception{
		List<String> actIds = Arrays.asList(stopActId);
		int ret = prdOnSaleService.modifyStopOnSaleProduct(actIds,type);
		return "redirect:/prd/getOnSaleProductList.htm?type="+type;
	}

	/**
	 * 查询体验/试用结束产品列表
	 * @Method_Name getEndSaleProductList
	 * @return
	 * @Creation 2014-9-4下午03:07:10
	 * @Version v1.0.0
	 * @author wangchangsheng
	 * @throws Exception 
	 * @UpdateDate:
	 * @UpdateAuthor:
	 */
	@RequestMapping("/prd/getEndSaleProductList")
	public String getEndSaleProductList(HttpServletRequest request,ModelMap modelMap,ProductActivityWrapper act) throws Exception{
		int pageNo = PageObject.getPageNum(request);
		PageObject po = prdOnSaleService.getEndSaleProductList(act,pageNo);
		
		modelMap.put("po", po);
		modelMap.put("searchAct", act);
		
		String returnUrl = "";
		Integer type = act.getType();
		if(Constants.PRD_STD == type){
			returnUrl = "product/naked/activityEndSale";
		}else{
			returnUrl = "product/free/activityEndSale";
		}
		return returnUrl;
	}


	/**
	 * 试用/体验结束活动产品管理--编辑产品
	 * @Method_Name modifyEndSaleProduct
	 * @param prd
	 * @return
	 * @Creation 2014-9-10上午11:00:47
	 * @Version v1.0.0
	 * @author wangchangsheng
	 * @throws Exception 
	 * @UpdateDate:
	 * @UpdateAuthor:
	 */
	@RequestMapping("/prd/modifyEndSaleProduct")
	public String modifyEndSaleProduct(ProductDTO  prd) throws Exception{
		int ret = productService.modifyEndSaleProduct(prd);
		return "redirect:/prd/getEditingProductList.htm?type="+prd.getPrd().getType();
	}
	
	/**
	 * 在售产品管理-将产品放入回收站
	 * @Method_Name removeEndSaleProduct
	 * @param removePrd
	 * @return
	 * @throws Exception
	 * @Creation 2014-9-11上午09:41:50
	 * @Version v1.0.0
	 * @author wangchangsheng
	 * @UpdateDate:
	 * @UpdateAuthor:
	 */
	@RequestMapping("/prd/removeEndSaleProduct")
	public String removeEndSaleProduct(Long[] removePrd,String redirectUrl) throws Exception{
		int ret = productService.modifyPrdStdToRecycle(removePrd, Constants.PRD_STD_ONSELL);
		return "redirect:"+redirectUrl;
	}
	
	/**
	 * 查询编辑中产品列表
	 * @Method_Name getEditingProductList
	 * @param request
	 * @param modelMap
	 * @param act
	 * @return
	 * @Creation 2014-9-11上午11:11:53
	 * @Version v1.0.0
	 * @author wangchangsheng
	 * @throws Exception 
	 * @UpdateDate:
	 * @UpdateAuthor:
	 */
	@RequestMapping("/prd/getEditingProductList")
	public String getEditingProductList(HttpServletRequest request,ModelMap modelMap,ProductActivityWrapper act) throws Exception{
		int pageNo = PageObject.getPageNum(request);
		PageObject po = prdOnSaleService.getEditingProductList(act,pageNo);
		
		modelMap.put("po", po);
		modelMap.put("searchAct", act);
		
		String returnUrl = "";
		Integer type = act.getType();
		if(Constants.PRD_STD == type){
			returnUrl = "product/naked/editingProduct";
		}else{
			returnUrl = "product/free/editingProduct";
		}
		return returnUrl;
	}
}
