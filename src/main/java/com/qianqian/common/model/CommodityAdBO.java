package com.qianqian.common.model;

/**
 * 商品广告页面参数封装对象
 * @Project 	: cms.maxtp
 * @Program Name: com.qianqian.common.model.CommodityAdBO.java
 * @ClassName	: CommodityAdBO 
 * @Author 		: caozhifei 
 * @CreateDate  : 2014年5月30日 上午9:03:35
 */
public class CommodityAdBO {
	private int pageType;

    private long category;

    private int locationType;

    private int floor;
    
	private String adIds;
	
	private String locationIds;

    private String imageUrls;
    
    private String titles;

    private String discounts;

    private String marketPrices;

    private String nakedPrices;

    private String openCounts;

    private String activeStarts;

    private String activeEnds;

    private String commodityIds;

    private String commodityUrls;
    
    private String urlTarget;
    
    private String startTimes;
    private String endTimes;
  private String note;
    
    public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}
	

	@Override
	public String toString() {
		return "CommodityAdBO [pageType=" + pageType + ", category=" + category
				+ ", locationType=" + locationType + ", floor=" + floor
				+ ", adIds=" + adIds + ", locationIds=" + locationIds
				+ ", imageUrls=" + imageUrls + ", titles=" + titles
				+ ", discounts=" + discounts + ", marketPrices=" + marketPrices
				+ ", nakedPrices=" + nakedPrices + ", openCounts=" + openCounts
				+ ", activeStarts=" + activeStarts + ", activeEnds="
				+ activeEnds + ", commodityIds=" + commodityIds
				+ ", commodityUrls=" + commodityUrls + ", urlTarget="
				+ urlTarget + ", startTimes=" + startTimes + ", endTimes="
				+ endTimes + "]";
	}

	public String getStartTimes() {
		return startTimes;
	}

	public void setStartTimes(String startTimes) {
		this.startTimes = startTimes;
	}

	public String getEndTimes() {
		return endTimes;
	}

	public void setEndTimes(String endTimes) {
		this.endTimes = endTimes;
	}

	public int getPageType() {
		return pageType;
	}

	public void setPageType(int pageType) {
		this.pageType = pageType;
	}

	public long getCategory() {
		return category;
	}

	public void setCategory(long category) {
		this.category = category;
	}

	public int getLocationType() {
		return locationType;
	}

	public void setLocationType(int locationType) {
		this.locationType = locationType;
	}

	public int getFloor() {
		return floor;
	}

	public void setFloor(int floor) {
		this.floor = floor;
	}

	public String getAdIds() {
		return adIds;
	}

	public void setAdIds(String adIds) {
		this.adIds = adIds;
	}

	public String getLocationIds() {
		return locationIds;
	}

	public void setLocationIds(String locationIds) {
		this.locationIds = locationIds;
	}

	public String getImageUrls() {
		return imageUrls;
	}

	public void setImageUrls(String imageUrls) {
		this.imageUrls = imageUrls;
	}

	public String getTitles() {
		return titles;
	}

	public void setTitles(String titles) {
		this.titles = titles;
	}

	public String getDiscounts() {
		return discounts;
	}

	public void setDiscounts(String discounts) {
		this.discounts = discounts;
	}

	public String getMarketPrices() {
		return marketPrices;
	}

	public void setMarketPrices(String marketPrices) {
		this.marketPrices = marketPrices;
	}

	public String getNakedPrices() {
		return nakedPrices;
	}

	public void setNakedPrices(String nakedPrices) {
		this.nakedPrices = nakedPrices;
	}

	public String getOpenCounts() {
		return openCounts;
	}

	public void setOpenCounts(String openCounts) {
		this.openCounts = openCounts;
	}

	public String getActiveStarts() {
		return activeStarts;
	}

	public void setActiveStarts(String activeStarts) {
		this.activeStarts = activeStarts;
	}

	public String getActiveEnds() {
		return activeEnds;
	}

	public void setActiveEnds(String activeEnds) {
		this.activeEnds = activeEnds;
	}

	public String getCommodityIds() {
		return commodityIds;
	}

	public void setCommodityIds(String commodityIds) {
		this.commodityIds = commodityIds;
	}

	public String getCommodityUrls() {
		return commodityUrls;
	}

	public void setCommodityUrls(String commodityUrls) {
		this.commodityUrls = commodityUrls;
	}

	public String getUrlTarget() {
		return urlTarget;
	}

	public void setUrlTarget(String urlTarget) {
		this.urlTarget = urlTarget;
	}

	
}
