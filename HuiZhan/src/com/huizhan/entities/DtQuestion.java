package com.huizhan.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**
 * DtQuestion entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "dt_question", catalog = "dati")
public class DtQuestion implements java.io.Serializable {

	// Fields

	private String questionId;
	private String questionTitle;
	private String questionIsdel;

	// Constructors

	/** default constructor */
	public DtQuestion() {
	}

	/** minimal constructor */
	public DtQuestion(String questionId) {
		this.questionId = questionId;
	}

	/** full constructor */
	public DtQuestion(String questionId, String questionTitle,
			String questionIsdel) {
		this.questionId = questionId;
		this.questionTitle = questionTitle;
		this.questionIsdel = questionIsdel;
	}

	// Property accessors
	@Id
	@GeneratedValue(generator="system-uuid")
    @GenericGenerator(name="system-uuid",strategy="uuid")
	@Column(name = "question_id", unique = true, nullable = false, length = 40)
	public String getQuestionId() {
		return this.questionId;
	}

	public void setQuestionId(String questionId) {
		this.questionId = questionId;
	}

	@Column(name = "question_title", length = 500)
	public String getQuestionTitle() {
		return this.questionTitle;
	}

	public void setQuestionTitle(String questionTitle) {
		this.questionTitle = questionTitle;
	}

	@Column(name = "question_isdel", length = 1)
	public String getQuestionIsdel() {
		return this.questionIsdel;
	}

	public void setQuestionIsdel(String questionIsdel) {
		this.questionIsdel = questionIsdel;
	}

}