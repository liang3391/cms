package com.qianqian.product.dto;

/**
 * Title:ProductStandDTO
 * @Description:产品规格DTO
 * @Create_by:yinsy
 * @Create_date:2014-6-10
 * @Last_Edit_By:
 * @Edit_Description:
 * @version:manager.maxtp 1.0
 */
public class ProductStandDTO {
	
	private Long[] id;
	
    private String[] colorName;

    private String[] colorArtwork;	//原图300*300

    private String[] colorShow;		//展示图35*35

    private String[] sizeName;

    private Integer[] store;

    private Long[] barCode;	//条形码

    private String[] quickMark;	//二维码
    
    private Integer type = 1;	//1鞋码，2服饰码

	public Long[] getId() {
		return id;
	}

	public void setId(Long[] id) {
		this.id = id;
	}

	public String[] getColorName() {
		return colorName;
	}

	public void setColorName(String[] colorName) {
		this.colorName = colorName;
	}
	
	public String[] getColorArtwork() {
		return colorArtwork;
	}

	public void setColorArtwork(String[] colorArtwork) {
		this.colorArtwork = colorArtwork;
	}

	public String[] getColorShow() {
		return colorShow;
	}

	public void setColorShow(String[] colorShow) {
		this.colorShow = colorShow;
	}

	public String[] getSizeName() {
		return sizeName;
	}

	public void setSizeName(String[] sizeName) {
		this.sizeName = sizeName;
	}

	public Integer[] getStore() {
		return store;
	}

	public void setStore(Integer[] store) {
		this.store = store;
	}

	public Long[] getBarCode() {
		return barCode;
	}

	public void setBarCode(Long[] barCode) {
		this.barCode = barCode;
	}

	public String[] getQuickMark() {
		return quickMark;
	}

	public void setQuickMark(String[] quickMark) {
		this.quickMark = quickMark;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}
	
}
