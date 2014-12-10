package com.qianqian.product.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.framelib.utils.DateUtil;
import com.framelib.utils.StringUtil;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.qianqian.product.common.Constants;
import com.qianqian.product.common.PageObject;
import com.qianqian.product.dto.PrdActivityDTO;
import com.qianqian.product.dto.ProductStandDTO;
import com.qianqian.product.mapper.ProductActivityMapper;
import com.qianqian.product.mapper.ProductMapper;
import com.qianqian.product.mapper.ProductStandardMapper;
import com.qianqian.product.model.Product;
import com.qianqian.product.model.ProductActivity;
import com.qianqian.product.model.ProductActivityExample;
import com.qianqian.product.model.ProductActivityWrapper;
import com.qianqian.product.model.ProductExample;
import com.qianqian.product.model.ProductStandard;
import com.qianqian.product.model.ProductStandardExample;
import com.qianqian.product.service.IPrdActivityCheckService;
import com.qianqian.product.service.IProductMongoService;

/**
 * 复核活动管理接口实现
 * @Name PrdActivityCheckServiceImpl
 * @Creation 2014-8-12
 * @Version 
 * @author wangchangsheng
 * @UpdateDate:
 * @UpdateAuthor:
 */
@Service("PrdActivityCheckService")
public class PrdActivityCheckServiceImpl implements IPrdActivityCheckService {

	private final static Logger log = LoggerFactory.getLogger(PrdActivityCheckServiceImpl.class);

	@Autowired
	ProductActivityMapper productActivityMapper;
	@Autowired
	ProductStandardMapper productStandardMapper;
	@Autowired
	ProductMapper productMapper;
	@Autowired
	IProductMongoService productMongoService;

	@Override
	public PageObject getPrdActCheckList(ProductActivityWrapper act, int pageNo) throws Exception {
		String brandId = act.getBrandId();
		Long productCode = act.getProductCode();
		Long actCode = act.getId();
		Integer checkStatus = act.getCheckStatus();
		Integer prdStatus = act.getPrdStatus();
		
		Map<String,Object> searchMap = new HashMap<String, Object>(); 
		searchMap.put("brandId", brandId);
		searchMap.put("productCode", productCode);
		searchMap.put("actCode", actCode);
		searchMap.put("checkStatus", checkStatus);
		searchMap.put("type", act.getType());
		searchMap.put("prdStatus", prdStatus);
		
		try {
			PageBounds pageBounds = new PageBounds(pageNo,PageObject.DEFAULT_PAGE_SIZE);
			List<ProductActivityWrapper> prdActList = productActivityMapper.selectPrdActCheckList(searchMap,pageBounds);
			return new PageObject(prdActList, pageBounds, pageNo);
		} catch (Exception e) {
			e.printStackTrace();
			log.error("prdAct/查询复核活动管理列表出错");
			throw e;
		}
	}

	@Override
	public int modifyActivityConfirmState(long prdCode, int ver) throws Exception {
		Map<String,Object> paramMap = new HashMap<String,Object>();
		paramMap.put("prdCode", prdCode);
		paramMap.put("ver", ver);
		paramMap.put("confirmUser", "");
		paramMap.put("confirmUserId", 11111);
		
		try {
			int ret = productActivityMapper.updateConfirmState(paramMap);
			return ret;
		} catch (Exception e) {
			e.printStackTrace();
			log.error("prdAct/运营确认活动展示出错");
			throw e;
		}
	}

	@Override
	public int modifyActReportBatch(List<String> actCodeList) throws Exception {
		try {
			int ret = productActivityMapper.batchUpdateActReport(actCodeList);
			return ret;
		} catch (Exception e) {
			e.printStackTrace();
			log.error("prdAct/查询复核活动管理列表出错");
			throw e;
		}
	}
}
