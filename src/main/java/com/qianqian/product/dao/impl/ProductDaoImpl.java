package com.qianqian.product.dao.impl;

import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import com.framelib.dao.MongoBaseDAO;
import com.framelib.utils.DateUtil;
import com.qianqian.product.common.Constants;
import com.qianqian.product.dao.IProductDao;

/**
 * Title:ProductDaoImpl
 * @Description:产品接口实现
 * @Create_by:yinsy
 * @Create_date:2014-5-15
 * @Last_Edit_By:
 * @Edit_Description:
 * @version:detail.maxtp 1.0
 */
@Repository("productDao")
public class ProductDaoImpl extends MongoBaseDAO implements IProductDao {

	@Override
	public void modifyPrdRecycleBin(Long productCode, Integer version, Integer status) throws Exception {
		MongoTemplate template = getTemplateProductDB();
		Update update = new Update();
		update.set("status",status);
		template.updateFirst(new Query(Criteria.where("productCode").is(productCode).and("version").is(version)), update,
				Constants.PRD_PRODUCT_MONGO);
	}

	@Override
	public void modifyPrdEndStatus(Long productCode, Integer version, Integer status,Integer endStatus) throws Exception {
		MongoTemplate template = getTemplateProductDB();
		Update update = new Update();
		update.set("status",status);
		update.addToSet("endStatus", endStatus);
		update.addToSet("endTime", DateUtil.getCurrentDate());
		template.updateFirst(new Query(Criteria.where("productCode").is(productCode).and("version").is(version)), update,
				Constants.PRD_PRODUCT_ACTIVITY_MONGO);
	}

}
