package com.huizhan.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**
 * DtUserAnswer entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "dt_user_answer", catalog = "dati")
public class DtUserAnswer implements java.io.Serializable {

	// Fields

	private String uaId;
	private DtActivityRecord dtActivityRecord;
	private String uaQuestionid;
	private String uaAnswerid;
	private String uaIswrong;

	// Constructors

	/** default constructor */
	public DtUserAnswer() {
	}

	/** minimal constructor */
	public DtUserAnswer(String uaId) {
		this.uaId = uaId;
	}

	/** full constructor */
	public DtUserAnswer(String uaId, DtActivityRecord dtActivityRecord,
			String uaQuestionid, String uaAnswerid, String uaIswrong) {
		this.uaId = uaId;
		this.dtActivityRecord = dtActivityRecord;
		this.uaQuestionid = uaQuestionid;
		this.uaAnswerid = uaAnswerid;
		this.uaIswrong = uaIswrong;
	}

	// Property accessors
	@Id
    @GeneratedValue(generator="system-uuid")
    @GenericGenerator(name="system-uuid",strategy="uuid")
	@Column(name = "ua_id", unique = true, nullable = false, length = 40)
	public String getUaId() {
		return this.uaId;
	}

	public void setUaId(String uaId) {
		this.uaId = uaId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "arecord_id")
	public DtActivityRecord getDtActivityRecord() {
		return this.dtActivityRecord;
	}

	public void setDtActivityRecord(DtActivityRecord dtActivityRecord) {
		this.dtActivityRecord = dtActivityRecord;
	}

	@Column(name = "ua_questionid", length = 40)
	public String getUaQuestionid() {
		return this.uaQuestionid;
	}

	public void setUaQuestionid(String uaQuestionid) {
		this.uaQuestionid = uaQuestionid;
	}

	@Column(name = "ua_answerid", length = 40)
	public String getUaAnswerid() {
		return this.uaAnswerid;
	}

	public void setUaAnswerid(String uaAnswerid) {
		this.uaAnswerid = uaAnswerid;
	}

	@Column(name = "ua_iswrong", length = 1)
	public String getUaIswrong() {
		return this.uaIswrong;
	}

	public void setUaIswrong(String uaIswrong) {
		this.uaIswrong = uaIswrong;
	}

}