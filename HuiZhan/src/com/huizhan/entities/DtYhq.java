package com.huizhan.entities;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.GenericGenerator;

/**
 * DtYhq entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "dt_yhq", catalog = "dati")
public class DtYhq implements java.io.Serializable {

	// Fields

	private String yhqId;
	private String activityId;
	private String yhqName;
	private Date yhqBegintime;
	private Date yhqEndtime;
	private String yhqAddress;
	private String yhqCompany;
	private String yhqPhone;
	private Integer yhqCount;
	private Integer yhqRest;
	private String yhqDesc;

	// Constructors

	/** default constructor */
	public DtYhq() {
	}

	/** minimal constructor */
	public DtYhq(String yhqId) {
		this.yhqId = yhqId;
	}

	/** full constructor */
	public DtYhq(String yhqId, String activityId, String yhqName,
			Date yhqBegintime, Date yhqEndtime, String yhqAddress,
			String yhqCompany, String yhqPhone, Integer yhqCount,
			Integer yhqRest, String yhqDesc) {
		this.yhqId = yhqId;
		this.activityId = activityId;
		this.yhqName = yhqName;
		this.yhqBegintime = yhqBegintime;
		this.yhqEndtime = yhqEndtime;
		this.yhqAddress = yhqAddress;
		this.yhqCompany = yhqCompany;
		this.yhqPhone = yhqPhone;
		this.yhqCount = yhqCount;
		this.yhqRest = yhqRest;
		this.yhqDesc = yhqDesc;
	}

	// Property accessors
	@Id
    @GeneratedValue(generator="system-uuid")
    @GenericGenerator(name="system-uuid",strategy="uuid")
	@Column(name = "yhq_id", unique = true, nullable = false, length = 40)
	public String getYhqId() {
		return this.yhqId;
	}

	public void setYhqId(String yhqId) {
		this.yhqId = yhqId;
	}

	@Column(name = "activity_id", length = 40)
	public String getActivityId() {
		return this.activityId;
	}

	public void setActivityId(String activityId) {
		this.activityId = activityId;
	}

	@Column(name = "yhq_name", length = 100)
	public String getYhqName() {
		return this.yhqName;
	}

	public void setYhqName(String yhqName) {
		this.yhqName = yhqName;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "yhq_begintime", length = 0)
	public Date getYhqBegintime() {
		return this.yhqBegintime;
	}

	public void setYhqBegintime(Date yhqBegintime) {
		this.yhqBegintime = yhqBegintime;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "yhq_endtime", length = 0)
	public Date getYhqEndtime() {
		return this.yhqEndtime;
	}

	public void setYhqEndtime(Date yhqEndtime) {
		this.yhqEndtime = yhqEndtime;
	}

	@Column(name = "yhq_address", length = 100)
	public String getYhqAddress() {
		return this.yhqAddress;
	}

	public void setYhqAddress(String yhqAddress) {
		this.yhqAddress = yhqAddress;
	}

	@Column(name = "yhq_company", length = 100)
	public String getYhqCompany() {
		return this.yhqCompany;
	}

	public void setYhqCompany(String yhqCompany) {
		this.yhqCompany = yhqCompany;
	}

	@Column(name = "yhq_phone", length = 100)
	public String getYhqPhone() {
		return this.yhqPhone;
	}

	public void setYhqPhone(String yhqPhone) {
		this.yhqPhone = yhqPhone;
	}

	@Column(name = "yhq_count")
	public Integer getYhqCount() {
		return this.yhqCount;
	}

	public void setYhqCount(Integer yhqCount) {
		this.yhqCount = yhqCount;
	}

	@Column(name = "yhq_rest")
	public Integer getYhqRest() {
		return this.yhqRest;
	}

	public void setYhqRest(Integer yhqRest) {
		this.yhqRest = yhqRest;
	}

	@Column(name = "yhq_desc", length = 500)
	public String getYhqDesc() {
		return this.yhqDesc;
	}

	public void setYhqDesc(String yhqDesc) {
		this.yhqDesc = yhqDesc;
	}

}