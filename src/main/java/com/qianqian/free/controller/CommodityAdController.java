package com.qianqian.free.controller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.framelib.utils.DateUtil;
import com.framelib.utils.StringUtil;
import com.qianqian.common.model.CommodityAdBO;
import com.qianqian.common.model.MapAdLocation;
import com.qianqian.common.service.ICommodityAdService;
import com.qianqian.common.utils.Constants;


/**
 * 商品广告发布控制器
 * 
 * @Project : cms.maxtp
 * @Program Name: com.qianqian.naked.controller.CommodityAdController.java
 * @ClassName : CommodityAdController
 * @Author : caozhifei
 * @CreateDate : 2014年5月29日 上午10:24:11
 */
@Controller("commodityFree")
@RequestMapping("free/commodityAd")
public class CommodityAdController {
	private static Logger log = LoggerFactory
			.getLogger(CommodityAdController.class);
	@Resource
	private ICommodityAdService commodityAdService;

	/**
	 * 商品广告进行发布操作
	 * 
	 * @Method_Name : releaseCommodityAd
	 * @param bo
	 *            页面参数封装对象
	 * @param model
	 * @return
	 * @return : String
	 * @Creation Date : 2014年6月3日 下午3:22:47
	 * @version : v1.00
	 * @Author : caozhifei
	 * @Update Date :
	 * @Update Author :
	 */
	@RequestMapping("releaseCommodityAd")
	public String releaseCommodityAd(CommodityAdBO bo, Model model) {
		log.debug(" param =>" + bo.toString());
		if (StringUtil.isBlank(bo.getLocationIds())
				|| StringUtil.isBlank(bo.getCommodityIds())
				|| StringUtil.isBlank(bo.getImageUrls())
				|| StringUtil.isBlank(bo.getTitles())
				|| StringUtil.isBlank(bo.getNakedPrices())
				|| StringUtil.isBlank(bo.getOpenCounts())
				|| StringUtil.isBlank(bo.getCommodityUrls())) {
			model.addAttribute("result", 0);
			return null;
		}
		String[] locationIds = bo.getLocationIds().split(",");
		String[] commodityIds = bo.getCommodityIds().split(",");
		String[] imageUrls = bo.getImageUrls().split(",");
		String[] titles = bo.getTitles().split(",");
		String[] nakedPrices = bo.getNakedPrices().split(",");
		String[] openCounts = bo.getOpenCounts().split(",");
		String[] commodityUrls = bo.getCommodityUrls().split(",");
		String urlTarget = bo.getUrlTarget() == null ? "_blank" : bo
				.getUrlTarget();
		int len = locationIds.length;
		String[] startTimes = null;
		if (!StringUtil.isBlank(bo.getStartTimes())) {
			startTimes = bo.getStartTimes().split(",");
		} else {
			Date currentDate = new Date();
			startTimes = new String[len];
			for (int i = 0; i < len; i++) {
				startTimes[i] = DateUtil.format(currentDate,
						Constants.DATE_FORMAT);
			}
		}
		String[] endTimes = null;
		if (!StringUtil.isBlank(bo.getEndTimes())) {
			endTimes = bo.getEndTimes().split(",");
		}
		String[] discounts = new String[len];
		if (!StringUtil.isBlank(bo.getDiscounts())) {
			discounts = bo.getDiscounts().split(",");
		}
		String[] marketPrices = null;
		if (!StringUtil.isBlank(bo.getMarketPrices())) {
			marketPrices = bo.getMarketPrices().split(",");
		}
		String[] activeStarts = new String[len];
		if (!StringUtil.isBlank(bo.getActiveStarts())) {
			activeStarts = bo.getActiveStarts().split(",");
		}
		String[] activeEnds = new String[len];
		if (!StringUtil.isBlank(bo.getActiveEnds())) {
			activeEnds = bo.getActiveEnds().split(",");
		}
		List<MapAdLocation> list = new ArrayList<MapAdLocation>();
		if (locationIds.length > 0 && len == locationIds.length
				&& len == commodityIds.length && len == imageUrls.length
				&& len == titles.length && len == nakedPrices.length
				&& len == openCounts.length && len == commodityUrls.length) {
			try {
				if (startTimes != null && endTimes == null
						&& marketPrices != null) {
					for (int i = 0; i < len; i++) {
						Date activeStart = null;
						Date activeEnd = null;
						if (activeStarts[i] != null) {
							activeStart = DateUtil.parse(activeStarts[i],
									Constants.DATE_FORMAT);
						}
						if (activeEnds[i] != null) {
							activeEnd = DateUtil.parse(activeEnds[i],
									Constants.DATE_FORMAT);
						}
						MapAdLocation mapAd = new MapAdLocation(
								bo.getPageType(), bo.getLocationType(),
								bo.getCategory(), Long.valueOf(locationIds[i]),
								DateUtil.parse(startTimes[i],
										Constants.DATE_FORMAT), null,
								imageUrls[i], urlTarget, titles[i],
								discounts[i], BigDecimal.valueOf(Double
										.valueOf(marketPrices[i])),
								BigDecimal.valueOf(Double
										.valueOf(nakedPrices[i])),
								Integer.valueOf(openCounts[i]), activeStart,
								activeEnd, Long.valueOf(commodityIds[i]),
								commodityUrls[i]);
						list.add(mapAd);
					}

				}
				if (startTimes != null && endTimes == null
						&& marketPrices == null) {
					for (int i = 0; i < len; i++) {
						Date activeStart = null;
						Date activeEnd = null;
						if (activeStarts[i] != null) {
							activeStart = DateUtil.parse(activeStarts[i],
									Constants.DATE_FORMAT);
						}
						if (activeEnds[i] != null) {
							activeEnd = DateUtil.parse(activeEnds[i],
									Constants.DATE_FORMAT);
						}
						MapAdLocation mapAd = new MapAdLocation(
								bo.getPageType(), bo.getLocationType(),
								bo.getCategory(), Long.valueOf(locationIds[i]),
								DateUtil.parse(startTimes[i],
										Constants.DATE_FORMAT), null,
								imageUrls[i], urlTarget, titles[i],
								discounts[i], null, BigDecimal.valueOf(Double
										.valueOf(nakedPrices[i])),
								Integer.valueOf(openCounts[i]), activeStart,
								activeEnd, Long.valueOf(commodityIds[i]),
								commodityUrls[i]);
						list.add(mapAd);
					}

				}
				if (startTimes != null && endTimes != null
						&& marketPrices == null) {
					for (int i = 0; i < len; i++) {
						Date activeStart = null;
						Date activeEnd = null;
						if (activeStarts[i] != null) {
							activeStart = DateUtil.parse(activeStarts[i],
									Constants.DATE_FORMAT);
						}
						if (activeEnds[i] != null) {
							activeEnd = DateUtil.parse(activeEnds[i],
									Constants.DATE_FORMAT);
						}
						MapAdLocation mapAd = new MapAdLocation(
								bo.getPageType(), bo.getLocationType(),
								bo.getCategory(), Long.valueOf(locationIds[i]),
								DateUtil.parse(startTimes[i],
										Constants.DATE_FORMAT), DateUtil.parse(
										endTimes[i], Constants.DATE_FORMAT),
								imageUrls[i], urlTarget, titles[i],
								discounts[i], null, BigDecimal.valueOf(Double
										.valueOf(nakedPrices[i])),
								Integer.valueOf(openCounts[i]), activeStart,
								activeEnd, Long.valueOf(commodityIds[i]),
								commodityUrls[i]);
						list.add(mapAd);
					}

				}
				if (startTimes != null && endTimes != null
						&& marketPrices != null) {
					for (int i = 0; i < len; i++) {
						Date activeStart = null;
						Date activeEnd = null;
						if (activeStarts[i] != null) {
							activeStart = DateUtil.parse(activeStarts[i],
									Constants.DATE_FORMAT);
						}
						if (activeEnds[i] != null) {
							activeEnd = DateUtil.parse(activeEnds[i],
									Constants.DATE_FORMAT);
						}
						MapAdLocation mapAd = new MapAdLocation(
								bo.getPageType(), bo.getLocationType(),
								bo.getCategory(), Long.valueOf(locationIds[i]),
								DateUtil.parse(startTimes[i],
										Constants.DATE_FORMAT), DateUtil.parse(
										endTimes[i], Constants.DATE_FORMAT),
								imageUrls[i], urlTarget, titles[i],
								discounts[i], BigDecimal.valueOf(Double
										.valueOf(marketPrices[i])),
								BigDecimal.valueOf(Double
										.valueOf(nakedPrices[i])),
								Integer.valueOf(openCounts[i]), activeStart,
								activeEnd, Long.valueOf(commodityIds[i]),
								commodityUrls[i]);
						list.add(mapAd);
					}

				}

				commodityAdService.addCommodityAd(list);
				model.addAttribute("result", 1);
			} catch (Exception e) {
				log.error(e.getMessage(), e);
				model.addAttribute("result", 0);
			}

		} else {
			// 参数不完整
			model.addAttribute("result", 0);
		}

		return null;
	}

	/**
	 * 删除图片广告
	 * 
	 * @Method_Name : deleteCommodityAd
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
	@RequestMapping("deleteCommodityAd")
	public String deleteCommodityAd(MapAdLocation mapAd, Model model) {
		try {
			log.debug("delete mapAd param ==> " + mapAd);
			commodityAdService.deleteCommodityAd(mapAd);
			model.addAttribute("result", 1);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			model.addAttribute("result", 0);
		}
		return null;
	}
}
