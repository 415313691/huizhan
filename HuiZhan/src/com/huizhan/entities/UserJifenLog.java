package com.huizhan.entities;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * UserJifenLog entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "user_jifen_log", catalog = "dati")
public class UserJifenLog implements java.io.Serializable {

	// Fields

	private String jifenId;
	private String activityId;
	private String jifenNum;
	private Timestamp jifenDate;
	private String userId;
	private String productId;
	
	private String activityName;
	private String productName;

	// Constructors

	/** default constructor */
	public UserJifenLog() {
	}

	/** minimal constructor */
	public UserJifenLog(String jifenId) {
		this.jifenId = jifenId;
	}

	/** full constructor */
	public UserJifenLog(String jifenId, String activityId, String jifenNum,
			Timestamp jifenDate, String userId, String productId) {
		this.jifenId = jifenId;
		this.activityId = activityId;
		this.jifenNum = jifenNum;
		this.jifenDate = jifenDate;
		this.userId = userId;
		this.productId = productId;
	}

	// Property accessors
	@Id
	@Column(name = "jifen_id", unique = true, nullable = false, length = 100)
	public String getJifenId() {
		return this.jifenId;
	}

	public void setJifenId(String jifenId) {
		this.jifenId = jifenId;
	}

	@Column(name = "activity_id", length = 100)
	public String getActivityId() {
		return this.activityId;
	}

	public void setActivityId(String activityId) {
		this.activityId = activityId;
	}

	@Column(name = "jifen_num", length = 100)
	public String getJifenNum() {
		return this.jifenNum;
	}

	public void setJifenNum(String jifenNum) {
		this.jifenNum = jifenNum;
	}

	@Column(name = "jifen_date", length = 0)
	public Timestamp getJifenDate() {
		return this.jifenDate;
	}

	public void setJifenDate(Timestamp jifenDate) {
		this.jifenDate = jifenDate;
	}

	@Column(name = "user_id", length = 100)
	public String getUserId() {
		return this.userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	@Column(name = "product_id", length = 100)
	public String getProductId() {
		return this.productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}
	@Transient
	public String getActivityName() {
		return activityName;
	}

	public void setActivityName(String activityName) {
		this.activityName = activityName;
	}
	@Transient
	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}
	
 
	
	

}