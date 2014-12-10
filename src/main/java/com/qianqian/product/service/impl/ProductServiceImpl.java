package com.qianqian.product.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.FilenameUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.framelib.utils.DateUtil;
import com.framelib.utils.StringUtil;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.qianqian.product.common.Constants;
import com.qianqian.product.common.ImageHandle;
import com.qianqian.product.common.PageObject;
import com.qianqian.product.dto.ProductDTO;
import com.qianqian.product.dto.ProductStandDTO;
import com.qianqian.product.dto.ProductStdDictDTO;
import com.qianqian.product.mapper.ProductActivityMapper;
import com.qianqian.product.mapper.ProductDetailMapper;
import com.qianqian.product.mapper.ProductMapper;
import com.qianqian.product.mapper.ProductPictureMapper;
import com.qianqian.product.mapper.ProductStandardDictMapper;
import com.qianqian.product.mapper.ProductStandardMapper;
import com.qianqian.product.mapper.ProductStatMapper;
import com.qianqian.product.model.Goods;
import com.qianqian.product.model.Product;
import com.qianqian.product.model.ProductActivityExample;
import com.qianqian.product.model.ProductActivityWrapper;
import com.qianqian.product.model.ProductDetail;
import com.qianqian.product.model.ProductDetailExample;
import com.qianqian.product.model.ProductExample;
import com.qianqian.product.model.ProductPicture;
import com.qianqian.product.model.ProductPictureExample;
import com.qianqian.product.model.ProductPreview;
import com.qianqian.product.model.ProductStandard;
import com.qianqian.product.model.ProductStandardDict;
import com.qianqian.product.model.ProductStandardDictExample;
import com.qianqian.product.model.ProductStandardExample;
import com.qianqian.product.model.ProductStat;
import com.qianqian.product.model.ProductStatExample;
import com.qianqian.product.service.IProductMongoService;
import com.qianqian.product.service.IProductService;
import com.qianqian.product.util.BeanUtil;
import com.qianqian.product.util.JSONMsgUtil;

@Service("productService")
public class ProductServiceImpl implements IProductService {
	
	private final static Logger log = LoggerFactory.getLogger(ProductServiceImpl.class);
	
	@Autowired
	ProductMapper productMapper;
	@Autowired
	ProductDetailMapper productDetailMapper;
	@Autowired
	ProductPictureMapper productPictureMapper;
	@Autowired
	ProductStandardMapper productStandardMapper;
	@Autowired
	ProductStandardDictMapper productStandardDictMapper;
	@Autowired
	ProductStatMapper productStatMapper;
	@Autowired
	IProductMongoService productMongoService;
	@Autowired
	ProductActivityMapper productActivityMapper;
	
	@Override
	public PageObject selectForSalePrd(Product prd, Integer pageNo)
			throws Exception {
		Map<String, Object> paraMap = new HashMap<String, Object>();
		paraMap.put("status", Constants.PRD_STD_FOR_SALE);
		paraMap.put("type", prd.getType());
		paraMap.put("brandId", prd.getBrandId());
		paraMap.put("productCode", prd.getProductCode());
		try {
			PageBounds pageBounds = new PageBounds(pageNo,PageObject.DEFAULT_PAGE_SIZE);
			List<ProductActivityWrapper> prdList = productMapper.selectPrdAct(paraMap,pageBounds);
			return new PageObject(prdList, pageBounds, pageNo);
		} catch (Exception e) {
			e.printStackTrace();
			log.error("prd/查询待售产品列表出错");
			throw new Exception();
		}
	}

	@Override
	public ProductDTO getProduct(Long prdCode, Integer ver) throws Exception {
		ProductDTO prdDto = new ProductDTO();
		List<Object> operList = setOperCondition(prdCode,ver);
		try {
			Product product = productMapper.selectByExample((ProductExample) operList.get(0)).get(0);
			ProductDetail detail = productDetailMapper.selectByExampleWithBLOBs((ProductDetailExample) operList.get(1)).get(0);
			ProductPicture picture = productPictureMapper.selectByExample((ProductPictureExample) operList.get(2)).get(0);
			ProductStandardExample prdStdExample = (ProductStandardExample) operList.get(3);
			prdStdExample.setOrderByClause("color_code,size_code");
			List<ProductStandard> stdList = productStandardMapper.selectByExample(prdStdExample);
			prdDto.setPrd(product);
			prdDto.setDetail(detail);
			prdDto.setPic(picture);
			prdDto.setStdList(stdList);
		} catch (Exception e) {
			e.printStackTrace();
			log.error("prd/获取产品信息出错");
			throw new Exception();
		}
		return prdDto;
	}
	
	@Override
	public Product addProduct(ProductDTO prdDto) throws Exception {
		long productCode = 0;
		int version = 0;
		setPrdParam(prdDto,1);	//设置默认时间
		Product prd = prdDto.getPrd();	//产品信息
		try {
			if(prd.getVersion() == null){
				prd.setVersion(Constants.PRD_VER_FIRST);
			}
			productMapper.insert(prd); //产品编号
			productCode = prd.getProductCode();
			version = prd.getVersion();			//产品版本号
			ProductDetail prDetail = prdDto.getDetail();
			prDetail.setProductCode(productCode);
			prDetail.setVersion(version);
			productDetailMapper.insert(prdDto.getDetail());
			ProductPicture picture = prdDto.getPic();
			picture.setProductCode(productCode);
			picture.setVersion(version);
			productPictureMapper.insert(prdDto.getPic());
			List<ProductStandard> stdList = getStandList(prdDto.getStdDto(),productCode,version);	//规格List
			if (stdList!=null) {
				productStandardMapper.insertBatch(stdList);
			}
		} catch (Exception e) {
			e.printStackTrace();
			log.error("prd/产品插入报错");
			throw new Exception();
		}
		return prd;
	}
	
	@Override
	public int modifyProduct(ProductDTO prdDto) throws Exception {
		Long productCode = prdDto.getPrd().getProductCode();
		Integer version = prdDto.getPrd().getVersion();
		List<Object> operList = setOperCondition(productCode,version);
		setPrdParam(prdDto, 2);	//设置修改产品参数
		try {
			productMapper.updateByExampleSelective(prdDto.getPrd(), (ProductExample) operList.get(0));
			productDetailMapper.updateByExampleSelective(prdDto.getDetail(), (ProductDetailExample) operList.get(1));
			productPictureMapper.updateByExampleSelective(prdDto.getPic(), (ProductPictureExample) operList.get(2));
			productStandardMapper.deleteByExample((ProductStandardExample) operList.get(3));
			List<ProductStandard> stdList = getStandList(prdDto.getStdDto(),productCode,version);	//规格List
			if (stdList!=null) {
				productStandardMapper.insertBatch(stdList);
			}
		} catch (Exception e) {
			e.printStackTrace();
			log.error("prd/修改产品出错");
			throw new Exception();
		}
		return 1;
	}
	
	/**
	 * 设置产品默认值
	 * @Create_by:yinsy
	 * @Create_date:2014-7-7
	 * @param product
	 * @param type 1、新增,2、修改
	 * @Last_Edit_By:
	 * @Edit_Description:
	 * @Create_Version:goods.maxtp 1.0
	 */
	private void setPrdParam(ProductDTO prdDto,Integer type){
		Product product = prdDto.getPrd();
		ProductPicture picture = prdDto.getPic();
		if (type == 1) {
			//在结束活动产品编辑产品时，也是进行新版本产品入库操作，此时status为2，不需对产品状态、申报状态进行默认设置
			if(product.getStatus()==null || product.getStatus()!=Constants.PRD_STD_ONSELL){
				product.setStatus(Constants.PRD_STD_FOR_SALE);	//产品状态，待售
				product.setReportStatus(Constants.PRD_STD_FOR_SALE);	//申报状态，待售
			}
//			product.setCraeteUserId(craeteUserId)
//			product.setCreateBy(createBy)
			product.setCreateTime(DateUtil.getCurrentDate());
			//为方便排序，新增产品时，修改时间也设为当前时间
			product.setModifyTime(DateUtil.getCurrentDate());
			product.setShowFlag(Constants.PRD_SHOW);		//展示状态
			product.setEditStatus(Constants.EDIT_STATUS);	//编辑状态
		}else {
//			product.setModifyBy(modifyBy)
//			product.setModifyBy(modifyBy)
			product.setModifyTime(DateUtil.getCurrentDate());
		}
		picture.setListPic(picture.getCenterPic());	//列表图230*230
		picture.setCommentPic(picture.getThumbnail());	//评价图70*70
		picture.setOrderPic(picture.getThumbnail());	//订单图80*80
		picture.setmListPic(picture.getThumbnail());	//后台列表图60*60
	}
	
	/**
	 * 设置操作条件
	 * @Create_by:yinsy
	 * @Create_date:2014-6-24
	 * @param productCode 产品编号
	 * @param version 版本
	 * @throws Exception
	 * @Last_Edit_By:
	 * @Edit_Description:
	 * @Create_Version:manager.maxtp 1.0
	 */
	private List<Object> setOperCondition(long productCode,int version) throws Exception{
		List<Object> list = new ArrayList<Object>();
		ProductExample prd = new ProductExample();
		prd.createCriteria().andProductCodeEqualTo(productCode).andVersionEqualTo(version);
		ProductDetailExample detail = new ProductDetailExample();
		detail.createCriteria().andProductCodeEqualTo(productCode).andVersionEqualTo(version);
		ProductPictureExample picture = new ProductPictureExample();
		picture.createCriteria().andProductCodeEqualTo(productCode).andVersionEqualTo(version);
		ProductStandardExample standard = new ProductStandardExample();
		standard.createCriteria().andProductCodeEqualTo(productCode).andVersionEqualTo(version);
		list.add(prd);
		list.add(detail);
		list.add(picture);
		list.add(standard);
		return list;
	}
	
	@Override
	public int modifyPrdStd(Long[] ids) throws Exception {
		StringBuilder sb = new StringBuilder();
		Map<String, Object> paraMap = new HashMap<String, Object>();
		try {
			for (Long id : ids) {
				sb.append(id).append(",");
			}
			paraMap.put("status", Constants.PRD_STD_RECYCLE_BIN);
			paraMap.put("ids", sb.substring(0, sb.length()-1));
		} catch (Exception e) {
			e.printStackTrace();
			log.error("prd/产品放入回收站出错");
		}
		return productMapper.updatePrdStd(paraMap);
	}
	
	@Override
	public List<ProductStandardDict> getProductStandDict() throws Exception {
		try {
			List<ProductStandardDict> list = productStandardDictMapper.selectDefDicts();
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			log.error("prd/获取规格信息出错");
			throw new Exception();
		}
	}
	
	@Override
	public ProductPreview toPreviewPrd(ProductDTO prdDto) throws Exception {
		ProductPreview prdPreview = null;	//产品预览对象
		Product product = prdDto.getPrd();	//产品
		try {
			prdPreview = (ProductPreview) BeanUtil.convertBean(product, ProductPreview.class);
		} catch (Exception e) {
			e.printStackTrace();
			log.error("prd/获取预览页出错");
			throw new Exception();
		}
		prdPreview.setDetail(prdDto.getDetail());
		prdPreview.setPicture(prdDto.getPic());
		prdPreview.setGoodList(getGoodList(prdDto.getStdDto()));	
		return prdPreview;
	}
	
	/**
	 * 获取规格list(预览页面)
	 * @Create_by:yinsy
	 * @Create_date:2014-9-17
	 * @param standDTO 规格DTO
	 * @return
	 * @throws Exception
	 * @Last_Edit_By:
	 * @Edit_Description:
	 * @Create_Version:goods.maxtp 1.0
	 */
	private List<Goods> getGoodList(ProductStandDTO standDTO) throws Exception{
		if (standDTO.getId()==null) {
			return null;
		}
		List<Goods> goodList = new ArrayList<Goods>();
		for (int i = 0; i < standDTO.getColorName().length; i++) {
			if (StringUtil.isEmpty(standDTO.getBarCode()[i])) {
				continue;
			}
			Goods goods = new Goods();
			goods.setColorName(standDTO.getColorName()[i]);
			goods.setColorArtwork(notEmpty(standDTO.getColorArtwork(),i));
			goods.setColorShow(notEmpty(standDTO.getColorShow(),i));
			goods.setSizeName(standDTO.getSizeName()[i]);
			goodList.add(goods);
		}
		return goodList;
	}
	
	@Override
	public ProductPreview getPreviewPrd(Long productCode, Integer version) throws Exception {
		Map<String, Object> paraMap = new HashMap<String, Object>();
		paraMap.put("productCode", productCode);
		paraMap.put("version", version);
		try {
			ProductPreview preview = productMapper.selectPrdPrev(paraMap);	//获取产品详情信息
			return preview;
		} catch (Exception e) {
			e.printStackTrace();
			log.error("prd/获取产品详情信息出错");
			throw new Exception();
		}
	}
	
	@Override
	public ProductStat getPrdStat(Long productCode) throws Exception {
		ProductStatExample example = new ProductStatExample();
		example.createCriteria().andProductCodeEqualTo(productCode);
		try {
			List<ProductStat> statList = productStatMapper.selectByExample(example);
			if (statList!=null&&statList.size()>0) {
				return statList.get(0);
			}
		} catch (Exception e) {
			e.printStackTrace();
			log.error("prd/获取产品统计信息出错");
			throw new Exception();
		}
		return null;
	}
	
	@Override
	public String uploadPrdImg(MultipartFile file,String param) throws Exception {
		try {
			String fileExt = FilenameUtils.getExtension(file.getOriginalFilename());
			Long fileSize = file.getSize();
			if (fileSize>Constants.MAX_SIZE) {
				return JSONMsgUtil.getError(Constants.res.getString("m.maxSize"));
			}else if (!Arrays.<String> asList(Constants.IMAGE_TYPE.split(",")).contains(fileExt)) {
				return JSONMsgUtil.getError(Constants.res.getString("m.ext"));
			}
			return JSONMsgUtil.getMsg(ImageHandle.getImg(file.getInputStream(),fileExt,fileSize,param));
		} catch (Exception e) {
			e.printStackTrace();
			return JSONMsgUtil.getError(Constants.res.getString("m.failed"));
		}
	}
	
	/**
	 * 获取规格list
	 * @Create_by:yinsy
	 * @Create_date:2014-6-12
	 * @param standDTO 规格DTO
	 * @param productCode 产品编码 
	 * @param version 版本号
	 * @return
	 * @Last_Edit_By:
	 * @Edit_Description:
	 * @Create_Version:manager.maxtp 1.0
	 */
	private List<ProductStandard> getStandList(ProductStandDTO standDTO,Long productCode,Integer version) throws Exception{
		if (standDTO.getId()==null) {
			return null;
		}
		List<ProductStandard> standList = new ArrayList<ProductStandard>();
		Map<String, Integer> standMap = getStandDictMap();
		for (int i = 0; i < standDTO.getColorName().length; i++) {
			if (StringUtil.isEmpty(standDTO.getBarCode()[i])) {
				continue;
			}
			ProductStandard standard = new ProductStandard();
			standard.setColorName(standDTO.getColorName()[i]);
			standard.setColorCode(getStandCode(standDTO.getColorName()[i], 0, standMap));
			standard.setColorArtwork(notEmpty(standDTO.getColorArtwork(),i));
			standard.setColorShow(notEmpty(standDTO.getColorShow(),i));
			standard.setSizeName(standDTO.getSizeName()[i]);
			standard.setSizeCode(getStandCode(standDTO.getSizeName()[i],1, standMap));
			standard.setBarCode(standDTO.getBarCode()[i]);
			standard.setProductCode(productCode);
			standard.setVersion(version);
			standList.add(standard);
		}
		return standList;
	}
	
	/**
	 * 判断是否为空
	 * @Create_by:yinsy
	 * @Create_date:2014-7-9
	 * @param str
	 * @return
	 * @Last_Edit_By:
	 * @Edit_Description:
	 * @Create_Version:goods.maxtp 1.0
	 */
	private String notEmpty(String[] str,Integer i){
		if (StringUtil.isEmpty(str)) {
			return null;
		}
		return str[i];
	}
	
	/**
	 * 获取规格字典Map
	 * @Create_by:yinsy
	 * @Create_date:2014-6-12
	 * @return
	 * @throws Exception
	 * @Last_Edit_By:
	 * @Edit_Description:
	 * @Create_Version:manager.maxtp 1.0
	 */
	private Map<String, Integer> getStandDictMap() throws Exception {
		Map<String, Integer> map = new HashMap<String, Integer>();
		ProductStandardDictExample example = new ProductStandardDictExample();
		example.setOrderByClause("type,sort");
		List<ProductStandardDict> list = productStandardDictMapper.selectByExample(example);
		for (ProductStandardDict dict : list) {
			map.put(dict.getStandardName(),dict.getCode());
		}
		return map;
	}
	
	/**
	 * 获取规格编号
	 * @Create_by:yinsy
	 * @Create_date:2014-6-12
	 * @param standName 规格名称
	 * @param standMap 规格Map
	 * @param type 类型0:颜色，1鞋码，2服饰码
	 * @return
	 * @throws Exception
	 * @Last_Edit_By:
	 * @Edit_Description:
	 * @Create_Version:manager.maxtp 1.0
	 */
	private Integer getStandCode(String standName,Integer type,Map<String, Integer> standMap) throws Exception {
		if (type==0&&!standName.endsWith(Constants.PRD_STAND_COLOR)) {
			standName += Constants.PRD_STAND_COLOR;
		}
		Integer code = standMap.get(standName);
		if (null!=code) {
			return code;
		}
		ProductStandardDict dict = new ProductStandardDict();
		dict.setSort(100);
		dict.setType(100);
		dict.setStandardName(standName);
		productStandardDictMapper.insert(dict);
		standMap.put(standName, dict.getCode());
		return dict.getCode();
	}

	@Override
	public ProductStdDictDTO getStdDictList(List<ProductStandard> stdList) throws Exception {
		ProductStdDictDTO dictDTO = new ProductStdDictDTO();
		List<ProductStandard> colorList = new ArrayList<ProductStandard>();
		List<ProductStandard> sizeList = new ArrayList<ProductStandard>();
		List<String> sizes = new ArrayList<String>();	//尺码
		String color = "";
		for (ProductStandard prdStd : stdList) {
			if (!color.equals(prdStd.getColorName())) {
				colorList.add(prdStd);
			}
			if (!sizes.contains(prdStd.getSizeName())) {
				sizeList.add(prdStd);
			}
			color = prdStd.getColorName();
			sizes.add(prdStd.getSizeName());
		}
		dictDTO.setColorList(colorList);
		dictDTO.setSizeList(sizeList);
		return dictDTO;
	}

	@Override
	public int modifyPrdStdToRecycle(Long[] prdCodes, Integer prdStatus)  throws Exception{
		StringBuilder sb = new StringBuilder();
		Map<String, Object> paraMap = new HashMap<String, Object>();
		int ret = 0;
		try {
			for (Long prdCode : prdCodes) {
				sb.append(prdCode).append(",");
			}
			String prdCodeString =  sb.substring(0, sb.length()-1);
			paraMap.put("status", Constants.PRD_STD_RECYCLE_BIN);
			paraMap.put("prdCodes",prdCodeString);
			paraMap.put("recycleTime", DateUtil.getCurrentDate());
			//将该产品版本最大的置为回收站状态
			ret = productMapper.updatePrdMaxVersionRecycle(paraMap);
			List<Long> prdList = Arrays.asList(prdCodes);
			
			//在售产品时删除版本为0的产品和活动
			if(Constants.PRD_STD_ONSELL == prdStatus){
				//删除版本为0的产品
				removeProduct(prdList);
				//放入回收站，同步Mongo
				syncProductRecycle(prdCodes);
			}
			
			//当待售产品，重新申报放入回收站时，将活动审核状态，审核人，审核时间置空
			if(Constants.PRD_STD_FOR_SALE == prdStatus){
				productActivityMapper.batchUpdateActCheckInfo(prdCodeString);
			}
		} catch (Exception e) {
			e.printStackTrace();
			log.error("prd/产品放入回收站出错");
			throw e;
		}
		return ret;
	}
	
	@Override
	public int modifyEndSaleProduct(ProductDTO  prdDto) throws Exception {
		Product product= prdDto.getPrd();
		long productCode = product.getProductCode();
		int version = product.getVersion();
		int ret = 0;
		int newVer = 0;//新版本为0
		
		try {
			//1、将修改后的产品入库操作,版本为0
			//设置产品状态
			product.setVersion(newVer);
			product.setStatus(Constants.PRD_STD_ONSELL);//在售
			product.setReportStatus(Constants.PRD_STD_ONSELL);//在售
			addProduct(prdDto);
			
			//2、将活动迁出新的版本，版本为0
			Map<String,Object> paraMap = new HashMap<String, Object>();
			paraMap.put("prdCode", productCode);
			paraMap.put("oldVer", version);
			paraMap.put("newVer", newVer);
			ret = productActivityMapper.insertNewPrdActFromOld(paraMap);
			
			//3、修改旧版本产品表中edit_status为1
			paraMap.clear();
			paraMap.put("prdCode", productCode);
			paraMap.put("version", version);
			paraMap.put("editStatus", Constants.EDIT_STATUS_YES);
			ret = productMapper.updateProductEditStatus(paraMap);
		} catch (Exception e) {
			e.printStackTrace();
			log.error("prd/体验/试用结束活动产品管理-编辑产品出错");
			throw e;
		}
		return ret;
	}
	
	/**
	 * 删除产品相关信息
	 * @Method_Name removeProduct
	 * @param prdList
	 * @Creation 2014-10-17下午03:14:29
	 * @Version v1.0.0
	 * @author wangchangsheng
	 * @UpdateDate:
	 * @UpdateAuthor:
	 */
	private void removeProduct(List<Long> prdList){
		//删除产品
		ProductExample productExm = new ProductExample();
		productExm.createCriteria().andProductCodeIn(prdList).andVersionEqualTo(0);
		productMapper.deleteByExample(productExm);
		
		//删除产品规格
		ProductStandardExample psExm = new ProductStandardExample();
		psExm.createCriteria().andProductCodeIn(prdList).andVersionEqualTo(0);
		productStandardMapper.deleteByExample(psExm);
		
		//删除产品图片
		ProductPictureExample ppExm = new ProductPictureExample();
		ppExm.createCriteria().andProductCodeIn(prdList).andVersionEqualTo(0);
		productPictureMapper.deleteByExample(ppExm);
		
		//删除产品详情
		ProductDetailExample pdExm = new ProductDetailExample();
		pdExm.createCriteria().andProductCodeIn(prdList).andVersionEqualTo(0);
		productDetailMapper.deleteByExample(pdExm);
		
		//删除活动
		ProductActivityExample paExm = new ProductActivityExample();
		paExm.createCriteria().andProductCodeIn(prdList).andVersionEqualTo(0);
		productActivityMapper.deleteByExample(paExm);
	}
	
	/**
	 * 同步将Mongo中产品设置回收站
	 * @Method_Name syncProductRecycle
	 * @param prdCodes
	 * @Creation 2014-10-17下午03:26:48
	 * @Version v1.0.0
	 * @author wangchangsheng
	 * @throws Exception 
	 * @UpdateDate:
	 * @UpdateAuthor:
	 */
	private void syncProductRecycle(Long[] prdCodes) throws Exception{
		for(Long prdCode : prdCodes){
			Map<String,Object> paraMap = new HashMap<String, Object>();
			paraMap.put("productCode", prdCode);
			int version = productMapper.selectMaxVer(paraMap);
			productMongoService.modifyPrdRecycleBin(prdCode, version, Constants.PRD_STD_RECYCLE_BIN);
		}
	}
}
