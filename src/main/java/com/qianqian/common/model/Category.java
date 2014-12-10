package com.qianqian.common.model;

import java.util.Date;

public class Category {
    private Long id;

    private Long parentId;

    private String parentCategoryName;

    private Long rootId;

    private String rootCategoryName;

    private String name;

    private String englishName;

    private String description;

    private String mark;

    private Integer sortValue;

    private Date createTime;

    private Date lastModiftyTime;

    private Long sponsorBrandId;

    private String logoUrl;

    private String moreLink;

    private Long lastModiftyUserId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public String getParentCategoryName() {
        return parentCategoryName;
    }

    public void setParentCategoryName(String parentCategoryName) {
        this.parentCategoryName = parentCategoryName == null ? null : parentCategoryName.trim();
    }

    public Long getRootId() {
        return rootId;
    }

    public void setRootId(Long rootId) {
        this.rootId = rootId;
    }

    public String getRootCategoryName() {
        return rootCategoryName;
    }

    public void setRootCategoryName(String rootCategoryName) {
        this.rootCategoryName = rootCategoryName == null ? null : rootCategoryName.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getEnglisthName() {
        return englishName;
    }

    public void setEnglishName(String englishName) {
        this.englishName = englishName == null ? null : englishName.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark == null ? null : mark.trim();
    }

    public Integer getSortValue() {
        return sortValue;
    }

    public void setSortValue(Integer sortValue) {
        this.sortValue = sortValue;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getLastModiftyTime() {
        return lastModiftyTime;
    }

    public void setLastModiftyTime(Date lastModiftyTime) {
        this.lastModiftyTime = lastModiftyTime;
    }


    public Long getSponsorBrandId() {
		return sponsorBrandId;
	}

	public void setSponsorBrandId(Long sponsorBrandId) {
		this.sponsorBrandId = sponsorBrandId;
	}

	public String getEnglishName() {
		return englishName;
	}

	public String getLogoUrl() {
        return logoUrl;
    }

    public void setLogoUrl(String logoUrl) {
        this.logoUrl = logoUrl == null ? null : logoUrl.trim();
    }

    public String getMoreLink() {
        return moreLink;
    }

    public void setMoreLink(String moreLink) {
        this.moreLink = moreLink == null ? null : moreLink.trim();
    }

    public Long getLastModiftyUserId() {
        return lastModiftyUserId;
    }

    public void setLastModiftyUserId(Long lastModiftyUserId) {
        this.lastModiftyUserId = lastModiftyUserId;
    }

	@Override
	public String toString() {
		return "Category [name=" + name + ", englishName=" + englishName
				+ ", mark=" + mark + ", sortValue=" + sortValue
				+ ", sponsorBrandId=" + sponsorBrandId + ", moreLink="
				+ moreLink + ", lastModiftyUserId=" + lastModiftyUserId + "]";
	}
    
}