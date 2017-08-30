package com.huizhan.entities;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**
 * TDictArea entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "t_dict_area", catalog = "huatuo")
public class TDictArea implements java.io.Serializable {

	// Fields

	private String areaId;
	private String areaCode;
	private String areaName;
	private Double levelNum;
	private String areaParentCode;
	private String isValid;
	private String areaEnName;
	private Timestamp areaUpdateTime;
	private String displayFlag;

	// Constructors

	/** default constructor */
	public TDictArea() {
	}

	/** minimal constructor */
	public TDictArea(String areaId) {
		this.areaId = areaId;
	}

	/** full constructor */
	public TDictArea(String areaId, String areaCode, String areaName,
			Double levelNum, String areaParentCode, String isValid,
			String areaEnName, Timestamp areaUpdateTime, String displayFlag) {
		this.areaId = areaId;
		this.areaCode = areaCode;
		this.areaName = areaName;
		this.levelNum = levelNum;
		this.areaParentCode = areaParentCode;
		this.isValid = isValid;
		this.areaEnName = areaEnName;
		this.areaUpdateTime = areaUpdateTime;
		this.displayFlag = displayFlag;
	}

	// Property accessors
	@Id
    @GeneratedValue(generator="system-uuid")
    @GenericGenerator(name="system-uuid",strategy="uuid")
	@Column(name = "AREA_ID", unique = true, nullable = false, length = 40)
	public String getAreaId() {
		return this.areaId;
	}

	public void setAreaId(String areaId) {
		this.areaId = areaId;
	}

	@Column(name = "AREA_CODE", length = 30)
	public String getAreaCode() {
		return this.areaCode;
	}

	public void setAreaCode(String areaCode) {
		this.areaCode = areaCode;
	}

	@Column(name = "AREA_NAME", length = 100)
	public String getAreaName() {
		return this.areaName;
	}

	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}

	@Column(name = "LEVEL_NUM", precision = 10)
	public Double getLevelNum() {
		return this.levelNum;
	}

	public void setLevelNum(Double levelNum) {
		this.levelNum = levelNum;
	}

	@Column(name = "AREA_PARENT_CODE", length = 30)
	public String getAreaParentCode() {
		return this.areaParentCode;
	}

	public void setAreaParentCode(String areaParentCode) {
		this.areaParentCode = areaParentCode;
	}

	@Column(name = "IS_VALID", length = 1)
	public String getIsValid() {
		return this.isValid;
	}

	public void setIsValid(String isValid) {
		this.isValid = isValid;
	}

	@Column(name = "AREA_EN_NAME", length = 100)
	public String getAreaEnName() {
		return this.areaEnName;
	}

	public void setAreaEnName(String areaEnName) {
		this.areaEnName = areaEnName;
	}

	@Column(name = "AREA_UPDATE_TIME", length = 0)
	public Timestamp getAreaUpdateTime() {
		return this.areaUpdateTime;
	}

	public void setAreaUpdateTime(Timestamp areaUpdateTime) {
		this.areaUpdateTime = areaUpdateTime;
	}

	@Column(name = "DISPLAY_FLAG", length = 1)
	public String getDisplayFlag() {
		return this.displayFlag;
	}

	public void setDisplayFlag(String displayFlag) {
		this.displayFlag = displayFlag;
	}

}