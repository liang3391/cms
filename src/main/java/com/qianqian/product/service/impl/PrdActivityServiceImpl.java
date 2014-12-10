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
import com.qianqian.product.common.Constants;
import com.qianqian.product.dto.PrdActivityDTO;
import com.qianqian.product.dto.ProductStandDTO;
import com.qianqian.product.mapper.ProductActivityMapper;
import com.qianqian.product.mapper.ProductMapper;
import com.qianqian.product.mapper.ProductStandardMapper;
import com.qianqian.product.model.Product;
import com.qianqian.product.model.ProductActivity;
import com.qianqian.product.model.ProductActivityExample;
import com.qianqian.product.model.ProductExample;
import com.qianqian.product.model.ProductPreview;
import com.qianqian.product.model.ProductStandard;
import com.qianqian.product.model.ProductStandardExample;
import com.qianqian.product.service.IPrdActivityService;
import com.qianqian.product.service.IProductMongoService;

/**
 * Title:PrdActivetyServiceImpl
 * @Description:活动接口实现
 * @Create_by:yinsy
 * @Create_date:2014-6-18
 * @Last_Edit_By:
 * @Edit_Description:
 * @version:manager.maxtp 1.0
 */
@Service("PrdActivityService")
public class PrdActivityServiceImpl implements IPrdActivityService {

	private final static Logger log = LoggerFactory.getLogger(PrdActivityServiceImpl.class);

	@Autowired
	ProductActivityMapper productActivityMapper;
	@Autowired
	ProductStandardMapper productStandardMapper;
	@Autowired
	ProductMapper productMapper;
	@Autowired
	IProductMongoService productMongoService;

	@Override
	public PrdActivityDTO getPrdActivity(Long prdCode, Integer ver) throws Exception {
		ProductActivityExample prdActExample = new ProductActivityExample();
		ProductStandardExample prdStdExample = new ProductStandardExample();
		PrdActivityDTO prdActivityDTO = new PrdActivityDTO();
		prdActExample.createCriteria().andProductCodeEqualTo(prdCode).andVersionEqualTo(ver);
		prdStdExample.createCriteria().andProductCodeEqualTo(prdCode).andVersionEqualTo(ver);
		prdStdExample.setOrderByClause("color_code,size_code");
		try {
			List<ProductActivity> prdActList = productActivityMapper.selectByExample(prdActExample);
			if (prdActList != null && prdActList.size() > 0) {
				prdActivityDTO.setPrdAct(prdActList.get(0));
			}
			List<ProductStandard> stdList = productStandardMapper.selectByExample(prdStdExample);
			prdActivityDTO.setStdList(stdList);
			return prdActivityDTO;
		} catch (Exception e) {
			e.printStackTrace();
			log.error("prdAct/获取活动信息和产品规格信息出错");
			throw new Exception();
		}
	}

	@Override
	public Integer addOrModifyPrdActivity(PrdActivityDTO activityDTO,Integer flag) throws Exception {
		ProductStandardExample prdStdExample = new ProductStandardExample();
		ProductExample prdExample = new ProductExample();
		Long productCode = activityDTO.getPrdAct().getProductCode();
		Integer version = activityDTO.getPrdAct().getVersion();
		prdStdExample.createCriteria().andProductCodeEqualTo(productCode).andVersionEqualTo(version);
		prdExample.createCriteria().andProductCodeEqualTo(productCode).andVersionEqualTo(version);
		if (flag==1) {
			activityDTO.getPrdAct().setCheckStatus(Constants.ACT_STAT_WAIT_CK);
		}
		try {
			if (activityDTO.getPrdAct().getId() != null) {
				setPrdActDef(activityDTO,2);	//设置活动默认信息
				productActivityMapper.updateByPrimaryKeySelective(activityDTO.getPrdAct());
			} else {
				setPrdActDef(activityDTO,1);	//设置活动默认信息
				ProductActivity activity = activityDTO.getPrdAct();
				productActivityMapper.insert(activity);
			}
			// 批量插入规格
			activityDTO.setStdList(getStandList(activityDTO.getStdDto(), productCode, version));
			productStandardMapper.deleteByExample(prdStdExample);	//删除所有规格
			productStandardMapper.insertBatch(activityDTO.getStdList());
			productMapper.updateByExampleSelective(getPrdStore(activityDTO.getTotalStore()), prdExample);	//修改库存
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
			log.error("prdAct/新增或修改活动信息出错");
			throw new Exception();
		}
	}
	

	/**
	 * 封装商品处理
	 * @Create_by:yinsy
	 * @Create_date:2014-6-30
	 * @param stdDto  规格dto
	 * @param prdCode 产品编码
	 * @param ver     版本号
	 * @return
	 * @throws Exception
	 * @Last_Edit_By:
	 * @Edit_Description:
	 * @Create_Version:goods.maxtp 1.0
	 */
	private List<ProductStandard> getStandList(ProductStandDTO stdDto, Long prdCode, Integer ver) throws Exception {
		Map<Long, Integer> storeMap = new HashMap<Long, Integer>();
		List<ProductStandard> stndList = new ArrayList<ProductStandard>();
		for (int i = 0; i < stdDto.getId().length; i++) {
			storeMap.put(stdDto.getId()[i], stdDto.getStore()[i]);
		}
		ProductStandardExample prdStdExample = new ProductStandardExample();
		prdStdExample.createCriteria().andProductCodeEqualTo(prdCode).andVersionEqualTo(ver);
		List<ProductStandard> list = productStandardMapper.selectByExample(prdStdExample);
		for (ProductStandard prdStd : list) {
			prdStd.setStore(storeMap.get(prdStd.getId()));
			stndList.add(prdStd);
		}
		return stndList;
	}
	
	
	/**
	 * 设置活动默认信息
	 * @Create_by:yinsy
	 * @Create_date:2014-6-30
	 * @param activityDTO 活动信息
	 * @param type 操作类型 1 新增，2修改，3审核
	 * @Last_Edit_By:
	 * @Edit_Description:
	 * @Create_Version:goods.maxtp 1.0
	 */
	private void setPrdActDef(PrdActivityDTO activityDTO,Integer type) throws Exception{
		ProductActivity prdAct = activityDTO.getPrdAct();
		prdAct.setOnTime(DateUtil.parse(activityDTO.getOnTime(), Constants.DATE_FORMAT_PATTERN));
		if (StringUtil.notEmpty(activityDTO.getOffTime())) {
			prdAct.setOffTime(DateUtil.parse(activityDTO.getOffTime(), Constants.DATE_FORMAT_PATTERN));
		}
		if (type==1) {
//			prdAct.setCreateBy(createBy)
//			prdAct.setCreateUserId(createUserId);
			prdAct.setCreateTime(DateUtil.getCurrentDate());
			//为方便排序，新增活动时，修改时间也设为当前时间
			prdAct.setModifyTime(DateUtil.getCurrentDate());
		}else if (type==2) {
//			prdAct.setModifyBy(modifyBy);
//			prdAct.setModifyUserId(modifyUserId);
			prdAct.setModifyTime(DateUtil.getCurrentDate());
			prdAct.setCheckBy(null);
			prdAct.setCheckReason(null);
			prdAct.setCheckUserId(null);
			prdAct.setCheckTime(null);
		}else {
//			prdAct.setCheckBy(checkBy);
//			prdAct.setCheckUserId(checkUserId)
//			prdAct.setCheckTime(DateUtil.getCurrentDate());
		}
	}
	
	/**
	 * 封装产品库存处理
	 * @Create_by:yinsy
	 * @Create_date:2014-6-30
	 * @param store 库存
	 * @return
	 * @throws Exception
	 * @Last_Edit_By:
	 * @Edit_Description:
	 * @Create_Version:goods.maxtp 1.0
	 */
	private Product getPrdStore(Integer store) throws Exception{
		Product prd = new Product();
		prd.setTotalStore(store);
		prd.setOpenExperience(store);
		return prd;
	}

	@Override
	public Integer getPrdActStatus(Long prdCode, Integer ver) throws Exception {
		ProductActivityExample prdActExample = new ProductActivityExample();
		prdActExample.createCriteria().andProductCodeEqualTo(prdCode).andVersionEqualTo(ver);
		try {
			List<ProductActivity> prdActList = productActivityMapper.selectByExample(prdActExample);
			if (prdActList != null && prdActList.size() > 0) {
				return prdActList.get(0).getCheckStatus();
			}
			return 0;
		} catch (Exception e) {
			e.printStackTrace();
			log.error("prdAct/获取活动状态出错");
			throw new Exception();
		}
	}
	
	@Override
	public ProductPreview toActPrev(Long productCode, Integer version,PrdActivityDTO activityDTO) throws Exception {
		Map<String, Object> paraMap = new HashMap<String, Object>();
		paraMap.put("productCode", productCode);
		paraMap.put("version", version);
		ProductActivity prdAct = activityDTO.getPrdAct();
		prdAct.setOnTime(DateUtil.parse(activityDTO.getOnTime(), Constants.DATE_FORMAT_PATTERN));
		if (StringUtil.notEmpty(activityDTO.getOffTime())) {
			prdAct.setOffTime(DateUtil.parse(activityDTO.getOffTime(), Constants.DATE_FORMAT_PATTERN));
		}
		try {
			ProductPreview preview = productMapper.selectPrdPrev(paraMap);	//获取产品详情信息
			preview.setActivity(prdAct);
			preview.setDiscount(getDisCount(preview));	//设置折扣信息
			return preview;
		} catch (Exception e) {
			e.printStackTrace();
			log.error("prd/获取活动预览信息出错");
			throw new Exception();
		}
	}
	
	@Override
	public ProductPreview getActPrev(Long productCode, Integer version) throws Exception {
		Map<String, Object> paraMap = new HashMap<String, Object>();
		paraMap.put("productCode", productCode);
		paraMap.put("version", version);
		try {
			ProductPreview preview = productMapper.selectPrdActDetail(paraMap);	//获取产品活动详情信息
			preview.setDiscount(getDisCount(preview));	//设置折扣信息
			if (Constants.PRD_STD_FREE==preview.getType()) {	//免费试用
				ProductActivity activity = preview.getActivity();
				//新增天数
				int addDay = Constants.FREE_ACT_TIME_APPLY+Constants.FREE_ACT_TIME_CHECK+Constants.FREE_ACT_TIME_SUBMIT;
				activity.setOffTime(DateUtil.addDay(activity.getOnTime(), addDay));		//结束时间设置为开始时间+免费试用流程时间
			}
			return preview;
		} catch (Exception e) {
			e.printStackTrace();
			log.error("prd/获取活动详情信息出错");
			throw new Exception();
		}
	}
	
	/**
	 * 获取折扣
	 * @Create_by:yinsy
	 * @Create_date:2014-8-25
	 * @param preview
	 * @return
	 * @Last_Edit_By:
	 * @Edit_Description:
	 * @Create_Version:goods.maxtp 1.0
	 */
	private Float getDisCount(ProductPreview preview){
		if (preview!=null&&preview.getActivity()!=null&&preview.getActivity().getPrice()!=null) {
			float discount = preview.getActivity().getPrice().floatValue()/preview.getMarketPrice().floatValue();
			return (float)Math.round(discount*100)/10;
		}else {
			return null;
		}
	}
	
	@Override
	public Integer insertNewPrdActFromOld(Long productCode, int oldVersion,int newVersion) throws Exception {
		int ret = 0;
		Map<String,Object> paramMap = new HashMap<String, Object>();
		paramMap.put("prdCode", productCode);
		paramMap.put("oldVer", oldVersion);
		paramMap.put("newVer", newVersion);
		
		try {
			//迁出新版本活动
			ret = productActivityMapper.insertNewPrdActFromOld(paramMap);
		} catch (Exception e) {
			e.printStackTrace();
			log.error("prd/迁出新版本活动出错");
			throw e;
		}
		return ret;
	}

}
