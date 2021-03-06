package com;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.GenericGenerator;

import com.google.gson.annotations.Expose;

@Entity

public class Option  implements Serializable{
	@Expose
	private Integer id;
	@Expose
	private Integer order_id;
	@Expose
	private String  text;
	private Question question;
	
	@Expose
	private String image_url;
	
	
	public Option() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Option(Integer order_id, String text) {
		super();
		this.order_id = order_id;
		this.text = text;
	}
	
	
	
	public Option(Integer order_id, String text, Question question, String image_url) {
		super();
		this.order_id = order_id;
		this.text = text;
		this.question = question;
		this.image_url = image_url;
	}
	@GenericGenerator(name = "generator", strategy = "increment")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "option_id", unique = true, nullable = false)
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	@Column(name = "order_id", unique = false, nullable = false)
	public Integer getOrder_id() {
		return order_id;
	}
	public void setOrder_id(Integer order_id) {
		this.order_id = order_id;
	}
	
	
	@Column(name = "text", unique = false, nullable = false)

	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "question_id", nullable = false)
	public Question getQuestion() {
		return question;
	}
	public void setQuestion(Question question) {
		this.question = question;
	}
	
	@Column(name = "image_url", unique = false, nullable = false)

	public String getImage_url() {
		return image_url;
	}
	public void setImage_url(String image_url) {
		this.image_url = image_url;
	}
	
	
	
}