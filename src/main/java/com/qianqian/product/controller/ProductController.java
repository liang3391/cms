package com.qianqian.product.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.qianqian.product.common.Constants;
import com.qianqian.product.common.PageObject;
import com.qianqian.product.dto.ProductDTO;
import com.qianqian.product.dto.ProductStdDictDTO;
import com.qianqian.product.model.Product;
import com.qianqian.product.model.ProductPreview;
import com.qianqian.product.model.ProductStandardDict;
import com.qianqian.product.service.IProductService;
import com.qianqian.product.util.ResponseUtil;

/**
 * Title:ProductController
 * @Description:商品处理
 * @Create_by:yinsy
 * @Create_date:2014-5-26
 * @Last_Edit_By:
 * @Edit_Description:
 * @version:manager.maxtp 1.0
 */
@Controller
public class ProductController {
	
	@Autowired
	IProductService productService;
	
	/**
	 * 进入产品编辑页面
	 * @Create_by:yinsy
	 * @Create_date:2014-6-10
	 * @param PrdAttrDTO 产品属性DTO
	 * @param modelMap
	 * @return
	 * @throws Exception 
	 * @Last_Edit_By:
	 * @Edit_Description:
	 * @Create_Version:manager.maxtp 1.0
	 */
	@RequestMapping("prd/toPrd")
	public String toProduct(ProductDTO prdDto,ModelMap modelMap) throws Exception{
		List<ProductStandardDict> dictList = productService.getProductStandDict();
		modelMap.put("dictList", dictList);
		modelMap.put("prdDto", prdDto);
		return "product/product";
	}
	
	
	/**
	 * 查询待售产品信息
	 * @Create_by:yinsy
	 * @Create_date:2014-6-20
	 * @param prd
	 * @param pageBounds
	 * @param modelMap
	 * @return
	 * @throws Exception 
	 * @Last_Edit_By:
	 * @Edit_Description:
	 * @Create_Version:manager.maxtp 1.0
	 */
	@RequestMapping("prd/selectForSalePrd")
	public String selectForSalePrd(Product prd,ModelMap modelMap,HttpServletRequest request) throws Exception{
		int pageNo = PageObject.getPageNum(request);
		PageObject pageObject = productService.selectForSalePrd(prd, pageNo);
		modelMap.put("po", pageObject);
		modelMap.put("prd", prd);
		return "product/prdForSale";
	}
	
	/**
	 * 获取产品信息
	 * @Create_by:yinsy
	 * @Create_date:2014-6-10
	 * @param modelMap
	 * @param prdCode 产品编号
	 * @param ver 版本
	 * @param from 调用该方法来源
	 * @return
	 * @throws Exception 
	 * @Last_Edit_By:
	 * @Edit_Description:
	 * @Create_Version:manager.maxtp 1.0
	 */
	@RequestMapping("prd/getPrd")
	public String getProduct(Long prdCode,Integer ver,String from,ModelMap modelMap,HttpServletRequest request) throws Exception{
		ProductDTO prdDto = productService.getProduct(prdCode, ver);
		ProductStdDictDTO dictDto = productService.getStdDictList(prdDto.getStdList());
		request.setAttribute("detail", prdDto.getDetail().getDetail());
		modelMap.put("prdDto", prdDto);
		modelMap.put("dictDto", dictDto);
		modelMap.put("from", from);
		return "product/product";
	}
	
	/**
	 * 新增产品信息
	 * @Create_by:yinsy
	 * @Create_date:2014-6-10
	 * @param modelMap
	 * @param prdDto 产品DTO
	 * @return
	 * @throws Exception 
	 * @Last_Edit_By:
	 * @Edit_Description:
	 * @Create_Version:manager.maxtp 1.0
	 */
	@RequestMapping("prd/addPrd")
	public String addProduct(ProductDTO prdDto) throws Exception{
		Product prd = productService.addProduct(prdDto);
		return "redirect:/prd/toReleasePrd.htm?prdCode="+prd.getProductCode()+"&ver="+prd.getVersion()+"&type="+prd.getType();
	}
	
	/**
	 * 修改产品信息
	 * @Create_by:yinsy
	 * @Create_date:2014-6-10
	 * @param modelMap
	 * @param prdDto 产品DTO
	 * @return
	 * @throws Exception 
	 * @Last_Edit_By:
	 * @Edit_Description:
	 * @Create_Version:manager.maxtp 1.0
	 */
	@RequestMapping("prd/modifyPrd")
	public String modifyProduct(ProductDTO prdDto,String from) throws Exception{
		productService.modifyProduct(prdDto);
		String returnUrl = "";
		//重新申报管理中编辑产品
		if("report".equals(from)){
			returnUrl = "redirect:/act/getActReportList.htm?type="+prdDto.getPrd().getType()+"&prdStatus=1";
		}else if("editing".equals(from)){		//编辑中产品管理编辑产品
			returnUrl = "redirect:/prd/getEditingProductList.htm?type="+prdDto.getPrd().getType();
		}else if("forsale".equals(from)){
			returnUrl = "redirect:/prd/selectForSalePrd.htm?type="+prdDto.getPrd().getType();
		}else{		//默认，产品发布编辑产品
			returnUrl = "redirect:/prd/toReleasePrd.htm?prdCode="+prdDto.getPrd().getProductCode()+
					"&ver="+prdDto.getPrd().getVersion()+"&type="+prdDto.getPrd().getType();
		}
		return returnUrl;
	}
	
	/**
	 * 产品发布成功
	 * @Create_by:yinsy
	 * @Create_date:2014-7-22
	 * @return
	 * @throws Exception
	 * @Last_Edit_By:
	 * @Edit_Description:
	 * @Create_Version:goods.maxtp 1.0
	 */
	@RequestMapping("prd/toReleasePrd")
	public String toReleasePrd() throws Exception{
		return "product/prdsuc";
	}
	
	/**
	 * 产品预览
	 * @Create_by:yinsy
	 * @Create_date:2014-6-10
	 * @param modelMap
	 * @return
	 * @Last_Edit_By:
	 * @Edit_Description:
	 * @Create_Version:manager.maxtp 1.0
	 */
	@RequestMapping("prd/toPreviewPrd")
	public String toPreviewPrd(ProductDTO prdDto,ModelMap modelMap) throws Exception{
		ProductPreview preview = productService.toPreviewPrd(prdDto);
		preview.setType(0);
		modelMap.put("prd", preview);
		if (Constants.PRD_STD==preview.getType()) {
			return "product/preview";
		}
		return "product/previewFree";
	}
	
	/**
	 * 获取产品预览信息
	 * @Create_by:yinsy
	 * @Create_date:2014-8-25
	 * @param productCode 产品编码
	 * @param version 产品版本
	 * @param modelMap
	 * @return
	 * @throws Exception 
	 * @Last_Edit_By:
	 * @Edit_Description:
	 * @Create_Version:goods.maxtp 1.0
	 */
	@RequestMapping("prd/getPreviewPrd")
	public String getPreviewPrd(Long productCode,Integer version,ModelMap modelMap) throws Exception{
		//productCode=200359954301L;
		//version = 1;
		ProductPreview preview = productService.getPreviewPrd(productCode, version);
		modelMap.put("prd", preview);
		//preview.setType(1);
		if (Constants.PRD_STD==preview.getType()) {
			return "product/preview";
		}
		return "product/previewFree";
	}
	
	/**
	 * 获取产品统计信息
	 * @Create_by:yinsy
	 * @Create_date:2014-8-27
	 * @param productCode 产品编号
	 * @return
	 * @Last_Edit_By:
	 * @Edit_Description:
	 * @Create_Version:goods.maxtp 1.0
	 */
	@RequestMapping("prd/getPrdStat")
	public String getPrdStat(Long productCode,ModelMap modelMap) throws Exception{
		modelMap.put("prdStat",productService.getPrdStat(productCode));
		return null;
	}
	
	/**
	 * 将产品放入回收站
	 * @Create_by:yinsy
	 * @Create_date:2014-6-20
	 * @param ids id集合
	 * @param type 类型，0裸价，1免费
	 * @return
	 * @throws Exception 
	 * @Last_Edit_By:
	 * @Edit_Description:
	 * @Create_Version:manager.maxtp 1.0
	 */
	@RequestMapping("prd/modifyPrdStd")
	public String modifyPrdStd(Long[] ids,Integer type) throws Exception{
		productService.modifyPrdStd(ids);
		return "redirect:/prd/selectForSalePrd.htm?type="+type;
	}
	
	/**
	 * 上传产品图片
	 * @Create_by:yinsy
	 * @Create_date:2014-6-5
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception 
	 * @Last_Edit_By:
	 * @Edit_Description:
	 * @Create_Version:manager.maxtp 1.0
	 */
	@RequestMapping("prd/uploadPrdImg")
	public String uploadPrdImg(HttpServletRequest request,HttpServletResponse response) throws Exception {
		MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
		MultipartFile file = multipartRequest.getFile("file");
		String param = request.getParameter("param");
		ResponseUtil.renderText(response, productService.uploadPrdImg(file,param));
		return null;
	}
	
}
