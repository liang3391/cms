package com.qianqian.product.junit;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.framelib.dao.MongoBaseDAO;
import com.qianqian.product.common.Constants;
import com.qianqian.product.dao.IProductDao;
import com.qianqian.product.mapper.ProductActivityMapper;
import com.qianqian.product.mapper.ProductDetailMapper;
import com.qianqian.product.mapper.ProductMapper;
import com.qianqian.product.mapper.ProductStandardDictMapper;
import com.qianqian.product.mapper.ProductStatMapper;
import com.qianqian.product.model.Goods;
import com.qianqian.product.model.Product;
import com.qianqian.product.model.ProductActivity;
import com.qianqian.product.model.ProductDetail;
import com.qianqian.product.model.ProductDetailExample;
import com.qianqian.product.model.ProductMongo;
import com.qianqian.product.model.ProductPreview;
import com.qianqian.product.model.ProductStandardDict;
import com.qianqian.product.util.BeanUtil;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:spring/applicationContext.xml")
@SuppressWarnings("restriction")
public class InitDBData extends MongoBaseDAO {
	
	@Resource
	private ProductMapper productMapper;
	@Resource
	private ProductActivityMapper productActivityMapper;
	@Resource
	private ProductStatMapper productStatMapper;
	@Resource
	private ProductStandardDictMapper productStandardDictMapper;
	@Resource
	private ProductDetailMapper productDetailMapper;
	@Resource
	private IProductDao prDao;
	
	long productCode = 500359952259L;
	
	int version = 1;
	
	@Test
	public void initDB() throws Exception{
		System.out.println("数据初始化开始.....");
//		testDetail();
//		testPrd();
//		testStandDict();
		System.out.println("数据初始化结束.....");
	}
	
	@Test
	public void testPrdPrev(){
		Map<String, Object> paraMap = new HashMap<String, Object>();
		paraMap.put("productCode", 100359954068l);
		paraMap.put("version", 1);
		ProductPreview preview = productMapper.selectPrdPrev(paraMap);
		System.out.println("productName:"+preview.getProductName());
		System.out.println("detail:"+preview.getDetail());
		System.out.println("picture:"+preview.getPicture());
		System.out.println("activity:"+preview.getActivity());
		List<Goods> goodList = preview.getGoodList();
		System.out.println("stdList:"+goodList);
	}
	
	@Test
	public void testMongo(){
		try {
			Product product = productMapper.selectByPrimaryKey(95553500359954052l);
			ProductActivity prdActivity = productActivityMapper.selectByPrimaryKey(5553500359952869l);
			ProductMongo prdMongo = (ProductMongo) BeanUtil.convertBean(product, ProductMongo.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void modifyMongo(){
		MongoTemplate template = getTemplateProductDB();
		Query query = new Query(Criteria.where("id").is(3553500359954048l).and("endStatus").is(null));
		ProductActivity activity = template.findOne(query,ProductActivity.class,Constants.PRD_PRODUCT_ACTIVITY_MONGO);
		System.out.println(activity+"-------"+activity.getPurpose());
		Update update = new Update();
		update.set("endStatus", 1);
		template.updateFirst(query, update, ProductActivity.class,Constants.PRD_PRODUCT_ACTIVITY_MONGO);
	}
	
	public void testPrd() throws Exception{
		Product product = new Product();
		product.setBrandName("阿迪达斯");
		product.setProductName("阿迪达斯男鞋");
		product.setShowFlag(1);
		System.out.println(productMapper.insert(product));
		System.out.println(product.getProductCode());
	}
	
	public void testStandDict() throws Exception{
		ProductStandardDict dict = new ProductStandardDict();
		dict.setSort(100);
		dict.setStandardName("bbbccccaaaaaaaa");
		dict.setType(1);
		System.out.println(productStandardDictMapper.insert(dict));
		System.out.println("code:"+dict.getCode());
		System.out.println("id:"+dict.getId());
	}
	
	public void testDetail() throws Exception{
		ProductDetailExample detail = new ProductDetailExample();
		detail.createCriteria().andProductCodeEqualTo(productCode).andVersionEqualTo(version);
		ProductDetail detail2 = productDetailMapper.selectByExampleWithBLOBs(detail).get(0);
		System.out.println(detail2.getDetail());
	}
}
