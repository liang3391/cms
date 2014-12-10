package com.qianqian.common.model;

import java.util.Date;

public class Space {
    private Long spaceId;

    private Long parentId;

    private String spaceName;

    private Integer spaceState;

    private Long createBy;

    private Date createTime;

    private Long updateBy;

    private Date updateTime;

    public Long getSpaceId() {
        return spaceId;
    }

    public void setSpaceId(Long spaceId) {
        this.spaceId = spaceId;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public String getSpaceName() {
        return spaceName;
    }

    public void setSpaceName(String spaceName) {
        this.spaceName = spaceName == null ? null : spaceName.trim();
    }

    public Integer getSpaceState() {
        return spaceState;
    }

    public void setSpaceState(Integer spaceState) {
        this.spaceState = spaceState;
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
}