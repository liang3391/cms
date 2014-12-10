package com.qianqian.common.service;
/**
 * 和位置相关的接口
 * @Project 	: cms.maxtp
 * @Program Name: com.qianqian.naked.service.ILocationService.java
 * @ClassName	: ILocationService 
 * @Author 		: shenzhenxing 
 * @CreateDate  : 2014年5月29日 下午1:57:20
 */
public interface ILocationService {
/**
 * 
 *  @Method_Name    : getLocationCount
 *  @param locationType 位置类型
 *  @param pageType   页面类型
 *  @return 
 *  @return         : int
 *  @Creation Date  : 2014年6月3日 下午1:46:57
 *  @version        : v1.00
 *  @Author         : shenzhenxing 
 *  @Update Date    : 
 *  @Update Author  :
 */
	int getLocationCount(int locationType,int pageType,long categoryId);
}
