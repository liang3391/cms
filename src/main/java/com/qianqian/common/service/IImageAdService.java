package com.qianqian.common.service;

import java.util.List;

import com.qianqian.common.model.AdLocation;
import com.qianqian.common.model.ImageAd;
import com.qianqian.common.model.MapAdLocation;

/**
 * 操作图片广告的接口
 * 
 * @Project : cms.maxtp
 * @Program Name: com.qianqian.naked.service.IImageAdService.java
 * @ClassName : IImageAdService
 * @Author : shenzhenxing
 * @CreateDate : 2014年5月22日 下午3:24:55
 */
public interface IImageAdService {
	/**
	 * 更新单个图片广告
	 * 
	 * @Method_Name : updateImageAd
	 * @param imageAd
	 * @param locationId
	 *            位置id
	 * @return
	 * @return : void
	 * @Creation Date : 2014年5月22日 下午4:43:19
	 * @version : v1.00
	 * @Author : shenzhenxing
	 * @Update Date :
	 * @Update Author :
	 */
	void updateImageAd(ImageAd imageAd, MapAdLocation record) throws Exception;

	/**
	 * 增加图片广告
	 * 
	 * @Method_Name : addImageAd
	 * @param imageAd
	 *            ：ImageAd
	 * @param record
	 *            ：MapAdLocation
	 * @return : void
	 * @Creation Date : 2014年5月23日 上午10:17:23
	 * @version : v1.00
	 * @Author : shenzhenxing
	 * @Update Date :
	 * @Update Author :
	 */
	void addImageAd(List<MapAdLocation> list) throws Exception;
	/**
	 * 删除图片广告
	 *  @Method_Name    : deleteImageAd
	 *  @param ad
	 *  @throws Exception 
	 *  @return         : void
	 *  @Creation Date  : 2014年5月29日 下午1:38:46
	 *  @version        : v1.00
	 *  @Author         : caozhifei 
	 *  @Update Date    : 
	 *  @Update Author  :
	 */
	void deleteImageAd(MapAdLocation mapAd) throws Exception;

	/**
	 * 根据广告位置查广告
	 * 
	 * @Method_Name : getImageAdList
	 * @param location
	 * @return
	 * @return : List<ImageAd>
	 * @Creation Date : 2014年5月22日 下午4:56:59
	 * @version : v1.00
	 * @Author : shenzhenxing
	 * @Update Date :
	 * @Update Author :
	 */
	List<ImageAd> getImageAdList(AdLocation location);

}
