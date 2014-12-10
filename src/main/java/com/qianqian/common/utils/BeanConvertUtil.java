package com.qianqian.common.utils;

import java.util.Date;

import com.qianqian.cms.model.MapAdLocationEntity;
import com.qianqian.common.model.CommodityAd;
import com.qianqian.common.model.ImageAd;
import com.qianqian.common.model.MapAdLocation;

/**
 * java 对象转换工具
 * 
 * @Project : cms.maxtp
 * @Program Name: com.qianqian.common.utils.BeanConvertUtil.java
 * @ClassName : BeanConvertUtil
 * @Author : caozhifei
 * @CreateDate : 2014年5月29日 下午1:49:21
 */
public class BeanConvertUtil {
	/**
	 * MapAdLocation 转换成 MapAdLocationEntity
	 * 
	 * @Method_Name : convert2MapAdLocationEntity
	 * @param mapAd
	 * @return
	 * @return : MapAdLocationEntity
	 * @Creation Date : 2014年5月29日 下午2:10:35
	 * @version : v1.00
	 * @Author : caozhifei
	 * @Update Date :
	 * @Update Author :
	 */
	public static MapAdLocationEntity convert2MapAdLocationEntity(
			MapAdLocation mapAd) {
		MapAdLocationEntity entity = new MapAdLocationEntity();
		entity.setCategory(mapAd.getCategory());
		entity.setEndTime(mapAd.getEndTime());
		entity.setId(mapAd.getId());
		entity.setLocationId(mapAd.getLocationId());
		entity.setLocationType(mapAd.getLocationType());
		entity.setPageType(mapAd.getPageType());
		if (mapAd.getStartTime() != null) {
			entity.setStartTime(mapAd.getStartTime());
		} else {
			entity.setStartTime(new Date());
		}
		return entity;

	}

	/**
	 * MapAdLocation 转换成 ImageAd
	 * 
	 * @Method_Name : convert2ImageAd
	 * @param mapAd
	 * @return
	 * @return : ImageAd
	 * @Creation Date : 2014年5月29日 下午2:18:49
	 * @version : v1.00
	 * @Author : caozhifei
	 * @Update Date :
	 * @Update Author :
	 */
	public static ImageAd convert2ImageAd(MapAdLocation mapAd) {
		ImageAd ad = new ImageAd();
		ad.setImageUrl(mapAd.getImageUrl());
		ad.setAccessUrl(mapAd.getAccessUrl());
		ad.setUrlTarget(mapAd.getUrlTarget());
		ad.setLoopTime(mapAd.getLoopTime());
		ad.setBoardName(mapAd.getBoardName());
		ad.setCreateBy(mapAd.getCreateBy());
		ad.setCreateTime(mapAd.getCreateTime());
		ad.setUpdateBy(mapAd.getUpdateBy());
		ad.setUpdateTime(mapAd.getUpdateTime());
		ad.setAdId(1l);
		return ad;
	}
	/**
	 * MapAdLocation 转换成 CommodityAd
	 *  @Method_Name    : convert2CommodityAd
	 *  @param mapAd
	 *  @return 
	 *  @return         : CommodityAd
	 *  @Creation Date  : 2014年6月3日 下午3:10:53
	 *  @version        : v1.00
	 *  @Author         : caozhifei 
	 *  @Update Date    : 
	 *  @Update Author  :
	 */
	public static CommodityAd convert2CommodityAd(MapAdLocation mapAd){
		CommodityAd ad = new CommodityAd();
		ad.setImageUrl(mapAd.getImageUrl());
		ad.setCommodityUrl(mapAd.getCommodityUrl());
		ad.setActiveEnd(mapAd.getActiveEnd());
		ad.setActiveStart(mapAd.getActiveStart());
		ad.setCommodityId(mapAd.getCommodityId());
		ad.setDiscount(mapAd.getDiscount());
		ad.setMarketPrice(mapAd.getMarketPrice());
		ad.setNakedPrice(mapAd.getNakedPrice());
		ad.setOpenCount(mapAd.getOpenCount());
		ad.setTitle(mapAd.getTitle());
		ad.setUrlTarget(mapAd.getUrlTarget());
		ad.setCreateBy(mapAd.getCreateBy());
		ad.setCreateTime(mapAd.getCreateTime());
		ad.setUpdateBy(mapAd.getUpdateBy());
		ad.setUpdateTime(mapAd.getUpdateTime());
		ad.setAdId(1l);
		return ad;
	}
}
