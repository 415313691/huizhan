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
 * DtAd entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "dt_ad", catalog = "dati")
public class DtAd implements java.io.Serializable {

	// Fields

	private String adId;
	private String adPic;
	private String adIsdel;
	private String adLocation;
	private Date adBegindate;
	private Date adEnddate;

	// Constructors

	/** default constructor */
	public DtAd() {
	}

	/** minimal constructor */
	public DtAd(String adId) {
		this.adId = adId;
	}

	/** full constructor */
	public DtAd(String adId, String adPic, String adIsdel, String adLocation,
			Date adBegindate, Date adEnddate) {
		this.adId = adId;
		this.adPic = adPic;
		this.adIsdel = adIsdel;
		this.adLocation = adLocation;
		this.adBegindate = adBegindate;
		this.adEnddate = adEnddate;
	}

	// Property accessors
	@Id
    @GeneratedValue(generator="system-uuid")
    @GenericGenerator(name="system-uuid",strategy="uuid")
	@Column(name = "ad_id", unique = true, nullable = false, length = 40)
	public String getAdId() {
		return this.adId;
	}

	public void setAdId(String adId) {
		this.adId = adId;
	}

	@Column(name = "ad_pic", length = 100)
	public String getAdPic() {
		return this.adPic;
	}

	public void setAdPic(String adPic) {
		this.adPic = adPic;
	}

	@Column(name = "ad_isdel", length = 1)
	public String getAdIsdel() {
		return this.adIsdel;
	}

	public void setAdIsdel(String adIsdel) {
		this.adIsdel = adIsdel;
	}

	@Column(name = "ad_location", length = 1)
	public String getAdLocation() {
		return this.adLocation;
	}

	public void setAdLocation(String adLocation) {
		this.adLocation = adLocation;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "ad_begindate", length = 0)
	public Date getAdBegindate() {
		return this.adBegindate;
	}

	public void setAdBegindate(Date adBegindate) {
		this.adBegindate = adBegindate;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "ad_enddate", length = 0)
	public Date getAdEnddate() {
		return this.adEnddate;
	}

	public void setAdEnddate(Date adEnddate) {
		this.adEnddate = adEnddate;
	}

}