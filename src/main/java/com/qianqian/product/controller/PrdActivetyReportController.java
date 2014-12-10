package com.qianqian.product.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.qianqian.product.common.Constants;
import com.qianqian.product.common.PageObject;
import com.qianqian.product.model.ProductActivityWrapper;
import com.qianqian.product.service.IPrdActivityCheckService;
import com.qianqian.product.service.IPrdActivityReportService;
import com.qianqian.product.service.IPrdActivityService;
import com.qianqian.product.service.IProductService;

/**
 * 活动申报管理
 * @Name PrdActivetyReportController
 * @Creation 2014-8-14下午03:40:07
 * @Version v1.0.0
 * @author wangchangsheng
 * @UpdateDate:
 * @UpdateAuthor:
 */
@Controller
public class PrdActivetyReportController {

	@Autowired
	IPrdActivityCheckService prdActivityCheckService;
	
	@Autowired
	IPrdActivityService prdActivityService;

	@Autowired
	IPrdActivityReportService prdActivityReportService;
	
	@Autowired
	IProductService productService;
	
	/**
	 * 获取重新申报活动列表
	 * @Method_Name getPrdActReportList
	 * @return
	 * @Creation 2014-8-14下午03:48:06
	 * @Version v1.0.0
	 * @author wangchangsheng
	 * @throws Exception 
	 * @UpdateDate:
	 * @UpdateAuthor:
	 */
	@RequestMapping("/act/getActReportList")
	public String getPrdActReportList(ProductActivityWrapper act,ModelMap modelMap,HttpServletRequest request) throws Exception{
		int pageNo = PageObject.getPageNum(request);
		PageObject pageObject = prdActivityReportService.getPrdActReportList(act,pageNo);
		
		modelMap.put("searchAct", act);
		modelMap.put("po", pageObject);
		
		String returnUrl="";
		int type = act.getType();
		int prdStatus = 1;		//默认待售
		Integer prdStatusInt = act.getPrdStatus();
		if(prdStatusInt!=null){
			prdStatus = prdStatusInt;
		}
		
		//根据类别，状态不同，分别跳转到不同页面
		if(type==Constants.PRD_STD_FREE){		//免费试用
			if(prdStatus==Constants.PRD_STD_FOR_SALE){		//待售
				returnUrl = "product/free/activityReportForSale";
			}else if(prdStatus==Constants.PRD_STD_ONSELL){		//在售
				returnUrl = "product/free/activityReportOnSale";
			}
		}else if(type==Constants.PRD_STD){		//裸价体验
			if(prdStatus==Constants.PRD_STD_FOR_SALE){		//待售
				returnUrl = "product/naked/activityReportForSale";
			}else if(prdStatus==Constants.PRD_STD_ONSELL){		//在售
				returnUrl = "product/naked/activityReportOnSale";
			}
		}
		
		return returnUrl;
	}
	
	/**
	 * 批量将活动放入回收站
	 * @Method_Name removePrdAct
	 * @param request
	 * @return
	 * @Creation 2014-8-15下午02:01:45
	 * @Version v1.0.0
	 * @author wangchangsheng
	 * @throws Exception 
	 * @UpdateDate:
	 * @UpdateAuthor:
	 */
	@RequestMapping("/act/removePrdAct")
	public String removePrdAct(HttpServletRequest request,Long[] removeAct,Integer type,Integer prdStatus) throws Exception{
		//productService.modifyPrdStd(removeAct);
		productService.modifyPrdStdToRecycle(removeAct,prdStatus);
		return "redirect:/act/getActReportList.htm?type="+type+"&prdStatus="+prdStatus;
	}
	
	/**
	 * 查询活动复核记录
	 * @Method_Name getActCheckRecord
	 * @return
	 * @Creation 2014-8-19下午02:03:41
	 * @Version v1.0.0
	 * @author wangchangsheng
	 * @throws Exception 
	 * @UpdateDate:
	 * @UpdateAuthor:
	 */
	@RequestMapping("/act/getActCheckRecord")
	public String getActCheckRecord(ProductActivityWrapper act,ModelMap modelMap,HttpServletRequest request) throws Exception{
		int pageNo = PageObject.getPageNum(request);
		PageObject pageObject = prdActivityReportService.getActCheckRecord(act,pageNo);
		
		modelMap.put("searchAct", act);
		modelMap.put("po", pageObject);
		
		String returnUrl = "";
		Integer type = act.getType();
		if(Constants.PRD_STD == type){
			returnUrl = "product/naked/actCheckRecord";
		}else{
			returnUrl = "product/free/actCheckRecord";
		}
		return returnUrl;
	}

}
