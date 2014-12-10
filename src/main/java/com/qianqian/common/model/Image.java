package com.qianqian.common.model;

import java.util.Date;

public class Image {
    private Long imageId;

    private Long spaceId;

    private String imageUrl;

    private String imageName;

    private String imageSize;

    private Integer imageState;

    private Long createBy;

    private Date createTime;

    private Long updateBy;

    private Date updateTime;

    public Long getImageId() {
        return imageId;
    }

    public void setImageId(Long imageId) {
        this.imageId = imageId;
    }

    public Long getSpaceId() {
        return spaceId;
    }

    public void setSpaceId(Long spaceId) {
        this.spaceId = spaceId;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl == null ? null : imageUrl.trim();
    }

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName == null ? null : imageName.trim();
    }

    public String getImageSize() {
        return imageSize;
    }

    public void setImageSize(String imageSize) {
        this.imageSize = imageSize == null ? null : imageSize.trim();
    }

    public Integer getImageState() {
        return imageState;
    }

    public void setImageState(Integer imageState) {
        this.imageState = imageState;
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

	@Override
	public String toString() {
		return "Image [imageId=" + imageId + ", spaceId=" + spaceId
				+ ", imageUrl=" + imageUrl + ", imageName=" + imageName
				+ ", imageSize=" + imageSize + ", imageState=" + imageState
				+ ", createBy=" + createBy + ", createTime=" + createTime
				+ ", updateBy=" + updateBy + ", updateTime=" + updateTime + "]";
	}

	public Image() {
		super();
	}

	public Image(String imageUrl, String imageName, String imageSize) {
		super();
		this.imageUrl = imageUrl;
		this.imageName = imageName;
		this.imageSize = imageSize;
	}

	public Image(String imageUrl, String imageName, String imageSize,
			Long createBy, Long updateBy) {
		super();
		this.imageUrl = imageUrl;
		this.imageName = imageName;
		this.imageSize = imageSize;
		this.createBy = createBy;
		this.updateBy = updateBy;
	}
	
    
}