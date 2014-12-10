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
import com.qianqian.product.model.ProductActivity;
import com.qianqian.product.model.ProductActivityWrapper;
import com.qianqian.product.service.IProductMongoService;
import com.qianqian.product.service.IProductOnSaleService;

@Service("productOnSaleService")
public class ProductOnSaleServiceImpl implements IProductOnSaleService {
	
	private final static Logger log = LoggerFactory.getLogger(ProductOnSaleServiceImpl.class);

	@Autowired
	ProductActivityMapper productActivityMapper;
	@Autowired
	IProductMongoService productMongoService;
	
	@Override
	public PageObject getOnSaleProductList(ProductActivityWrapper act,int pageNo) throws Exception {
		String brandId = act.getBrandId();
		Long productCode = act.getProductCode();
		Long actCode = act.getId();
		Integer actStatus = act.getStatus();
		
		Map<String,Object> searchMap = new HashMap<String, Object>(); 
		searchMap.put("brandId", brandId);
		searchMap.put("productCode", productCode);
		searchMap.put("actCode", actCode);
		searchMap.put("type", act.getType());
		searchMap.put("actStatus", actStatus);
			
		try {
			PageBounds pageBounds = new PageBounds(pageNo,PageObject.DEFAULT_PAGE_SIZE);
			List<ProductActivityWrapper> prdActList = productActivityMapper.selectOnSaleProductList(searchMap,pageBounds);
			return new PageObject(prdActList, pageBounds, pageNo);
		} catch (Exception e) {
			e.printStackTrace();
			log.error("prdAct/查询体验中产品列表出错");
			throw e;
		}
	}

	@Override
	public int modifyStopOnSaleProduct(List<String> actIds, String type) throws Exception {
		try {
			Map<String,Object> searchMap = new HashMap<String, Object>();
			searchMap.put("actIds", actIds);
			searchMap.put("type", type);
			int ret = productActivityMapper.batchUpdateActEnd(searchMap);
			
			int actStatus = 0;
			int prdType = Integer.parseInt(type);
			if(prdType == Constants.PRD_STD){
				actStatus = Constants.NAKED_ACT_STAT_END;
			}else{
				actStatus = Constants.FREE_ACT_STAT_END;
			}
			for(String actId : actIds){
				ProductActivity act = productActivityMapper.selectByPrimaryKey(Long.parseLong(actId));
				productMongoService.modifyPrdEndStatus(act.getProductCode(), act.getVersion(), actStatus,Constants.ACT_END_STAT_FORCE);
			}
			return ret;
		} catch (Exception e) {
			e.printStackTrace();
			log.error("prdAct/终止体验中产品出错");
			throw e;
		}
	}

	@Override
	public PageObject getEndSaleProductList(ProductActivityWrapper act,int pageNo) throws Exception {
		String brandId = act.getBrandId();
		Long productCode = act.getProductCode();
		Long actCode = act.getId();
		Integer endStatus = act.getEndStatus();
		
		Map<String,Object> searchMap = new HashMap<String, Object>(); 
		searchMap.put("brandId", brandId);
		searchMap.put("productCode", productCode);
		searchMap.put("actCode", actCode);
		searchMap.put("type", act.getType());
		searchMap.put("endStatus", endStatus);
			
		try {
			PageBounds pageBounds = new PageBounds(pageNo,PageObject.DEFAULT_PAGE_SIZE);
			List<ProductActivityWrapper> prdActList = productActivityMapper.selectEndSaleProductList(searchMap,pageBounds);
			return new PageObject(prdActList, pageBounds, pageNo);
		} catch (Exception e) {
			e.printStackTrace();
			log.error("prdAct/查询体验结束产品列表出错");
			throw e;
		}
	}

	@Override
	public PageObject getEditingProductList(ProductActivityWrapper act,int pageNo) throws Exception {
		String brandId = act.getBrandId();
		Long productCode = act.getProductCode();
		
		Map<String,Object> searchMap = new HashMap<String, Object>(); 
		searchMap.put("brandId", brandId);
		searchMap.put("productCode", productCode);
		searchMap.put("type", act.getType());
			
		try {
			PageBounds pageBounds = new PageBounds(pageNo,PageObject.DEFAULT_PAGE_SIZE);
			List<ProductActivityWrapper> prdActList = productActivityMapper.selectEditingProductList(searchMap,pageBounds);
			return new PageObject(prdActList, pageBounds, pageNo);
		} catch (Exception e) {
			e.printStackTrace();
			log.error("prdAct/查询编辑中产品列表出错");
			throw e;
		}
	}
	
}
