package com.huizhan.entities;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**
 * DtActivity entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "dt_activity", catalog = "dati")
public class DtActivity implements java.io.Serializable {

	// Fields

	private String activityId;
	private String activityName;
	private Integer activityQuestionCount;
	private Integer activityCounttime;
	private Double activityMoney;
	private Integer activityRewardCount;
	private Integer activityRestcount;
	private Double activityRestmoney;
	private Timestamp activityBegintime;
	private Timestamp activityEndtime;
	private String activityIsdel;
	private String activityCompany;
	private String activityPic;
	private String activityClass;
	private String activityIstype;
	private String activityPics;
	private Set<DtYhq> dtYhqs = new HashSet<DtYhq>(0);

	// Constructors

	/** default constructor */
	public DtActivity() {
	}

	/** minimal constructor */
	public DtActivity(String activityId) {
		this.activityId = activityId;
	}

	/** full constructor */
	public DtActivity(String activityId, String activityName,
			Integer activityQuestionCount, Integer activityCounttime,
			Double activityMoney, Integer activityRewardCount,
			Integer activityRestcount, Double activityRestmoney,
			Timestamp activityBegintime, Timestamp activityEndtime,
			String activityIsdel, String activityCompany, String activityPic,
			String activityClass, String activityIstype, String activityPics,
			Set<DtYhq> dtYhqs) {
		this.activityId = activityId;
		this.activityName = activityName;
		this.activityQuestionCount = activityQuestionCount;
		this.activityCounttime = activityCounttime;
		this.activityMoney = activityMoney;
		this.activityRewardCount = activityRewardCount;
		this.activityRestcount = activityRestcount;
		this.activityRestmoney = activityRestmoney;
		this.activityBegintime = activityBegintime;
		this.activityEndtime = activityEndtime;
		this.activityIsdel = activityIsdel;
		this.activityCompany = activityCompany;
		this.activityPic = activityPic;
		this.activityClass = activityClass;
		this.activityIstype = activityIstype;
		this.activityPics = activityPics;
		this.dtYhqs = dtYhqs;
	}

	// Property accessors
	@Id
    @GeneratedValue(generator="system-uuid")
    @GenericGenerator(name="system-uuid",strategy="uuid")
	@Column(name = "activity_id", unique = true, nullable = false, length = 40)
	public String getActivityId() {
		return this.activityId;
	}

	public void setActivityId(String activityId) {
		this.activityId = activityId;
	}

	@Column(name = "activity_name", length = 100)
	public String getActivityName() {
		return this.activityName;
	}

	public void setActivityName(String activityName) {
		this.activityName = activityName;
	}

	@Column(name = "activity_question_count")
	public Integer getActivityQuestionCount() {
		return this.activityQuestionCount;
	}

	public void setActivityQuestionCount(Integer activityQuestionCount) {
		this.activityQuestionCount = activityQuestionCount;
	}

	@Column(name = "activity_counttime")
	public Integer getActivityCounttime() {
		return this.activityCounttime;
	}

	public void setActivityCounttime(Integer activityCounttime) {
		this.activityCounttime = activityCounttime;
	}

	@Column(name = "activity_money", precision = 22, scale = 0)
	public Double getActivityMoney() {
		return this.activityMoney;
	}

	public void setActivityMoney(Double activityMoney) {
		this.activityMoney = activityMoney;
	}

	@Column(name = "activity_reward_count")
	public Integer getActivityRewardCount() {
		return this.activityRewardCount;
	}

	public void setActivityRewardCount(Integer activityRewardCount) {
		this.activityRewardCount = activityRewardCount;
	}

	@Column(name = "activity_restcount")
	public Integer getActivityRestcount() {
		return this.activityRestcount;
	}

	public void setActivityRestcount(Integer activityRestcount) {
		this.activityRestcount = activityRestcount;
	}

	@Column(name = "activity_restmoney", precision = 22, scale = 0)
	public Double getActivityRestmoney() {
		return this.activityRestmoney;
	}

	public void setActivityRestmoney(Double activityRestmoney) {
		this.activityRestmoney = activityRestmoney;
	}

	@Column(name = "activity_begintime", length = 0)
	public Timestamp getActivityBegintime() {
		return this.activityBegintime;
	}

	public void setActivityBegintime(Timestamp activityBegintime) {
		this.activityBegintime = activityBegintime;
	}

	@Column(name = "activity_endtime", length = 0)
	public Timestamp getActivityEndtime() {
		return this.activityEndtime;
	}

	public void setActivityEndtime(Timestamp activityEndtime) {
		this.activityEndtime = activityEndtime;
	}

	@Column(name = "activity_isdel", length = 1)
	public String getActivityIsdel() {
		return this.activityIsdel;
	}

	public void setActivityIsdel(String activityIsdel) {
		this.activityIsdel = activityIsdel;
	}

	@Column(name = "activity_company", length = 100)
	public String getActivityCompany() {
		return this.activityCompany;
	}

	public void setActivityCompany(String activityCompany) {
		this.activityCompany = activityCompany;
	}

	@Column(name = "activity_pic", length = 100)
	public String getActivityPic() {
		return this.activityPic;
	}

	public void setActivityPic(String activityPic) {
		this.activityPic = activityPic;
	}

	@Column(name = "activity_class", length = 100)
	public String getActivityClass() {
		return this.activityClass;
	}

	public void setActivityClass(String activityClass) {
		this.activityClass = activityClass;
	}

	@Column(name = "activity_istype", length = 1)
	public String getActivityIstype() {
		return this.activityIstype;
	}

	public void setActivityIstype(String activityIstype) {
		this.activityIstype = activityIstype;
	}

	@Column(name = "activity_pics", length = 2000)
	public String getActivityPics() {
		return this.activityPics;
	}

	public void setActivityPics(String activityPics) {
		this.activityPics = activityPics;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "dtActivity")
	public Set<DtYhq> getDtYhqs() {
		return this.dtYhqs;
	}

	public void setDtYhqs(Set<DtYhq> dtYhqs) {
		this.dtYhqs = dtYhqs;
	}

}