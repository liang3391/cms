package com.qianqian.product.controller;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.qianqian.product.common.Constants;
import com.qianqian.product.common.PageObject;
import com.qianqian.product.model.ProductActivityWrapper;
import com.qianqian.product.service.IPrdActivityCheckService;
import com.qianqian.product.service.IPrdActivityService;
import com.qianqian.product.util.ResponseUtil;

/**
 * 复核活动管理
 * @Name PrdActivetyCheckController
 * @Creation 2014-8-12
 * @Version 
 * @author wangchangsheng
 * @UpdateDate:
 * @UpdateAuthor:
 */
@Controller
public class PrdActivetyCheckController {

	@Autowired
	IPrdActivityCheckService prdActivityCheckService;
	
	@Autowired
	IPrdActivityService prdActivityService;
	
	/**
	 * 
	 * 美试后台-获取复核活动管理（待售）
	 * @Method_Name getPrdActCheckList
	 * @param act
	 * @param modelMap
	 * @return
	 * @throws Exception
	 * @Creation 2014-8-7上午09:58:16
	 * @Version 
	 * @author wangchangsheng
	 * @Update Date:
	 * @Update Author:
	 */
	@RequestMapping("/act/getActCheckList")
	public String getPrdActCheckList(ProductActivityWrapper act,ModelMap modelMap,HttpServletRequest request) throws Exception{
		int pageNo = PageObject.getPageNum(request);
		PageObject pageObject = prdActivityCheckService.getPrdActCheckList(act,pageNo);
		
		modelMap.put("searchAct", act);
		modelMap.put("po", pageObject);
		
		String returnUrl = "";
		int type = act.getType();
		int prdStatus = 1;		//默认待售
		Integer prdStatusInt = act.getPrdStatus();
		if(prdStatusInt!=null){
			prdStatus = prdStatusInt;
		}
		
		//根据类别，状态不同，分别跳转到不同页面
		if(type==Constants.PRD_STD_FREE){		//免费试用
			if(prdStatus==Constants.PRD_STD_FOR_SALE){		//待售
				returnUrl = "product/free/activityCheckForSale";
			}else if(prdStatus==Constants.PRD_STD_ONSELL){	//在售
				returnUrl = "product/free/activityCheckOnSale";
			}
		}else if(type==Constants.PRD_STD){		//裸价体验
			if(prdStatus==Constants.PRD_STD_FOR_SALE){		//待售
				returnUrl = "product/naked/activityCheckForSale";
			}else if(prdStatus==Constants.PRD_STD_ONSELL){	//在售
				returnUrl = "product/naked/activityCheckOnSale";
			}
		}
		
		return returnUrl;
	}
	
	/**
	 * 运营确认活动展示
	 * @Method_Name confirmShow
	 * @param prdCode 产品编码
	 * @param ver 产品版本
	 * @param response
	 * @return
	 * @throws Exception
	 * @Creation 2014-8-13下午01:32:31
	 * @Version v1.0.0
	 * @author wangchangsheng
	 * @UpdateDate:
	 * @UpdateAuthor:
	 */
	@RequestMapping("/act/confirmShow")
	public String confirmShow(long prdCode,int ver,HttpServletResponse response) throws Exception{
		//先查询当前活动是否已被确认
		//先不对已确认进行校验，当活动已被其他运营人员确认，再次确认时，后覆盖前
		/*PrdActivityDTO activityDto = prdActivityService.getPrdActivity(prdCode, ver);
		Long confirmUser = activityDto.getPrdAct().getConfirmUserId();
		
		Map resultMap = new HashMap();
		if(confirmUser!=null){
			resultMap.put("result", 0);
		}else{
			prdActivityCheckService.modifyActivityConfirmState(prdCode,ver);
			resultMap.put("result", 1);
			resultMap.put("confirmUser", 12312312);
		}*/
		
		Map<String,Object> resultMap = new HashMap<String,Object>();
		int ret = prdActivityCheckService.modifyActivityConfirmState(prdCode,ver);
		if(ret > 0){
			resultMap.put("result", 1);
			resultMap.put("confirmUser", 12312312);
		}else{
			resultMap.put("result", 0);
		}
		ResponseUtil.renderJson(response,JSONObject.fromObject(resultMap).toString());
		
		return null;
	}
	
	/**
	 * 批量重新申报活动
	 * @Method_Name reportPrdActivity
	 * @param request
	 * @param type 免费/裸价
	 * @param prdStatus 产品状态
	 * @return
	 * @throws Exception
	 * @Creation 2014-8-14上午09:54:57
	 * @Version v1.0.0
	 * @author wangchangsheng
	 * @UpdateDate:
	 * @UpdateAuthor:
	 */
	@RequestMapping("/act/reportActivity")
	public String reportPrdActivity(HttpServletRequest request,String type,String prdStatus) throws Exception{
		String[] actCodes = request.getParameterValues("reportAct");
		List<String> actCodeList = Arrays.asList(actCodes);
		
		int ret = prdActivityCheckService.modifyActReportBatch(actCodeList);
		return "redirect:/act/getActReportList.htm?type="+type+"&prdStatus="+prdStatus;
	}
}
