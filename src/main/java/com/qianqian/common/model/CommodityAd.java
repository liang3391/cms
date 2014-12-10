package com.qianqian.common.model;

import java.math.BigDecimal;
import java.util.Date;

public class CommodityAd {
    private Long adId;

    private String imageUrl;

    private String title;

    private String discount;

    private BigDecimal marketPrice;

    private BigDecimal nakedPrice;

    private Integer openCount;

    private Date activeStart;

    private Date activeEnd;

    private Long commodityId;

    private String commodityUrl;

    private String urlTarget="_blank";

    private Integer adState=1;

    private Long createBy;

    private Date createTime;
    private String note;
    
    public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	private Long updateBy;

    private Date updateTime;
    /**
     * 广告与广告位映射关系ID
     */
    private Long id;
    /**
     * 位置ID
     */
    private Long locationId;

    public Long getAdId() {
        return adId;
    }

    public void setAdId(Long adId) {
        this.adId = adId;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl == null ? null : imageUrl.trim();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getDiscount() {
        return discount;
    }

    public void setDiscount(String discount) {
        this.discount = discount == null ? null : discount.trim();
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
        this.commodityUrl = commodityUrl == null ? null : commodityUrl.trim();
    }

    public String getUrlTarget() {
        return urlTarget;
    }

    public void setUrlTarget(String urlTarget) {
        this.urlTarget = urlTarget == null ? null : urlTarget.trim();
    }

    public Integer getAdState() {
        return adState;
    }

    public void setAdState(Integer adState) {
        this.adState = adState;
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

	@Override
	public String toString() {
		return "CommodityAd [adId=" + adId + ", imageUrl=" + imageUrl
				+ ", title=" + title + ", discount=" + discount
				+ ", marketPrice=" + marketPrice + ", nakedPrice=" + nakedPrice
				+ ", openCount=" + openCount + ", activeStart=" + activeStart
				+ ", activeEnd=" + activeEnd + ", commodityId=" + commodityId
				+ ", commodityUrl=" + commodityUrl + ", urlTarget=" + urlTarget
				+ ", adState=" + adState + ", createBy=" + createBy
				+ ", createTime=" + createTime + ", updateBy=" + updateBy
				+ ", updateTime=" + updateTime + ", id=" + id + ", locationId="
				+ locationId + "]";
	}
    
}