package com.qianqian.product.controller;

import java.util.Date;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.framelib.utils.DateUtil;
import com.qianqian.product.common.Constants;
import com.qianqian.product.dto.PrdActivityDTO;
import com.qianqian.product.model.ProductPreview;
import com.qianqian.product.service.IPrdActivityService;
import com.qianqian.product.util.JSONMsgUtil;
import com.qianqian.product.util.ResponseUtil;

/**
 * Title:PrdActivetyController
 * @Description:活动信息
 * @Create_by:yinsy
 * @Create_date:2014-6-18
 * @Last_Edit_By:
 * @Edit_Description:
 * @version:manager.maxtp 1.0
 */
@Controller
public class PrdActivetyController {

	@Autowired
	IPrdActivityService prdActivityService;

	/**
	 * 获取活动信息
	 * @Create_by:yinsy
	 * @Create_date:2014-6-30
	 * @param prdCode 产品编号
	 * @param ver 版本号
	 * @param type 产品类型 0裸价，1免费
	 * @param modelMap
	 * @return
	 * @throws Exception
	 * @Last_Edit_By:
	 * @Edit_Description:
	 * @Create_Version:goods.maxtp 1.0
	 */
	@RequestMapping("prd/getActivity")
	public String getActivety(Long prdCode, Integer ver,Integer type,String from,
			ModelMap modelMap) throws Exception {
		PrdActivityDTO actDto = prdActivityService.getPrdActivity(prdCode, ver);
		modelMap.put("actDto", actDto);
		modelMap.put("prdCode", prdCode);
		modelMap.put("ver", ver);
		modelMap.put("from", from);
		if (type==Constants.PRD_STD_FREE) {	//免费试用
			return "product/activityFree";
		}
		return "product/activity";
	}
	
	/**
	 * 新增或编辑活动
	 * @Create_by:yinsy
	 * @Create_date:2014-6-30
	 * @param actDto 活动dto
	 * @return
	 * @throws Exception
	 * @Last_Edit_By:
	 * @Edit_Description:
	 * @Create_Version:goods.maxtp 1.0
	 */
	@RequestMapping("prd/addPrdAct")
	public String addOrModifyPrdActivity(PrdActivityDTO actDto,String from,String type) throws Exception{
		prdActivityService.addOrModifyPrdActivity(actDto,0);
		
		String redirectUrl = "redirect:/prd/selectForSalePrd.htm?type="+actDto.getType();
		//如果从重新申报管理中，点击编辑活动，成功后跳转到复核活动管理页面
		if("report".equals(from)){
			redirectUrl = "redirect:/act/getActReportList.htm?type="+type+"&prdStatus=1";
		}else if("editing".equals(from)){//编辑中编辑活动
			redirectUrl = "redirect:/prd/getEditingProductList.htm?type="+type;
		}
		return redirectUrl;
	}
	
	/**
	 * 新增活动复核信息
	 * @Create_by:yinsy
	 * @Create_date:2014-9-4
	 * @param actDto 活动信息
	 * @param from
	 * @param type
	 * @return
	 * @throws Exception
	 * @Last_Edit_By:
	 * @Edit_Description:
	 * @Create_Version:goods.maxtp 1.0
	 */
	@RequestMapping("prd/modifyPrdAct")
	public String modifyActCheckStd(PrdActivityDTO actDto,String from,String type) throws Exception{
		prdActivityService.addOrModifyPrdActivity(actDto,1);
		return "redirect:/act/getActCheckList.htm?type="+type+"&prdStatus=1";
	}
	
	/**
	 * 获取活动预览信息
	 * @Create_by:yinsy
	 * @Create_date:2014-9-19
	 * @param productCode 产品编号
	 * @param version 版本号
	 * @param actDto 活动dto
	 * @param modelMap
	 * @return
	 * @throws Exception 
	 * @Last_Edit_By:
	 * @Edit_Description:
	 * @Create_Version:goods.maxtp 1.0
	 */
	@RequestMapping("prd/toActPrev")
	public String toActPrev(Long productCode,Integer version,PrdActivityDTO actDto,ModelMap modelMap) throws Exception{
		ProductPreview preview = prdActivityService.toActPrev(productCode, version, actDto);
		modelMap.put("prd", preview);
		if (Constants.PRD_STD==preview.getType()) {
			return "product/previewAct";
		}
		return "product/previewActFree";
	}
	
	/**
	 * 获取活动详情
	 * @Create_by:yinsy
	 * @Create_date:2014-9-16
	 * @param productCode 产品编号
	 * @param version 版本号
	 * @param modelMap
	 * @return
	 * @throws Exception
	 * @Last_Edit_By:
	 * @Edit_Description:
	 * @Create_Version:goods.maxtp 1.0
	 */
	@RequestMapping("prd/getActPrev")
	public String getActPrev(Long productCode,Integer version,ModelMap modelMap) throws Exception{
		ProductPreview preview = prdActivityService.getActPrev(productCode, version);
		modelMap.put("prd", preview);
		if (Constants.PRD_STD==preview.getType()) {
			return "product/previewAct";
		}
		return "product/previewActFree";
	}
	
	/**
	 * 获取活动状态
	 * @Create_by:yinsy
	 * @Create_date:2014-6-30
	 * @return
	 * @Last_Edit_By:
	 * @Edit_Description:
	 * @Create_Version:goods.maxtp 1.0
	 */
	@RequestMapping("prd/getActStat")
	public String getPrdActStatus(Long prdCode, Integer ver,HttpServletResponse response) throws Exception{
		Integer std = prdActivityService.getPrdActStatus(prdCode, ver);
		ResponseUtil.renderText(response, JSONMsgUtil.getMsg(std));
		return null;
	}
	
	/**
	 * 获取免费试用各个状态的时间
	 * @Create_by:yinsy
	 * @Create_date:2014-7-16
	 * @param time 活动开始时间
	 * @param response
	 * @return
	 * @throws Exception
	 * @Last_Edit_By:
	 * @Edit_Description:
	 * @Create_Version:goods.maxtp 1.0
	 */
	@RequestMapping("prd/getActTimeFree")
	public String getActTimeFree(String time,HttpServletResponse response) throws Exception{
		int[] day = {Constants.FREE_ACT_TIME_APPLY,Constants.FREE_ACT_TIME_CHECK,Constants.FREE_ACT_TIME_SUBMIT};
		StringBuilder sb = new StringBuilder();
		Date date = DateUtil.parse(time, Constants.DATE_FORMAT_PATTERN);
		for (int d : day) {
			date = DateUtil.addDay(date, d);
			sb.append(DateUtil.format(date,Constants.DATE_FORMAT_PATTERN)).append(",");
		}
		sb.deleteCharAt(sb.length()-1);
		ResponseUtil.renderText(response, sb);
		return null;
	}
}
