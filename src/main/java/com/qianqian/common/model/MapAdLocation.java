package com.qianqian.common.model;

import java.math.BigDecimal;
import java.util.Date;
public class MapAdLocation {
    private Long id;

    private Long locationId;

    private Long adId;

    private Date startTime;

    private Date endTime;

    private Integer showState;

    private Long createBy;

    private Date createTime;

    private Long updateBy;

    private Date updateTime;
    
    private String imageUrl;

    private String accessUrl;

    private String urlTarget="_blank";

    private Integer loopTime;

    private String boardName;
    
	/**
	 * 页面类型
	 */
	private int pageType;
	/**
	 * 位置类型
	 */
	private int locationType;
	/**
	 * 商品类目
	 */
	private long category;

	//商品广告属性
	private String title;

    private String discount;

    private BigDecimal marketPrice;

    private BigDecimal nakedPrice;

    private Integer openCount;

    private Date activeStart;

    private Date activeEnd;

    private Long commodityId;

    private String commodityUrl;

    public int getPageType() {
		return pageType;
	}

	public void setPageType(int pageType) {
		this.pageType = pageType;
	}

	public int getLocationType() {
		return locationType;
	}

	public void setLocationType(int locationType) {
		this.locationType = locationType;
	}

	public long getCategory() {
		return category;
	}

	public void setCategory(long category) {
		this.category = category;
	}

	public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getLocationId() {
        return locationId;
    }

    public void setLocationId(Long locationId) {
        this.locationId = locationId;
    }

    public Long getAdId() {
        return adId;
    }

    public void setAdId(Long adId) {
        this.adId = adId;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Integer getShowState() {
        return showState;
    }

    public void setShowState(Integer showState) {
        this.showState = showState;
    }

    public Long getCreateBy() {
        return createBy;
    }

    public void setCreateBy(Long createBy) {
        this.createBy = createBy;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Long getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(Long updateBy) {
        this.updateBy = updateBy;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public String getAccessUrl() {
		return accessUrl;
	}

	public void setAccessUrl(String accessUrl) {
		this.accessUrl = accessUrl;
	}

	public String getUrlTarget() {
		return urlTarget;
	}

	public void setUrlTarget(String urlTarget) {
		this.urlTarget = urlTarget;
	}

	public Integer getLoopTime() {
		return loopTime;
	}

	public void setLoopTime(Integer loopTime) {
		this.loopTime = loopTime;
	}

	public String getBoardName() {
		return boardName;
	}

	public void setBoardName(String boardName) {
		this.boardName = boardName;
	}
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDiscount() {
		return discount;
	}

	public void setDiscount(String discount) {
		this.discount = discount;
	}

	public BigDecimal getMarketPrice() {
		return marketPrice;
	}

	public void setMarketPrice(BigDecimal marketPrice) {
		this.marketPrice = marketPrice;
	}

	public BigDecimal getNakedPrice() {
		return nakedPrice;
	}

	public void setNakedPrice(BigDecimal nakedPrice) {
		this.nakedPrice = nakedPrice;
	}

	public Integer getOpenCount() {
		return openCount;
	}

	public void setOpenCount(Integer openCount) {
		this.openCount = openCount;
	}

	public Date getActiveStart() {
		return activeStart;
	}

	public void setActiveStart(Date activeStart) {
		this.activeStart = activeStart;
	}

	public Date getActiveEnd() {
		return activeEnd;
	}

	public void setActiveEnd(Date activeEnd) {
		this.activeEnd = activeEnd;
	}

	public Long getCommodityId() {
		return commodityId;
	}

	public void setCommodityId(Long commodityId) {
		this.commodityId = commodityId;
	}

	public String getCommodityUrl() {
		return commodityUrl;
	}

	public void setCommodityUrl(String commodityUrl) {
		this.commodityUrl = commodityUrl;
	}

	public MapAdLocation(String locationId,String imageUrl, String accessUrl, String urlTarget,
			Integer loopTime, String boardName, Date startTime, Date endTime) {
		super();
		this.imageUrl = imageUrl;
		this.accessUrl = accessUrl;
		this.urlTarget = urlTarget;
		this.loopTime = loopTime;
		this.boardName = boardName;
		this.startTime = startTime;
		this.endTime = endTime;
		this.locationId = Long.valueOf(locationId);
	}
	

	public MapAdLocation(int pageType,int locationType,long category,Long locationId, Date startTime, Date endTime,
			String imageUrl, String urlTarget, String title, String discount,
			BigDecimal marketPrice, BigDecimal nakedPrice, Integer openCount,
			Date activeStart, Date activeEnd, Long commodityId,
			String commodityUrl) {
		super();
		this.pageType = pageType;
		this.locationType = locationType;
		this.category = category;
		this.locationId = locationId;
		this.startTime = startTime;
		this.endTime = endTime;
		this.imageUrl = imageUrl;
		this.urlTarget = urlTarget;
		this.title = title;
		this.discount = discount;
		this.marketPrice = marketPrice;
		this.nakedPrice = nakedPrice;
		this.openCount = openCount;
		this.activeStart = activeStart;
		this.activeEnd = activeEnd;
		this.commodityId = commodityId;
		this.commodityUrl = commodityUrl;
	}

	public MapAdLocation() {
		super();
	}

	@Override
	public String toString() {
		return "MapAdLocation [id=" + id + ", locationId=" + locationId
				+ ", adId=" + adId + ", startTime=" + startTime + ", endTime="
				+ endTime + ", showState=" + showState + ", createBy="
				+ createBy + ", createTime=" + createTime + ", updateBy="
				+ updateBy + ", updateTime=" + updateTime + ", imageUrl="
				+ imageUrl + ", accessUrl=" + accessUrl + ", urlTarget="
				+ urlTarget + ", loopTime=" + loopTime + ", boardName="
				+ boardName + ", pageType=" + pageType + ", locationType="
				+ locationType + ", category=" + category + ", title=" + title
				+ ", discount=" + discount + ", marketPrice=" + marketPrice
				+ ", nakedPrice=" + nakedPrice + ", openCount=" + openCount
				+ ", activeStart=" + activeStart + ", activeEnd=" + activeEnd
				+ ", commodityId=" + commodityId + ", commodityUrl="
				+ commodityUrl + "]";
	}

	
	
}