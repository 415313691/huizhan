package com.huizhan.entities;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**
 * DtUser entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "dt_user", catalog = "dati")
public class DtUser implements java.io.Serializable {

	// Fields

	private String userId;
	private String userName;
	private String userPhone;
	private Timestamp userAddtime;
	private String openid;
	private String pic;
	private String userType;
	private String userPass;

	// Constructors

	/** default constructor */
	public DtUser() {
	}

	/** minimal constructor */
	public DtUser(String userId) {
		this.userId = userId;
	}

	/** full constructor */
	public DtUser(String userId, String userName, String userPhone,
			Timestamp userAddtime, String openid, String pic, String userType,
			String userPass) {
		this.userId = userId;
		this.userName = userName;
		this.userPhone = userPhone;
		this.userAddtime = userAddtime;
		this.openid = openid;
		this.pic = pic;
		this.userType = userType;
		this.userPass = userPass;
	}

	// Property accessors
	@Id
    @GeneratedValue(generator="system-uuid")
    @GenericGenerator(name="system-uuid",strategy="uuid")
	@Column(name = "user_id", unique = true, nullable = false, length = 40)
	public String getUserId() {
		return this.userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	@Column(name = "user_name", length = 100)
	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	@Column(name = "user_phone", length = 20)
	public String getUserPhone() {
		return this.userPhone;
	}

	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}

	@Column(name = "user_addtime", length = 0)
	public Timestamp getUserAddtime() {
		return this.userAddtime;
	}

	public void setUserAddtime(Timestamp userAddtime) {
		this.userAddtime = userAddtime;
	}

	@Column(name = "openid", length = 100)
	public String getOpenid() {
		return this.openid;
	}

	public void setOpenid(String openid) {
		this.openid = openid;
	}

	@Column(name = "pic", length = 200)
	public String getPic() {
		return this.pic;
	}

	public void setPic(String pic) {
		this.pic = pic;
	}

	@Column(name = "user_type", length = 1)
	public String getUserType() {
		return this.userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	@Column(name = "user_pass", length = 50)
	public String getUserPass() {
		return this.userPass;
	}

	public void setUserPass(String userPass) {
		this.userPass = userPass;
	}

}