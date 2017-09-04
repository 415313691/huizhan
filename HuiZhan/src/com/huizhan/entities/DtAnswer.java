package com.huizhan.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**
 * DtAnswer entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "dt_answer", catalog = "dati")
public class DtAnswer implements java.io.Serializable {

	// Fields

	private String answerId;
	private String questionId;
	private String answerContent;
	private String answerIsworg;
	private String answerIsdel;

	// Constructors

	/** default constructor */
	public DtAnswer() {
	}

	/** minimal constructor */
	public DtAnswer(String answerId) {
		this.answerId = answerId;
	}

	/** full constructor */
	public DtAnswer(String answerId, String questionId, String answerContent,
			String answerIsworg, String answerIsdel) {
		this.answerId = answerId;
		this.questionId = questionId;
		this.answerContent = answerContent;
		this.answerIsworg = answerIsworg;
		this.answerIsdel = answerIsdel;
	}

	// Property accessors
	@Id
    @GeneratedValue(generator="system-uuid")
    @GenericGenerator(name="system-uuid",strategy="uuid")
	@Column(name = "answer_id", unique = true, nullable = false, length = 40)
	public String getAnswerId() {
		return this.answerId;
	}

	public void setAnswerId(String answerId) {
		this.answerId = answerId;
	}

	@Column(name = "question_id", length = 40)
	public String getQuestionId() {
		return this.questionId;
	}

	public void setQuestionId(String questionId) {
		this.questionId = questionId;
	}

	@Column(name = "answer_content", length = 100)
	public String getAnswerContent() {
		return this.answerContent;
	}

	public void setAnswerContent(String answerContent) {
		this.answerContent = answerContent;
	}

	@Column(name = "answer_isworg", length = 1)
	public String getAnswerIsworg() {
		return this.answerIsworg;
	}

	public void setAnswerIsworg(String answerIsworg) {
		this.answerIsworg = answerIsworg;
	}

	@Column(name = "answer_isdel", length = 1)
	public String getAnswerIsdel() {
		return this.answerIsdel;
	}

	public void setAnswerIsdel(String answerIsdel) {
		this.answerIsdel = answerIsdel;
	}

}