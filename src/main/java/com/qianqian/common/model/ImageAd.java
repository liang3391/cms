package com.qianqian.common.model;

import java.util.Date;

public class ImageAd {
    private Long adId;
    private Long id;
    private String imageUrl;

    private String accessUrl;

    private String urlTarget="_blank";

    private Integer loopTime;
    private String note;
    
    public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	private String boardName;

    private Integer adState =1;

    private Long createBy;

    private Date createTime;

    private Long updateBy;

    private Date updateTime = new Date();
    
    private Date startTime;
    
    private Date endTime;
    
    private long locationId;

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

    public String getAccessUrl() {
        return accessUrl;
    }

    public void setAccessUrl(String accessUrl) {
        this.accessUrl = accessUrl == null ? null : accessUrl.trim();
    }

    public String getUrlTarget() {
        return urlTarget;
    }

    public void setUrlTarget(String urlTarget) {
        this.urlTarget = urlTarget == null ? null : urlTarget.trim();
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
        this.boardName = boardName == null ? null : boardName.trim();
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

	public long getLocationId() {
		return locationId;
	}

	public void setLocationId(long locationId) {
		this.locationId = locationId;
	}

	public ImageAd(String locationId,String imageUrl, String accessUrl, String urlTarget,
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

	public ImageAd() {
		super();
	}

	@Override
	public String toString() {
		return "ImageAd [adId=" + adId + ", imageUrl=" + imageUrl
				+ ", accessUrl=" + accessUrl + ", urlTarget=" + urlTarget
				+ ", loopTime=" + loopTime + ", boardName=" + boardName
				+ ", adState=" + adState + ", createBy=" + createBy
				+ ", createTime=" + createTime + ", updateBy=" + updateBy
				+ ", updateTime=" + updateTime + ", startTime=" + startTime
				+ ", endTime=" + endTime + ", locationId=" + locationId + "]";
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
    
}