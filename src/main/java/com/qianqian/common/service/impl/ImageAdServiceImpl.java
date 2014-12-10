package com.qianqian.common.service.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.qianqian.cms.model.MapAdLocationEntity;
import com.qianqian.cms.service.IMapAdTaskService;
import com.qianqian.common.mapper.ImageAdMapper;
import com.qianqian.common.mapper.MapAdLocationMapper;
import com.qianqian.common.model.AdLocation;
import com.qianqian.common.model.ImageAd;
import com.qianqian.common.model.MapAdLocation;
import com.qianqian.common.utils.BeanConvertUtil;
import com.qianqian.common.service.IImageAdService;

/**
 * 图片广告的业务操作
 * 
 * @Project : cms.maxtp
 * @Program Name: com.qianqian.naked.service.impl.ImageAdServiceImpl.java
 * @ClassName : ImageAdServiceImpl
 * @Author : shenzhenxing
 * @CreateDate : 2014年5月22日 下午5:15:35
 */
@Service("imageAdService")
public class ImageAdServiceImpl implements IImageAdService {
	private Logger log = LoggerFactory.getLogger(ImageAdServiceImpl.class);
	@Resource
	private IMapAdTaskService mapAdTaskService;
	@Resource
	private ImageAdMapper imageAdMapper;
	@Resource
	private MapAdLocationMapper mapAdLocationMapper;

	/**
	 * 更新图片广告
	 * 
	 * @throws Exception
	 */
	public void updateImageAd(ImageAd imageAd, MapAdLocation record)
			throws Exception {

		/*
		 * log.info("update imageAdInfo:"+imageAd);
		 * 
		 * imageAdMapper.updateByPrimaryKeySelective(imageAd);
		 * 
		 * MapAdLocationEntity entity=record.creat(record);
		 * 
		 * mapAdTaskService.createMapAdTask(entity);
		 */

	}

	/**
	 * 增加新的图片广告 record 里要有locationId
	 * 
	 * @throws Exception
	 */
	public void addImageAd(List<MapAdLocation> list) throws Exception {
		if (list != null) {
			for (MapAdLocation mapAd : list) {
				ImageAd ad = BeanConvertUtil.convert2ImageAd(mapAd);
				ad.setCreateTime(new Date());
				ad.setCreateBy(1L);//当前登录用户ID
				ad.setUpdateTime(new Date());
				ad.setUpdateBy(1l);//当前登录用户ID
				log.debug("insert imageAd="+ad);
				imageAdMapper.insert(ad);				
				mapAd.setAdId(ad.getAdId());
				mapAd.setShowState(2);// 广告展示状态为等待上线
				mapAd.setCreateTime(new Date());
				mapAd.setCreateBy(1L);//当前登录用户ID
				mapAd.setUpdateTime(new Date());
				mapAd.setUpdateBy(1l);//当前登录用户ID
				log.debug("insert mapAdLocation="+mapAd);
				mapAdLocationMapper.insert(mapAd);
				MapAdLocationEntity entity = BeanConvertUtil
						.convert2MapAdLocationEntity(mapAd);
				log.debug("create crontab param=>"+entity.toString());
				mapAdTaskService.createMapAdTask(entity);
			}
		}
	}

	/**
	 * 根据位置查询该位置上的图片广告
	 */
	public List<ImageAd> getImageAdList(AdLocation location) {
		List<ImageAd> imageAdList = imageAdMapper
				.selectByLocationAndSort(location);
		log.info("chadaodetiaoshu:" + imageAdList.size());
		return imageAdList;
	}
	/**
	 * 若数据库存在则进行逻辑删除，若不存在不进行操作
	 */
	@Override
	public void deleteImageAd(MapAdLocation mapAd) throws Exception {
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
		ImageAd ad = BeanConvertUtil.convert2ImageAd(mapAd);
		ad.setAdState(0);// 逻辑删除
		ad.setUpdateTime(new Date());
		ad.setUpdateBy(1l);//当前登录用户ID
		if (ad.getAdId() != null) {
			imageAdMapper.updateByPrimaryKeySelective(ad);
		}
		

	}

}
