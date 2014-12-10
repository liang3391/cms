package com.qianqian.naked.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.qianqian.common.model.AdLocation;
import com.qianqian.common.model.MapAdLocation;
import com.qianqian.common.service.IImageAdService;
import com.qianqian.common.utils.Constants;
import com.framelib.utils.DateUtil;
import com.framelib.utils.StringUtil;

/**
 * 图片广告发布控制器
 * 
 * @Project : cms.maxtp
 * @Program Name: com.qianqian.naked.controller.ImageAdController.java
 * @ClassName : ImageAdController
 * @Author : caozhifei
 * @CreateDate : 2014年5月29日 上午10:23:01
 */
@Controller
@RequestMapping("naked/imageAd")
public class ImageAdController {
	private static Logger log = LoggerFactory
			.getLogger(ImageAdController.class);
	@Resource
	private IImageAdService imageAdService;

	/**
	 * 图片广告进行发布操作
	 * 
	 * @Method_Name : releaseImageAd
	 * @param locationIds
	 *            广告位ID字符串，不同ID链接直接以","隔开 ，不能为空
	 * @param imageUrls
	 *            图片链接字符串，不同图片链接直接以","隔开 ，不能为空
	 * @param accessUrls
	 *            图片点击访问链接字符串，不同图片点击访问链接直接以","隔开，不能为空
	 * @param loopTime
	 *            图片广告轮播时间 ，可以为空
	 * @param boardNames
	 *            版块名称，多个版块名称以","隔开，可以为空
	 * @param startTimes
	 *            广告上线时间，多个上线时间以","隔开，可以为空
	 * @param endTimes
	 *            广告下线时间，多个下线时间以","隔开，可以为空
	 * @param urlTarget
	 *            url跳转目标 可以为空
	 * @param location
	 *            广告位参数 不能为空
	 * @param model
	 * @return
	 * @return : String
	 * @Creation Date : 2014年5月29日 上午10:59:00
	 * @version : v1.00
	 * @Author : caozhifei
	 * @Update Date :
	 * @Update Author :
	 */
	@RequestMapping("releaseImageAd")
	public String releaseImageAd(String locationIds, String imageUrls,
			String accessUrls, Integer loopTime, String boardNames,
			String startTimes, String endTimes, String urlTarget,
			AdLocation location, Model model) {
		log.debug("locationIds=" + locationIds);
		log.debug("imageUrls=" + imageUrls);
		log.debug("accessUrls=" + accessUrls);
		log.debug("loopTime=" + loopTime);
		log.debug("boardNames=" + boardNames);
		log.debug("startTimes=" + startTimes);
		log.debug("endTimes=" + endTimes);
		log.debug("AdLocation=" + location);
		urlTarget = urlTarget == null ? "_blank" : urlTarget;
		if (StringUtil.isBlank(imageUrls) || StringUtil.isBlank(accessUrls)
				|| StringUtil.isBlank(locationIds)) {
			model.addAttribute("result", 0);
			return null;
		}
		String[] locationIdArray = locationIds.split(",");
		String[] imageUrlArray = imageUrls.split(",");
		String[] accessUrlArray = accessUrls.split(",");
		int len = locationIdArray.length;
		String[] boardNameArray = null;
		if (!StringUtil.isBlank(boardNames)) {
			boardNameArray = boardNames.split(",");
		}
		String[] startTimeArray = null;
		if (!StringUtil.isBlank(startTimes)) {
			startTimeArray = startTimes.split(",");
		} else {
			Date currentDate = new Date();
			startTimeArray = new String[len];
			for (int i = 0; i < len; i++) {
				startTimeArray[i] = DateUtil.format(currentDate,
						Constants.DATE_FORMAT);
			}
		}
		String[] endTimesArray = null;
		if (!StringUtil.isBlank(endTimes)) {
			endTimesArray = endTimes.split(",");
		}
		if (!(accessUrlArray.length == len)
				|| !(len > 0 || !(imageUrlArray.length == len))) {
			model.addAttribute("result", 0);
			return null;
		}
		List<MapAdLocation> list = new ArrayList<MapAdLocation>();
		// 都不为空时
		if (boardNameArray != null && startTimeArray != null
				&& endTimesArray != null) {
			// 版块名称，上线时间，下线时间，与图片广告个数相同时
			if (boardNameArray.length == len && startTimeArray.length == len
					&& endTimesArray.length == len) {
				for (int i = 0; i < len; i++) {
					MapAdLocation ad = new MapAdLocation(locationIdArray[i],
							imageUrlArray[i], accessUrlArray[i], urlTarget,
							loopTime, boardNameArray[i], DateUtil.parse(
									startTimeArray[i], Constants.DATE_FORMAT),
							DateUtil.parse(endTimesArray[i],
									Constants.DATE_FORMAT));
					list.add(ad);
				}
			}

		}

		// 下线时间为空，上线时间只有一个时间，版块名称不为空
		if (boardNameArray != null && startTimeArray != null
				&& endTimesArray == null) {
			// 版块名称，上线时间，下线时间，与图片广告个数相同时
			if (boardNameArray.length == len && startTimeArray.length == 1) {
				for (int i = 0; i < len; i++) {
					MapAdLocation ad = new MapAdLocation(locationIdArray[i],
							imageUrlArray[i], accessUrlArray[i], urlTarget,
							loopTime, boardNameArray[i], DateUtil.parse(
									startTimeArray[0], Constants.DATE_FORMAT),
							null);
					list.add(ad);
				}
			}

		}

		// 下线时间不为空，版块名称为空，上线时间只有一个时间
		if (boardNameArray == null && startTimeArray != null
				&& endTimesArray != null) {
			// 版块名称，上线时间，下线时间，与图片广告个数相同时
			if (startTimeArray.length == 1) {
				for (int i = 0; i < len; i++) {
					MapAdLocation ad = new MapAdLocation(locationIdArray[i],
							imageUrlArray[i], accessUrlArray[i], urlTarget,
							loopTime, null, DateUtil.parse(startTimeArray[0],
									Constants.DATE_FORMAT), DateUtil.parse(
									endTimesArray[0], Constants.DATE_FORMAT));
					list.add(ad);
				}
			}

		}

		// 下线时间为空，版块名称为空，上线时间有多个个时间
		if (boardNameArray == null && startTimeArray != null
				&& endTimesArray == null) {
			// 版块名称，上线时间，下线时间，与图片广告个数相同时
			if (startTimeArray.length == len) {
				for (int i = 0; i < len; i++) {
					MapAdLocation ad = new MapAdLocation(locationIdArray[i],
							imageUrlArray[i], accessUrlArray[i], urlTarget,
							loopTime, null, DateUtil.parse(startTimeArray[i],
									Constants.DATE_FORMAT), null);
					list.add(ad);
				}
			}

		}
		for (MapAdLocation mapAd : list) {
			mapAd.setPageType(location.getPageType());
			mapAd.setLocationType(location.getLocationType());
			mapAd.setCategory(location.getCategory());
		}
		try {
			imageAdService.addImageAd(list);
			model.addAttribute("result", 1);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			model.addAttribute("result", 0);
		}
		return null;
	}

	/**
	 * 删除图片广告
	 * 
	 * @Method_Name : deleteImageAd
	 * @param ad
	 *            主要参数为map映射关系表主键id和和图片广告主键adId ，可以为空
	 * @param model
	 * @return
	 * @return : String
	 * @Creation Date : 2014年5月29日 下午1:40:57
	 * @version : v1.00
	 * @Author : caozhifei
	 * @Update Date :
	 * @Update Author :
	 */
	@RequestMapping("deleteImageAd")
	public String deleteImageAd(MapAdLocation mapAd, Model model) {
		try {
			log.debug("delete mapAd param ==> "+mapAd);
			imageAdService.deleteImageAd(mapAd);
			model.addAttribute("result", 1);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			model.addAttribute("result", 0);
		}
		return null;
	}
}
