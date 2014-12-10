package com.qianqian.product.dto;

import java.util.List;

import com.qianqian.product.model.Product;
import com.qianqian.product.model.ProductDetail;
import com.qianqian.product.model.ProductPicture;
import com.qianqian.product.model.ProductStandard;

/**
 * Title:ProductDTO
 * @Description:产品DTO
 * @Create_by:yinsy
 * @Create_date:2014-6-10
 * @Last_Edit_By:
 * @Edit_Description:
 * @version:manager.maxtp 1.0
 */
public class ProductDTO {
	
	/** 产品*/
	private Product prd;
	
	/** 产品规格*/
	private List<ProductStandard> stdList;
	
	/** 商品dto*/
	private ProductStandDTO stdDto;
	
	/** 产品详情*/
	private ProductDetail detail;
	
	/** 产品图片*/
	private ProductPicture pic;

	public Product getPrd() {
		return prd;
	}

	public void setPrd(Product prd) {
		this.prd = prd;
	}

	public List<ProductStandard> getStdList() {
		return stdList;
	}

	public void setStdList(List<ProductStandard> stdList) {
		this.stdList = stdList;
	}

	public ProductStandDTO getStdDto() {
		return stdDto;
	}

	public void setStdDto(ProductStandDTO stdDto) {
		this.stdDto = stdDto;
	}

	public ProductDetail getDetail() {
		return detail;
	}

	public void setDetail(ProductDetail detail) {
		this.detail = detail;
	}

	public ProductPicture getPic() {
		return pic;
	}

	public void setPic(ProductPicture pic) {
		this.pic = pic;
	}
}
