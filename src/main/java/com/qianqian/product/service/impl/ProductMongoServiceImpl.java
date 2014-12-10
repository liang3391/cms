package com.qianqian.product.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qianqian.product.dao.IProductDao;
import com.qianqian.product.service.IProductMongoService;

/**
 * Title:IProductMongoServiceImpl
 * @Description:同步Mongo实现
 * @Create_by:yinsy
 * @Create_date:2014-6-12
 * @Last_Edit_By:
 * @Edit_Description:
 * @version:manager.maxtp 1.0
 */
@Service("productMongoService")
public class ProductMongoServiceImpl implements IProductMongoService {
	
	private final static Logger log = LoggerFactory.getLogger(ProductMongoServiceImpl.class);

	@Autowired
	IProductDao productDao;

	@Override
	public int modifyPrdRecycleBin(Long productCode, Integer version, Integer status) throws Exception {
		try {
			productDao.modifyPrdRecycleBin(productCode, version, status);
		} catch (Exception e) {
			log.error("产品后台-修改产品回收站状态同步Mongo出错");
			throw new Exception();
		}
		return 0;
	}

	@Override
	public int modifyPrdEndStatus(Long productCode, Integer version, Integer status, Integer endStatus) throws Exception {
		try {
			productDao.modifyPrdEndStatus(productCode, version, status, endStatus);
		} catch (Exception e) {
			log.error("产品后台-修改活动结束状态同步Mongo出错");
			throw new Exception();
		}
		return 0;
	}
	
	
	
}
