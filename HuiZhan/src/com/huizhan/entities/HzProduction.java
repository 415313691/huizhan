package com.huizhan.entities;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**
 * HzProduction entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "hz_production", catalog = "dati")
public class HzProduction implements java.io.Serializable {

	// Fields

	private String productId;
	private String productName;
	private String productPic;
	private String productDesc;
	private Integer productCount;
	private Integer productPrice;
	private Timestamp productAddtime;
	private String productStatus;

	// Constructors

	/** default constructor */
	public HzProduction() {
	}

	/** minimal constructor */
	public HzProduction(String productId) {
		this.productId = productId;
	}

	/** full constructor */
	public HzProduction(String productId, String productName,
			String productPic, String productDesc, Integer productCount,
			Integer productPrice, Timestamp productAddtime, String productStatus) {
		this.productId = productId;
		this.productName = productName;
		this.productPic = productPic;
		this.productDesc = productDesc;
		this.productCount = productCount;
		this.productPrice = productPrice;
		this.productAddtime = productAddtime;
		this.productStatus = productStatus;
	}

	// Property accessors
	@Id
    @GeneratedValue(generator="system-uuid")
    @GenericGenerator(name="system-uuid",strategy="uuid")
	@Column(name = "product_id", unique = true, nullable = false, length = 100)
	public String getProductId() {
		return this.productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	@Column(name = "product_name", length = 100)
	public String getProductName() {
		return this.productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	@Column(name = "product_pic", length = 200)
	public String getProductPic() {
		return this.productPic;
	}

	public void setProductPic(String productPic) {
		this.productPic = productPic;
	}

	@Column(name = "product_desc", length = 1000)
	public String getProductDesc() {
		return this.productDesc;
	}

	public void setProductDesc(String productDesc) {
		this.productDesc = productDesc;
	}

	@Column(name = "product_count")
	public Integer getProductCount() {
		return this.productCount;
	}

	public void setProductCount(Integer productCount) {
		this.productCount = productCount;
	}

	@Column(name = "product_price")
	public Integer getProductPrice() {
		return this.productPrice;
	}

	public void setProductPrice(Integer productPrice) {
		this.productPrice = productPrice;
	}

	@Column(name = "product_addtime", length = 0)
	public Timestamp getProductAddtime() {
		return this.productAddtime;
	}

	public void setProductAddtime(Timestamp productAddtime) {
		this.productAddtime = productAddtime;
	}

	@Column(name = "product_status", length = 1)
	public String getProductStatus() {
		return this.productStatus;
	}

	public void setProductStatus(String productStatus) {
		this.productStatus = productStatus;
	}

}