package com;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

/**
 * Question entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "question", schema = "public")

public class Question implements java.io.Serializable {

	// Fields

	private Integer questionId;
	private String instructions;
	private String questionText;
	private Integer orderId;
	private String questionType;
	private Set<Assessment> assessments = new HashSet<Assessment>(0);
	private Set<Answer> answers = new HashSet<Answer>(0);
	private Set<Option> options = new HashSet<Option>(0);

	// Constructors

	/** default constructor */
	public Question() {
	}

	/** minimal constructor */
	public Question(String instructions, String questionText) {
		this.instructions = instructions;
		this.questionText = questionText;
	}

	/** full constructor */
	public Question(String instructions, String questionText, Integer orderId, String questionType,
			Set<Assessment> assessments, Set<Answer> answers, Set<Option> options) {
		this.instructions = instructions;
		this.questionText = questionText;
		this.orderId = orderId;
		this.questionType = questionType;
		this.assessments = assessments;
		this.answers = answers;
		this.options = options;
	}

	// Property accessors
	@GenericGenerator(name = "generator", strategy = "increment")
	@Id
	@GeneratedValue(generator = "generator")

	@Column(name = "question_id", unique = true, nullable = false)

	public Integer getQuestionId() {
		return this.questionId;
	}

	public void setQuestionId(Integer questionId) {
		this.questionId = questionId;
	}

	@Column(name = "instructions", nullable = false)

	public String getInstructions() {
		return this.instructions;
	}

	public void setInstructions(String instructions) {
		this.instructions = instructions;
	}

	@Column(name = "question_text", nullable = false)

	public String getQuestionText() {
		return this.questionText;
	}

	public void setQuestionText(String questionText) {
		this.questionText = questionText;
	}

	@Column(name = "order_id")

	public Integer getOrderId() {
		return this.orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	@Column(name = "question_type")

	public String getQuestionType() {
		return this.questionType;
	}

	public void setQuestionType(String questionType) {
		this.questionType = questionType;
	}

	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinTable(name = "assessment_question", schema = "public", joinColumns = {
			@JoinColumn(name = "question_id", nullable = false, updatable = false) }, inverseJoinColumns = {
					@JoinColumn(name = "assessment_id", nullable = false, updatable = false) })

	public Set<Assessment> getAssessments() {
		return this.assessments;
	}

	public void setAssessments(Set<Assessment> assessments) {
		this.assessments = assessments;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "question")

	public Set<Answer> getAnswers() {
		return this.answers;
	}

	public void setAnswers(Set<Answer> answers) {
		this.answers = answers;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "question")

	public Set<Option> getOptions() {
		return this.options;
	}

	public void setOptions(Set<Option> options) {
		this.options = options;
	}

}