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
import com.qianqian.product.model.ProductActivityWrapper;
import com.qianqian.product.service.IProductMongoService;
import com.qianqian.product.service.IProductRecycleBinService;

@Service("productRecycleBinService")
public class ProductRecycleBinServiceImpl implements IProductRecycleBinService {
	
	private final static Logger log = LoggerFactory.getLogger(ProductRecycleBinServiceImpl.class);

	@Autowired
	ProductActivityMapper productActivityMapper;
	
	@Autowired
	ProductMapper productMapper;
	@Autowired
	IProductMongoService productMongoService;

	@Override
	public PageObject getRecycleBinList(ProductActivityWrapper act, int pageNo) throws Exception {
		try {
			String brandId = act.getBrandId();
			Long productCode = act.getProductCode();
			Integer reportStatus = act.getReportStatus();
			Integer type = act.getType();
			
			Map<String,Object> searchMap = new HashMap<String, Object>(); 
			searchMap.put("brandId", brandId);
			searchMap.put("productCode", productCode);
			searchMap.put("reportStatus", reportStatus);
			searchMap.put("type", type);
			
			PageBounds pageBounds = new PageBounds(pageNo,PageObject.DEFAULT_PAGE_SIZE);
			List<ProductActivityWrapper> prdActList = productActivityMapper.selectRecycleBinList(searchMap,pageBounds);
			return new PageObject(prdActList, pageBounds, pageNo);
		} catch (Exception e) {
			e.printStackTrace();
			log.error("prdAct/查询回收站产品列表出错");
			throw e;
		}
	}

	@Override
	public int modifyPrdRecover(long[] prdCodes,int status) throws Exception {
		StringBuilder sb = new StringBuilder();
		int ret = 0;
		try {
			for (Long prdCode : prdCodes) {
				sb.append(prdCode).append(",");
			}
			String prdCodeString =  sb.substring(0, sb.length()-1);
			ret = productMapper.updatePrdRecover(prdCodeString);
			
			//在售，从回收站恢复，同步Mongo操作
			if(status == Constants.PRD_STD_ONSELL){
				for(long prdCode : prdCodes){
					Map<String,Object> paraMap = new HashMap<String, Object>();
					paraMap.put("productCode", prdCode);
					int version = productMapper.selectMaxVer(paraMap);
					productMongoService.modifyPrdRecycleBin(prdCode, version, Constants.PRD_STD_ONSELL);
				}
			}
			return ret;
		}catch (Exception e) {
			e.printStackTrace();
			log.error("prdAct/将产品从回收站恢复出错");
			throw e;
		}
	}
	
}
