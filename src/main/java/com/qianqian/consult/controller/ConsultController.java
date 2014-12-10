package com.qianqian.consult.controller;

import java.util.Date;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.qianqian.consult.model.Consult;
import com.qianqian.consult.model.Shield;
import com.qianqian.consult.service.IConsultDubboService;
import com.qianqian.consult.util.PageBean;
import com.qianqian.order.dto.Query;

@Controller
@RequestMapping("/consult")
public class ConsultController {

	private static String CONSULT = "consult/consult_list";
	
	private static int pageSize = 20;
	
	/**
	 * 咨询管理列表
	 * @Method_Name getConsultReply
	 * @Creation Date 2014-10-16 下午1:55:33
	 * @version 
	 * @Author chengshuang
	 * @Update Date 
	 * @Update Author 
	 * @param query
	 * @param map
	 * @return
	 */
	@RequestMapping("/getConsultReply")
	public String getConsultList(Query query, ModelMap map) {
		query.setPageSize(pageSize);	//每页数据条数
		
		PageBean<Consult> pageBean = consultDubboService.findConsultList(query);
		map.put("pageBean", pageBean);
		map.put("query", query);
		map.put("page", pageBean.getPage());
		
		return CONSULT;
	}
	
	/**
	 * 删除咨询内容
	 * @Method_Name deleteConsult
	 * @Creation Date 2014-10-20 下午4:57:21
	 * @version 
	 * @Author chengshuang
	 * @Update Date 
	 * @Update Author 
	 * @param consultId
	 * @param flag	0删除咨询内容	1删除咨询回复内容
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/deleteConsult")
	public String deleteConsult(String consultId, int flag) throws Exception {
		Shield shield = new Shield();
		shield.setHandleUserId(123456);	//TODO 测试美试操作人id
		shield.setHandleDateTime(new Date());
		if(flag==0) {
			consultDubboService.deleteConsultShield(consultId, shield);	//删除咨询
		} else if(flag==1) {
			consultDubboService.deleteConsultReplyShield(consultId, shield);	//删除咨询回复
		}
		
		return "redirect:/consult/getConsultReply.htm";
	}
	
	@Resource
	private IConsultDubboService consultDubboService;
}
