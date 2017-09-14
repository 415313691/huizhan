package com.huizhan.entities;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

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
			Timestamp puDate) {
		this.puId = puId;
		this.productId = productId;
		this.userId = userId;
		this.puDate = puDate;
	}

	// Property accessors
	@Id
    @GeneratedValue(generator="system-uuid")
    @GenericGenerator(name="system-uuid",strategy="uuid")
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

}