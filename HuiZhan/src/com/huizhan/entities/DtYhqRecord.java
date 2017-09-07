package com.huizhan.entities;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.GenericGenerator;

/**
 * DtYhqRecord entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "dt_yhq_record", catalog = "dati")
public class DtYhqRecord implements java.io.Serializable {

	// Fields

	private String yhqRecordId;
	private String arecordId;
	private String userId;
	private String yhqId;
	private Timestamp yhqDatetime;
	private String yhqPassword;
	private String yhqIswriteoff;
	private Timestamp yhqWriteoffdate;

	private String activityName;
	private String beginTime;
	private String endTime;
	private String yhqName;
	// Constructors

	/** default constructor */
	public DtYhqRecord() {
	}

	/** minimal constructor */
	public DtYhqRecord(String yhqRecordId) {
		this.yhqRecordId = yhqRecordId;
	}

	/** full constructor */
	public DtYhqRecord(String yhqRecordId, String arecordId, String userId,
			String yhqId, Timestamp yhqDatetime, String yhqPassword,
			String yhqIswriteoff, Timestamp yhqWriteoffdate) {
		this.yhqRecordId = yhqRecordId;
		this.arecordId = arecordId;
		this.userId = userId;
		this.yhqId = yhqId;
		this.yhqDatetime = yhqDatetime;
		this.yhqPassword = yhqPassword;
		this.yhqIswriteoff = yhqIswriteoff;
		this.yhqWriteoffdate = yhqWriteoffdate;
	}

	// Property accessors
	@Id
    @GeneratedValue(generator="system-uuid")
    @GenericGenerator(name="system-uuid",strategy="uuid")
	@Column(name = "yhq_record_id", unique = true, nullable = false, length = 40)
	public String getYhqRecordId() {
		return this.yhqRecordId;
	}

	public void setYhqRecordId(String yhqRecordId) {
		this.yhqRecordId = yhqRecordId;
	}

	@Column(name = "arecord_id", length = 40)
	public String getArecordId() {
		return this.arecordId;
	}

	public void setArecordId(String arecordId) {
		this.arecordId = arecordId;
	}

	@Column(name = "user_id", length = 40)
	public String getUserId() {
		return this.userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	@Column(name = "yhq_id", length = 40)
	public String getYhqId() {
		return this.yhqId;
	}

	public void setYhqId(String yhqId) {
		this.yhqId = yhqId;
	}

	@Column(name = "yhq_datetime", length = 0)
	public Timestamp getYhqDatetime() {
		return this.yhqDatetime;
	}

	public void setYhqDatetime(Timestamp yhqDatetime) {
		this.yhqDatetime = yhqDatetime;
	}

	@Column(name = "yhq_password", length = 40)
	public String getYhqPassword() {
		return this.yhqPassword;
	}

	public void setYhqPassword(String yhqPassword) {
		this.yhqPassword = yhqPassword;
	}

	@Column(name = "yhq_iswriteoff", length = 1)
	public String getYhqIswriteoff() {
		return this.yhqIswriteoff;
	}

	public void setYhqIswriteoff(String yhqIswriteoff) {
		this.yhqIswriteoff = yhqIswriteoff;
	}

	@Column(name = "yhq_writeoffdate", length = 0)
	public Timestamp getYhqWriteoffdate() {
		return this.yhqWriteoffdate;
	}

	public void setYhqWriteoffdate(Timestamp yhqWriteoffdate) {
		this.yhqWriteoffdate = yhqWriteoffdate;
	}
	@Transient
	public String getActivityName() {
		return activityName;
	}

	public void setActivityName(String activityName) {
		this.activityName = activityName;
	}
	@Transient
	public String getBeginTime() {
		return beginTime;
	}

	public void setBeginTime(String beginTime) {
		this.beginTime = beginTime;
	}
	@Transient
	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	@Transient
	public String getYhqName() {
		return yhqName;
	}

	public void setYhqName(String yhqName) {
		this.yhqName = yhqName;
	}
	
	
	

}