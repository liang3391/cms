package com.qianqian.common.service;

import java.util.List;

import com.qianqian.common.model.AdLocation;
import com.qianqian.common.model.CommodityAd;
import com.qianqian.common.model.MapAdLocation;

/**
 * 操作商品广告的接口
 * @Project 	: cms.maxtp
 * @Program Name: com.qianqian.naked.service.ICommodityAd.java
 * @ClassName	: ICommodityAd 
 * @Author 		: shenzhenxing 
 * @CreateDate  : 2014年5月22日 下午3:41:01
 */
public interface ICommodityAdService {
	/**
	 * 更新商品广告
	 *  @Method_Name    : updateCommodityAd
	 *  @param commodityAd
	 *  @return 
	 *  @return         : int
	 *  @Creation Date  : 2014年5月22日 下午3:47:45
	 *  @version        : v1.00
	 *  @Author         : shenzhenxing 
	 *  @Update Date    : 
	 *  @Update Author  :
	 */
	void updateCommodityAd(CommodityAd commodityAd,MapAdLocation record) throws Exception;
	
	/**
	 * 增加商品广告
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
	void addCommodityAd(List<MapAdLocation> list) throws Exception;
	/**
	 * 删除商品广告
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
	void deleteCommodityAd(MapAdLocation mapAd) throws Exception;
	/**
	 * 根据广告位置来查询商品广告列表
	 *  @Method_Name    : getCommodityAdListByLocation
	 *  @param adLocation ：广告位置
	 *  @return 
	 *  @return         : List<CommodityAd>
	 *  @Creation Date  : 2014年5月23日 上午9:33:42
	 *  @version        : v1.00
	 *  @Author         : shenzhenxing 
	 *  @Update Date    : 
	 *  @Update Author  :
	 */
	List<CommodityAd> getCommodityAdListByLocation(AdLocation adLocation);
}
