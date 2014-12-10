package com.qianqian.product.dto;

import java.util.List;

import com.qianqian.product.model.ProductStandard;

/**
 * Title:ProductStdDictDTO
 * @Description:规格字典DTO
 * @Create_by:yinsy
 * @Create_date:2014-7-8
 * @Last_Edit_By:
 * @Edit_Description:
 * @version:goods.maxtp 1.0
 */
public class ProductStdDictDTO {
	/** 颜色list*/
	private List<ProductStandard> colorList;
	/** 尺码list*/
	private List<ProductStandard> sizeList;
	
	public List<ProductStandard> getColorList() {
		return colorList;
	}
	public void setColorList(List<ProductStandard> colorList) {
		this.colorList = colorList;
	}
	public List<ProductStandard> getSizeList() {
		return sizeList;
	}
	public void setSizeList(List<ProductStandard> sizeList) {
		this.sizeList = sizeList;
	}
	
}
