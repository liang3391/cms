/**
 * 
 */
package com.qianqian.brand.model;

import java.io.Serializable;
import java.util.Date;

/**
 * @author YangWan
 * 
 */
public class PrdBrand implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// 品牌ID
	private Long id;
	// 品牌中文名称
	private String name;
	// 品牌英文名称
	private String englishName;
	// 品牌大图
	private String logoUrl;
	// 品牌小图
	private String smallLogo;
	// 品牌海报图片URL
	private String posterImage;
	// 品牌介绍
	private String introduction;
	// 品牌入驻时间
	private Date inTime;
	// 保证金
	private Number cautionMoney;
	// 合作服务有效期-开始时间
	private Date cooperateStartDate;
	// 合作服务有效期-结束时间
	private Date cooperateEndDate;
	// 品牌授权-开始时间
	private Date brandAuthStartDate;
	// 品牌授权-结束时间
	private Date brandAuthEndDate;
	// 品牌授权-图片
	private String brandAuthImage;
	// 代理授权-开始时间
	private Date agentAuthStartDate;
	// 代理授权-结束时间
	private Date agentAuthEndDate;
	// 代理授权-图片
	private String agentAuthImage;
	// 创建人
	private String creator;
	// 创建时间
	private Date createTime;
	// 修改人
	private String modifier;
	// 修改时间
	private Date modifyDate;
	// 版本号
	private Integer version;
	//英文名称以某字母开始
	private String startLetter;
	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the englishName
	 */
	public String getEnglishName() {
		return englishName;
	}
	/**
	 * @param englishName the englishName to set
	 */
	public void setEnglishName(String englishName) {
		this.englishName = englishName;
	}
	/**
	 * @return the logoUrl
	 */
	public String getLogoUrl() {
		return logoUrl;
	}
	/**
	 * @param logoUrl the logoUrl to set
	 */
	public void setLogoUrl(String logoUrl) {
		this.logoUrl = logoUrl;
	}
	/**
	 * @return the smallLogo
	 */
	public String getSmallLogo() {
		return smallLogo;
	}
	/**
	 * @param smallLogo the smallLogo to set
	 */
	public void setSmallLogo(String smallLogo) {
		this.smallLogo = smallLogo;
	}
	/**
	 * @return the posterImage
	 */
	public String getPosterImage() {
		return posterImage;
	}
	/**
	 * @param posterImage the posterImage to set
	 */
	public void setPosterImage(String posterImage) {
		this.posterImage = posterImage;
	}
	/**
	 * @return the introduction
	 */
	public String getIntroduction() {
		return introduction;
	}
	/**
	 * @param introduction the introduction to set
	 */
	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}
	/**
	 * @return the inTime
	 */
	public Date getInTime() {
		return inTime;
	}
	/**
	 * @param inTime the inTime to set
	 */
	public void setInTime(Date inTime) {
		this.inTime = inTime;
	}
	/**
	 * @return the cautionMoney
	 */
	public Number getCautionMoney() {
		return cautionMoney;
	}
	/**
	 * @param cautionMoney the cautionMoney to set
	 */
	public void setCautionMoney(Number cautionMoney) {
		this.cautionMoney = cautionMoney;
	}
	/**
	 * @return the cooperateStartDate
	 */
	public Date getCooperateStartDate() {
		return cooperateStartDate;
	}
	/**
	 * @param cooperateStartDate the cooperateStartDate to set
	 */
	public void setCooperateStartDate(Date cooperateStartDate) {
		this.cooperateStartDate = cooperateStartDate;
	}
	/**
	 * @return the cooperateEndDate
	 */
	public Date getCooperateEndDate() {
		return cooperateEndDate;
	}
	/**
	 * @param cooperateEndDate the cooperateEndDate to set
	 */
	public void setCooperateEndDate(Date cooperateEndDate) {
		this.cooperateEndDate = cooperateEndDate;
	}
	/**
	 * @return the brandAuthStartDate
	 */
	public Date getBrandAuthStartDate() {
		return brandAuthStartDate;
	}
	/**
	 * @param brandAuthStartDate the brandAuthStartDate to set
	 */
	public void setBrandAuthStartDate(Date brandAuthStartDate) {
		this.brandAuthStartDate = brandAuthStartDate;
	}
	/**
	 * @return the brandAuthEndDate
	 */
	public Date getBrandAuthEndDate() {
		return brandAuthEndDate;
	}
	/**
	 * @param brandAuthEndDate the brandAuthEndDate to set
	 */
	public void setBrandAuthEndDate(Date brandAuthEndDate) {
		this.brandAuthEndDate = brandAuthEndDate;
	}
	/**
	 * @return the brandAuthImage
	 */
	public String getBrandAuthImage() {
		return brandAuthImage;
	}
	/**
	 * @param brandAuthImage the brandAuthImage to set
	 */
	public void setBrandAuthImage(String brandAuthImage) {
		this.brandAuthImage = brandAuthImage;
	}
	/**
	 * @return the agentAuthStartDate
	 */
	public Date getAgentAuthStartDate() {
		return agentAuthStartDate;
	}
	/**
	 * @param agentAuthStartDate the agentAuthStartDate to set
	 */
	public void setAgentAuthStartDate(Date agentAuthStartDate) {
		this.agentAuthStartDate = agentAuthStartDate;
	}
	/**
	 * @return the agentAuthEndDate
	 */
	public Date getAgentAuthEndDate() {
		return agentAuthEndDate;
	}
	/**
	 * @param agentAuthEndDate the agentAuthEndDate to set
	 */
	public void setAgentAuthEndDate(Date agentAuthEndDate) {
		this.agentAuthEndDate = agentAuthEndDate;
	}
	/**
	 * @return the agentAuthImage
	 */
	public String getAgentAuthImage() {
		return agentAuthImage;
	}
	/**
	 * @param agentAuthImage the agentAuthImage to set
	 */
	public void setAgentAuthImage(String agentAuthImage) {
		this.agentAuthImage = agentAuthImage;
	}
	/**
	 * @return the creator
	 */
	public String getCreator() {
		return creator;
	}
	/**
	 * @param creator the creator to set
	 */
	public void setCreator(String creator) {
		this.creator = creator;
	}
	/**
	 * @return the createTime
	 */
	public Date getCreateTime() {
		return createTime;
	}
	/**
	 * @param createTime the createTime to set
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	/**
	 * @return the modifier
	 */
	public String getModifier() {
		return modifier;
	}
	/**
	 * @param modifier the modifier to set
	 */
	public void setModifier(String modifier) {
		this.modifier = modifier;
	}
	/**
	 * @return the modifyDate
	 */
	public Date getModifyDate() {
		return modifyDate;
	}
	/**
	 * @param modifyDate the modifyDate to set
	 */
	public void setModifyDate(Date modifyDate) {
		this.modifyDate = modifyDate;
	}
	/**
	 * @return the version
	 */
	public Integer getVersion() {
		return version;
	}
	/**
	 * @param version the version to set
	 */
	public void setVersion(Integer version) {
		this.version = version;
	}
	/**
	 * @return the startLetter
	 */
	public String getStartLetter() {
		return startLetter;
	}
	/**
	 * @param startLetter the startLetter to set
	 */
	public void setStartLetter(String startLetter) {
		this.startLetter = startLetter;
	}
	
}
