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
 * DtRewardDetail entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "dt_reward_detail", catalog = "dati")
public class DtRewardDetail implements java.io.Serializable {

	// Fields

	private String rewardId;
	private String arecordId;
	private String rewardTypeid;
	private Double rewardMoney;
	private Timestamp rewardTime;
	private String userId;
	private String rewardState;

	private String activityName;
	// Constructors

	/** default constructor */
	public DtRewardDetail() {
	}

	/** minimal constructor */
	public DtRewardDetail(String rewardId) {
		this.rewardId = rewardId;
	}

	/** full constructor */
	public DtRewardDetail(String rewardId, String arecordId,
			String rewardTypeid, Double rewardMoney, Timestamp rewardTime,
			String userId, String rewardState) {
		this.rewardId = rewardId;
		this.arecordId = arecordId;
		this.rewardTypeid = rewardTypeid;
		this.rewardMoney = rewardMoney;
		this.rewardTime = rewardTime;
		this.userId = userId;
		this.rewardState = rewardState;
	}

	// Property accessors
	@Id
    @GeneratedValue(generator="system-uuid")
    @GenericGenerator(name="system-uuid",strategy="uuid")
	@Column(name = "reward_id", unique = true, nullable = false, length = 40)
	public String getRewardId() {
		return this.rewardId;
	}

	public void setRewardId(String rewardId) {
		this.rewardId = rewardId;
	}

	@Column(name = "arecord_id", length = 40)
	public String getArecordId() {
		return this.arecordId;
	}

	public void setArecordId(String arecordId) {
		this.arecordId = arecordId;
	}

	@Column(name = "reward_typeid", length = 40)
	public String getRewardTypeid() {
		return this.rewardTypeid;
	}

	public void setRewardTypeid(String rewardTypeid) {
		this.rewardTypeid = rewardTypeid;
	}

	@Column(name = "reward_money", precision = 22, scale = 0)
	public Double getRewardMoney() {
		return this.rewardMoney;
	}

	public void setRewardMoney(Double rewardMoney) {
		this.rewardMoney = rewardMoney;
	}

	@Column(name = "reward_time", length = 0)
	public Timestamp getRewardTime() {
		return this.rewardTime;
	}

	public void setRewardTime(Timestamp rewardTime) {
		this.rewardTime = rewardTime;
	}

	@Column(name = "user_id", length = 100)
	public String getUserId() {
		return this.userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	@Column(name = "reward_state", length = 100)
	public String getRewardState() {
		return this.rewardState;
	}

	public void setRewardState(String rewardState) {
		this.rewardState = rewardState;
	}
	@Transient
	public String getActivityName() {
		return activityName;
	}

	public void setActivityName(String activityName) {
		this.activityName = activityName;
	}
	
	

}