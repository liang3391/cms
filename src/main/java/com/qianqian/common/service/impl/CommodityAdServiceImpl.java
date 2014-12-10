package com.qianqian.common.service.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.qianqian.cms.model.MapAdLocationEntity;
import com.qianqian.cms.service.IMapAdTaskService;
import com.qianqian.common.mapper.CommodityAdMapper;
import com.qianqian.common.mapper.MapAdLocationMapper;
import com.qianqian.common.model.AdLocation;
import com.qianqian.common.model.CommodityAd;
import com.qianqian.common.model.MapAdLocation;
import com.qianqian.common.service.ICommodityAdService;
import com.qianqian.common.utils.BeanConvertUtil;


/**
 * 商品广告的操作
 * 
 * @Project : cms.maxtp
 * @Program Name: com.qianqian.naked.service.impl.CommodityAdServiceImpl.java
 * @ClassName : CommodityAdServiceImpl
 * @Author : shenzhenxing
 * @CreateDate : 2014年5月23日 上午9:31:02
 */
@Service("commodityAdService")
public class CommodityAdServiceImpl implements ICommodityAdService {
	private Logger log = LoggerFactory.getLogger(CommodityAdServiceImpl.class);
	@Resource
	private IMapAdTaskService mapAdTaskService;
	@Resource
	private CommodityAdMapper commodityAdMapper;
	@Resource
	private MapAdLocationMapper mapAdLocationMapper;

	/**
	 * 更新商品广告
	 * 
	 * @throws Exception
	 */
	@Override
	public void updateCommodityAd(CommodityAd commodityAd, MapAdLocation record)
			throws Exception {
		// commodityAdMapper.updateByPrimaryKey(commodityAd);

		// MapAdLocationEntity entity=record.creat(record);

		// mapAdTaskService.createMapAdTask(entity);

	}

	/**
	 * 根据位置查商品广告
	 */

	public List<CommodityAd> getCommodityAdListByLocation(AdLocation adLocation) {
		List<CommodityAd> commodityAdList = commodityAdMapper
				.selectByLocationAndSort(adLocation);
		log.info("查到的商品广告条数：" + commodityAdList.size());
		return commodityAdList;
	}

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
	@Override
	public void addCommodityAd(List<MapAdLocation> list) throws Exception {
		if (list != null) {
			for (MapAdLocation mapAd : list) {
				CommodityAd ad = BeanConvertUtil.convert2CommodityAd(mapAd);
				ad.setCreateTime(new Date());
				ad.setCreateBy(1L);//当前登录用户ID
				ad.setUpdateTime(new Date());
				ad.setUpdateBy(1l);//当前登录用户ID
				log.debug("insert CommodityAd=" + ad);
				commodityAdMapper.insert(ad);
				mapAd.setAdId(ad.getAdId());
				mapAd.setShowState(2);// 广告展示状态为等待上线
				mapAd.setCreateTime(new Date());
				mapAd.setCreateBy(1L);//当前登录用户ID
				mapAd.setUpdateTime(new Date());
				mapAd.setUpdateBy(1l);//当前登录用户ID
				log.debug("insert mapAdLocation=" + mapAd);
				mapAdLocationMapper.insert(mapAd);
				MapAdLocationEntity entity = BeanConvertUtil
						.convert2MapAdLocationEntity(mapAd);
				log.debug("create crontab param=>" + entity.toString());
				mapAdTaskService.createMapAdTask(entity);
			}
		}

	}

	/**
	 * 删除商品广告
	 * 
	 * @Method_Name : deleteImageAd
	 * @param ad
	 * @throws Exception
	 * @return : void
	 * @Creation Date : 2014年5月29日 下午1:38:46
	 * @version : v1.00
	 * @Author : caozhifei
	 * @Update Date :
	 * @Update Author :
	 */
	@Override
	public void deleteCommodityAd(MapAdLocation mapAd) throws Exception {
		mapAd.setShowState(-1);// 逻辑删除
		if (mapAd.getId() != null) {
			mapAd.setUpdateBy(1l);//当前登录用户ID
			mapAd.setUpdateTime(new Date());
			mapAdLocationMapper.updateByPrimaryKeySelective(mapAd);
			MapAdLocationEntity entity = BeanConvertUtil
					.convert2MapAdLocationEntity(mapAd);
			//如果定时任务已经创建，则删除
			mapAdTaskService.deleteMapAdTask(entity);
		}
		CommodityAd ad = BeanConvertUtil.convert2CommodityAd(mapAd);
		ad.setAdState(0);// 逻辑删除
		ad.setUpdateTime(new Date());
		ad.setUpdateBy(1l);//当前登录用户ID
		if (ad.getAdId() != null) {
			commodityAdMapper.updateByPrimaryKeySelective(ad);
		}

	}

}
