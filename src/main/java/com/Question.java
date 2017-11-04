package com;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.GenericGenerator;

import com.google.gson.annotations.Expose;
@Entity
public class Question implements Serializable {
	
	
	@Expose
	private Integer id;
	@Expose
	private String text;
	@Expose
	private String instructions;
	private  Set<Assessment> assessments = new HashSet<Assessment>(0);
	@Expose
	private Set<Option> options = new HashSet<Option>(
			0);
	@Expose
	private Set<Answer> answers = new HashSet<Answer>(
			0);
	
	@Expose
	private String type;
	@Expose
	private Integer order_id;
	public Question() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Question(String text, String instructions) {
		super();
		this.text = text;
		this.instructions = instructions;
	}
	
	

	public Question(String text, String instructions, Set<Assessment> assessments) {
		super();
		this.text = text;
		this.instructions = instructions;
		this.assessments = assessments;
	}

	
	
	
	


	public Question(String text, String instructions, String type, Integer order_id) {
		super();
		this.text = text;
		this.instructions = instructions;
		this.type = type;
		this.order_id = order_id;
	}

	@GenericGenerator(name = "generator", strategy = "increment")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "question_id", unique = true, nullable = false)
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	
	@Column(name = "question_text", unique = false, nullable = false)
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}

	@Column(name = "instructions", unique = false, nullable = false)
	public String getInstructions() {
		return instructions;
	}

	public void setInstructions(String instructions) {
		this.instructions = instructions;
	}

	@ManyToMany(fetch = FetchType.EAGER, mappedBy = "questions")
	public Set<Assessment> getAssessments() {
		return assessments;
	}

	public void setAssessments(Set<Assessment> assessments) {
		this.assessments = assessments;
	}

	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER, mappedBy = "question")

	public Set<Option> getOptions() {
		return options;
	}

	public void setOptions(Set<Option> options) {
		this.options = options;
	}

	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER, mappedBy = "question")

	public Set<Answer> getAnswers() {
		return answers;
	}

	public void setAnswers(Set<Answer> answers) {
		this.answers = answers;
	}

	@Column(name = "type", unique = false, nullable = false)
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Column(name = "order_id", unique = false, nullable = false)
	public Integer getOrder_id() {
		return order_id;
	}

	public void setOrder_id(Integer order_id) {
		this.order_id = order_id;
	}
	
	
	
	
}