package com.qianqian.product.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.qianqian.product.common.PageObject;
import com.qianqian.product.dto.ProductDTO;
import com.qianqian.product.dto.ProductStdDictDTO;
import com.qianqian.product.model.Product;
import com.qianqian.product.model.ProductPreview;
import com.qianqian.product.model.ProductStandard;
import com.qianqian.product.model.ProductStandardDict;
import com.qianqian.product.model.ProductStat;

/**
 * Title:IProductService
 * @Description:产品发布接口
 * @Create_by:yinsy
 * @Create_date:2014-6-5
 * @Last_Edit_By:
 * @Edit_Description:
 * @version:manager.maxtp 1.0
 */
public interface IProductService {
	
	/**
	 * 获取产品信息
	 * @Create_by:yinsy
	 * @Create_date:2014-6-10
	 * @param prdCode 产品编号
	 * @param ver 版本
	 * @return
	 * @throws Exception
	 * @Last_Edit_By:
	 * @Edit_Description:
	 * @Create_Version:manager.maxtp 1.0
	 */
	ProductDTO getProduct(Long prdCode,Integer ver) throws Exception;
	
	/**
	 * 获取待售产品列表
	 * @Create_by:yinsy
	 * @Create_date:2014-6-20
	 * @param prd 产品
	 * @param pageNo 当前页
	 * @return
	 * @throws Exception
	 * @Last_Edit_By:
	 * @Edit_Description:
	 * @Create_Version:manager.maxtp 1.0
	 */
	PageObject selectForSalePrd(Product prd,Integer pageNo) throws Exception;
	
	/**
	 * 获取产品规格字典信息，初始化产品发布页面
	 * @Create_by:yinsy
	 * @Create_date:2014-6-12
	 * @return
	 * @throws Exception
	 * @Last_Edit_By:
	 * @Edit_Description:
	 * @Create_Version:manager.maxtp 1.0
	 */
	List<ProductStandardDict> getProductStandDict() throws Exception;
	
	/**
	 * 新增产品信息
	 * @Create_by:yinsy
	 * @Create_date:2014-6-10
	 * @param prdDto 产品DTO
	 * @return
	 * @throws Exception
	 * @Last_Edit_By:
	 * @Edit_Description:
	 * @Create_Version:manager.maxtp 1.0
	 */
	Product addProduct(ProductDTO prdDto) throws Exception;
	
	/**
	 * 拼装规格字典
	 * @Create_by:yinsy
	 * @Create_date:2014-7-8
	 * @param stdList
	 * @return
	 * @throws Exception
	 * @Last_Edit_By:
	 * @Edit_Description:
	 * @Create_Version:goods.maxtp 1.0
	 */
	ProductStdDictDTO getStdDictList(List<ProductStandard> stdList) throws Exception;
	
	/**
	 * 修改产品信息
	 * @Create_by:yinsy
	 * @Create_date:2014-6-10
	 * @param prdDto 产品DTO
	 * @return
	 * @throws Exception
	 * @Last_Edit_By:
	 * @Edit_Description:
	 * @Create_Version:manager.maxtp 1.0
	 */
	int modifyProduct(ProductDTO prdDto) throws Exception;
	
	/**
	 * 将产品放入回收站
	 * @Create_by:yinsy
	 * @Create_date:2014-6-20
	 * @param ids 产品ID集合
	 * @return
	 * @throws Exception
	 * @Last_Edit_By:
	 * @Edit_Description:
	 * @Create_Version:manager.maxtp 1.0
	 */
	int modifyPrdStd(Long[] ids) throws Exception;
	
	/**
	 * 产品预览
	 * @Create_by:yinsy
	 * @Create_date:2014-6-10
	 * @return
	 * @throws Exception
	 * @Last_Edit_By:
	 * @Edit_Description:
	 * @Create_Version:manager.maxtp 1.0
	 */
	ProductPreview toPreviewPrd(ProductDTO prdDto) throws Exception;
	
	/**
	 * 获取产品详情信息
	 * @Create_by:yinsy
	 * @Create_date:2014-8-25
	 * @param productCode
	 * @param version
	 * @return
	 * @throws Exception
	 * @Last_Edit_By:
	 * @Edit_Description:
	 * @Create_Version:goods.maxtp 1.0
	 */
	ProductPreview getPreviewPrd(Long productCode,Integer version) throws Exception;
	
	/**
	 * 获取产品统计信息
	 * @Create_by:yinsy
	 * @Create_date:2014-8-27
	 * @param productCode 产品编号
	 * @return
	 * @throws Exception
	 * @Last_Edit_By:
	 * @Edit_Description:
	 * @Create_Version:goods.maxtp 1.0
	 */
	ProductStat getPrdStat(Long productCode) throws Exception;

	/**
	 * 上传产品图片
	 * @Create_by:yinsy
	 * @Create_date:2014-6-5
	 * @param request
	 * @param param 要上传的图的类型
	 * @return
	 * @throws Exception
	 * @Last_Edit_By:
	 * @Edit_Description:
	 * @Create_Version:manager.maxtp 1.0
	 */
	String uploadPrdImg(MultipartFile file,String param) throws Exception;

	/**
	 * 将产品放入回收站（将该产品的最大版本置为回收站状态）
	 * @Method_Name modifyPrdStdToRecycle
	 * @param removeAct
	 * @param prdStatus
	 * @return
	 * @Creation 2014-8-27下午02:07:43
	 * @Version v1.0.0
	 * @author wangchangsheng
	 * @UpdateDate:
	 * @UpdateAuthor:
	 */
	int modifyPrdStdToRecycle(Long[] removeAct, Integer prdStatus) throws Exception;
	
	/**
	 * 体验结束活动产品管理--编辑产品
	 * @Method_Name modifyEndSaleProduct
	 * @param prd
	 * @return
	 * @Creation 2014-9-10上午11:19:14
	 * @Version v1.0.0
	 * @author wangchangsheng
	 * @throws Exception 
	 * @UpdateDate:
	 * @UpdateAuthor:
	 */
	int modifyEndSaleProduct(ProductDTO  prd) throws Exception;
	
}
