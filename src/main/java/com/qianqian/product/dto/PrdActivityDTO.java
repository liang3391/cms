package com.qianqian.product.dto;

import java.util.List;

import com.qianqian.product.model.ProductActivity;
import com.qianqian.product.model.ProductStandard;

/**
 * Title:PrdActivityDTO
 * @Description:产品活动DTO
 * @Create_by:yinsy
 * @Create_date:2014-6-19
 * @Last_Edit_By:
 * @Edit_Description:
 * @version:manager.maxtp 1.0
 */
public class PrdActivityDTO {
	/** 产品活动*/
	private ProductActivity prdAct;
	/** 规格DTO*/
	private List<ProductStandard> stdList;
	/** 商品dto*/
	private ProductStandDTO stdDto;
	/** 总库存*/
	private Integer totalStore;
	/** 上架时间*/
	private String onTime;
	/** 下架时间*/
	private String offTime;
	/** 产品类型 0裸价，1免费*/
	private Integer type;
	
	public ProductActivity getPrdAct() {
		return prdAct;
	}
	public void setPrdAct(ProductActivity prdAct) {
		this.prdAct = prdAct;
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
	public Integer getTotalStore() {
		return totalStore;
	}
	public void setTotalStore(Integer totalStore) {
		this.totalStore = totalStore;
	}
	public String getOnTime() {
		return onTime;
	}
	public void setOnTime(String onTime) {
		this.onTime = onTime;
	}
	public String getOffTime() {
		return offTime;
	}
	public void setOffTime(String offTime) {
		this.offTime = offTime;
	}
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
}