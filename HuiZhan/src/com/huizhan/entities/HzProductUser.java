package com.huizhan.entities;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * HzProductUser entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "hz_product_user", catalog = "dati")
public class HzProductUser implements java.io.Serializable {

	// Fields

	private String puId;
	private String productId;
	private String userId;
	private Timestamp puDate;
	private Integer delJifen;
	private String puPass;
	private String puStatus;
	
	private String productName;
	private String userName;
	private String userPhone;

	// Constructors

	/** default constructor */
	public HzProductUser() {
	}

	/** minimal constructor */
	public HzProductUser(String puId) {
		this.puId = puId;
	}

	/** full constructor */
	public HzProductUser(String puId, String productId, String userId,
			Timestamp puDate, Integer delJifen, String puPass, String puStatus) {
		this.puId = puId;
		this.productId = productId;
		this.userId = userId;
		this.puDate = puDate;
		this.delJifen = delJifen;
		this.puPass = puPass;
		this.puStatus = puStatus;
	}

	// Property accessors
	@Id
	@Column(name = "pu_id", unique = true, nullable = false, length = 100)
	public String getPuId() {
		return this.puId;
	}

	public void setPuId(String puId) {
		this.puId = puId;
	}

	@Column(name = "product_id", length = 100)
	public String getProductId() {
		return this.productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	@Column(name = "user_id", length = 100)
	public String getUserId() {
		return this.userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	@Column(name = "pu_date", length = 0)
	public Timestamp getPuDate() {
		return this.puDate;
	}

	public void setPuDate(Timestamp puDate) {
		this.puDate = puDate;
	}

	@Column(name = "del_jifen")
	public Integer getDelJifen() {
		return this.delJifen;
	}

	public void setDelJifen(Integer delJifen) {
		this.delJifen = delJifen;
	}

	@Column(name = "pu_pass", length = 100)
	public String getPuPass() {
		return this.puPass;
	}

	public void setPuPass(String puPass) {
		this.puPass = puPass;
	}

	@Column(name = "pu_status", length = 1)
	public String getPuStatus() {
		return this.puStatus;
	}

	public void setPuStatus(String puStatus) {
		this.puStatus = puStatus;
	}
	@Transient
	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}
	@Transient
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
	@Transient
	public String getUserPhone() {
		return userPhone;
	}

	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}
	
	
	

}