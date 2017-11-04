package com;

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
 * Option entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "option", schema = "public")

public class Option implements java.io.Serializable {

	// Fields

	private Integer optionId;
	private Question question;
	private Integer orderId;
	private String text;

	// Constructors

	/** default constructor */
	public Option() {
	}

	/** full constructor */
	public Option(Question question, Integer orderId, String text) {
		this.question = question;
		this.orderId = orderId;
		this.text = text;
	}

	// Property accessors
	@GenericGenerator(name = "generator", strategy = "increment")
	@Id
	@GeneratedValue(generator = "generator")

	@Column(name = "option_id", unique = true, nullable = false)

	public Integer getOptionId() {
		return this.optionId;
	}

	public void setOptionId(Integer optionId) {
		this.optionId = optionId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "question_id", nullable = false)

	public Question getQuestion() {
		return this.question;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}

	@Column(name = "order_id", nullable = false)

	public Integer getOrderId() {
		return this.orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	@Column(name = "text", nullable = false)

	public String getText() {
		return this.text;
	}

	public void setText(String text) {
		this.text = text;
	}

}