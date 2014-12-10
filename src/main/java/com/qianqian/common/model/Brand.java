package com.qianqian.common.model;

import java.util.Date;

public class Brand {
    private Long id;

    private String name;

    private Date createTime;

    private String logoUrl;

    private Date lastModiftyTime;

    private Long lastModiftyUserId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getLogoUrl() {
        return logoUrl;
    }

    public void setLogoUrl(String logoUrl) {
        this.logoUrl = logoUrl == null ? null : logoUrl.trim();
    }

    public Date getLastModiftyTime() {
        return lastModiftyTime;
    }

    public void setLastModiftyTime(Date lastModiftyTime) {
        this.lastModiftyTime = lastModiftyTime;
    }

    public Long getLastModiftyUserId() {
        return lastModiftyUserId;
    }

    public void setLastModiftyUserId(Long lastModiftyUserId) {
        this.lastModiftyUserId = lastModiftyUserId;
    }
}