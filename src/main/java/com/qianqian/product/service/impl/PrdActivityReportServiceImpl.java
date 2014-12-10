package com.qianqian.product.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.qianqian.product.common.Constants;
import com.qianqian.product.common.PageObject;
import com.qianqian.product.mapper.ProductActivityMapper;
import com.qianqian.product.mapper.ProductMapper;
import com.qianqian.product.mapper.ProductStandardMapper;
import com.qianqian.product.model.ProductActivityWrapper;
import com.qianqian.product.service.IPrdActivityReportService;
import com.qianqian.product.service.IProductMongoService;

/**
 * 活动重新申报接口实现
 * @Name PrdActivityReportServiceImpl
 * @Creation 2014-8-14下午03:42:59
 * @Version v1.0.0
 * @author wangchangsheng
 * @UpdateDate:
 * @UpdateAuthor:
 */
@Service("PrdActivityReportService")
public class PrdActivityReportServiceImpl implements IPrdActivityReportService {

	private final static Logger log = LoggerFactory.getLogger(PrdActivityReportServiceImpl.class);

	@Autowired
	ProductActivityMapper productActivityMapper;
	
	@Override
	public PageObject getPrdActReportList(ProductActivityWrapper act,int pageNo) throws Exception {
		try {
			String brandId = act.getBrandId();
			Long productCode = act.getProductCode();
			Long actCode = act.getId();
			Integer prdStatus = act.getPrdStatus();
			
			Map<String,Object> searchMap = new HashMap<String, Object>(); 
			searchMap.put("brandId", brandId);
			searchMap.put("productCode", productCode);
			searchMap.put("actCode", actCode);
			searchMap.put("type", act.getType());
			searchMap.put("prdStatus", prdStatus);
			
			PageBounds pageBounds = new PageBounds(pageNo,PageObject.DEFAULT_PAGE_SIZE);
			List<ProductActivityWrapper> prdActList = productActivityMapper.selectPrdActReportList(searchMap,pageBounds);
			return new PageObject(prdActList, pageBounds, pageNo);
		} catch (Exception e) {
			e.printStackTrace();
			log.error("prdAct/查询重新申报管理列表出错");
			throw e;
		}
	}

	@Override
	public PageObject getActCheckRecord(ProductActivityWrapper act, int pageNo) throws Exception {
		try {
			String brandId = act.getBrandId();
			Long productCode = act.getProductCode();
			Long actCode = act.getId();
			Integer checkStatus = act.getCheckStatus();
			
			Map<String,Object> searchMap = new HashMap<String, Object>(); 
			searchMap.put("brandId", brandId);
			searchMap.put("productCode", productCode);
			searchMap.put("actCode", actCode);
			searchMap.put("checkStatus", checkStatus);
			searchMap.put("type", act.getType());
			
			PageBounds pageBounds = new PageBounds(pageNo,PageObject.DEFAULT_PAGE_SIZE);
			List<ProductActivityWrapper> prdActList = productActivityMapper.selectActCheckRecord(searchMap,pageBounds);
			return new PageObject(prdActList, pageBounds, pageNo);
		} catch (Exception e) {
			e.printStackTrace();
			log.error("prdAct/查询复核记录列表出错");
			throw e;
		}
	}

	
}
