package com.qianqian.common.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 返回错误页面
 * @Project 	: member.maxtp
 * @Program Name: com.qianqian.common.controller.ErrorController.java
 * @ClassName	: ErrorController 
 * @Author 		: caozhifei 
 * @CreateDate  : 2014年4月23日 下午3:03:39
 */
@Controller
public class ErrorController {
	private final static String ERROR="common/errors/error";
	/**
	 * 返回错误页面
	 *  @Method_Name    : toError
	 *  @return 
	 *  @return         : String
	 *  @Creation Date  : 2014年4月23日 下午3:03:52
	 *  @version        : v1.00
	 *  @Author         : caozhifei 
	 *  @Update Date    : 
	 *  @Update Author  :
	 */
	@RequestMapping("showError")
	public String toError(){
		return ERROR;
	}
}
