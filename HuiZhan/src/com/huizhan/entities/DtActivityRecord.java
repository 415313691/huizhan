package com.huizhan.entities;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**
 * DtActivityRecord entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "dt_activity_record", catalog = "dati")
public class DtActivityRecord implements java.io.Serializable {

	// Fields

	private String arecordId;
	private String activityId;
	private String userId;
	private Timestamp arecordTime;
	private String arecordClassid;
	private Double arecordAccuracy;

	// Constructors

	/** default constructor */
	public DtActivityRecord() {
	}

	/** minimal constructor */
	public DtActivityRecord(String arecordId) {
		this.arecordId = arecordId;
	}

	/** full constructor */
	public DtActivityRecord(String arecordId, String activityId, String userId,
			Timestamp arecordTime, String arecordClassid, Double arecordAccuracy) {
		this.arecordId = arecordId;
		this.activityId = activityId;
		this.userId = userId;
		this.arecordTime = arecordTime;
		this.arecordClassid = arecordClassid;
		this.arecordAccuracy = arecordAccuracy;
	}

	// Property accessors
	@Id
    @GeneratedValue(generator="system-uuid")
    @GenericGenerator(name="system-uuid",strategy="uuid")
	@Column(name = "arecord_id", unique = true, nullable = false, length = 40)
	public String getArecordId() {
		return this.arecordId;
	}

	public void setArecordId(String arecordId) {
		this.arecordId = arecordId;
	}

	@Column(name = "activity_id", length = 40)
	public String getActivityId() {
		return this.activityId;
	}

	public void setActivityId(String activityId) {
		this.activityId = activityId;
	}

	@Column(name = "user_id", length = 40)
	public String getUserId() {
		return this.userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	@Column(name = "arecord_time", length = 0)
	public Timestamp getArecordTime() {
		return this.arecordTime;
	}

	public void setArecordTime(Timestamp arecordTime) {
		this.arecordTime = arecordTime;
	}

	@Column(name = "arecord_classid", length = 40)
	public String getArecordClassid() {
		return this.arecordClassid;
	}

	public void setArecordClassid(String arecordClassid) {
		this.arecordClassid = arecordClassid;
	}

	@Column(name = "arecord_accuracy", precision = 22, scale = 0)
	public Double getArecordAccuracy() {
		return this.arecordAccuracy;
	}

	public void setArecordAccuracy(Double arecordAccuracy) {
		this.arecordAccuracy = arecordAccuracy;
	}

}