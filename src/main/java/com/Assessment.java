package com;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

/**
 * Assessment entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "assessment", schema = "public")

public class Assessment implements java.io.Serializable {

	// Fields

	private Integer assessmentId;
	private String imageUrl;
	private String type;
	private Set<Question> questions = new HashSet<Question>(0);

	// Constructors

	/** default constructor */
	public Assessment() {
	}

	/** minimal constructor */
	public Assessment(String imageUrl, String type) {
		this.imageUrl = imageUrl;
		this.type = type;
	}

	/** full constructor */
	public Assessment(String imageUrl, String type, Set<Question> questions) {
		this.imageUrl = imageUrl;
		this.type = type;
		this.questions = questions;
	}

	// Property accessors
	@GenericGenerator(name = "generator", strategy = "increment")
	@Id
	@GeneratedValue(generator = "generator")

	@Column(name = "assessment_id", unique = true, nullable = false)

	public Integer getAssessmentId() {
		return this.assessmentId;
	}

	public void setAssessmentId(Integer assessmentId) {
		this.assessmentId = assessmentId;
	}

	@Column(name = "image_url", nullable = false)

	public String getImageUrl() {
		return this.imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	@Column(name = "type", nullable = false)

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "assessments")

	public Set<Question> getQuestions() {
		return this.questions;
	}

	public void setQuestions(Set<Question> questions) {
		this.questions = questions;
	}

}