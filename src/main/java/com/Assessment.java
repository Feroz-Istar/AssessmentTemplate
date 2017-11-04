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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.JoinColumn;

import org.hibernate.annotations.GenericGenerator;

import com.google.gson.annotations.Expose;

@Entity
public class Assessment implements Serializable {
	
	@Expose
	private Integer id;
	
	@Expose
	private Set<Question> questions = new HashSet<Question>(0);
	@Expose
	private String image_url;
	
	public Assessment() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	public Assessment( String image_url) {
		super();
		this.image_url = image_url;
	}




	public Assessment( Set<Question> questions, String image_url) {
		super();
		this.questions = questions;
		this.image_url = image_url;
	}
	public Assessment( Set<Question>  questions) {
		super();
		this.questions = questions;
	}
	
	@GenericGenerator(name = "generator", strategy = "increment")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "assessment_id", unique = true, nullable = false)
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	
	
	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable(name = "assessment_question", joinColumns = {
			@JoinColumn(name = "assessment_id", nullable = false, updatable = false) },
			inverseJoinColumns = { @JoinColumn(name = "question_id",
					nullable = false, updatable = false) })
	public Set<Question>  getQuestions() {
		return questions;
	}
	public void setQuestions(Set<Question>  question) {
		this.questions = question;
	}



	@Column(name = "image_url", unique = false, nullable = false)
	public String getImage_url() {
		return image_url;
	}




	public void setImage_url(String image_url) {
		this.image_url = image_url;
	}

	
	
}