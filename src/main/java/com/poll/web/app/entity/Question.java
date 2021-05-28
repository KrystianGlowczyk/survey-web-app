package com.poll.web.app.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "question")
public class Question {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "title")
	private String title;
	
	@Column(name = "type")
	private String type;
	
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "survey_id")
	private Survey survey;

	@OneToMany(mappedBy = "question",fetch = FetchType.EAGER, cascade = CascadeType.ALL,orphanRemoval = true)
	private Set<Answer> answers;

	public Question(String title, String type, Survey survey, Set<Answer> answers) {
		this.title = title;
		this.type = type;
		this.survey = survey;
		this.answers = answers;
	}

	public Question(String title, Set<Answer> answers) {
		this.title = title;
		this.answers = answers;
	}

	public Question(String title, String type, Survey survey) {
		super();
		this.title = title;
		this.type = type;
		this.survey = survey;
	}

	public Set<Answer> getAnswers() {
		return answers;
	}

	public void setAnswers(Set<Answer> answers) {
		this.answers = answers;
	}

	public Question() {
		// TODO Auto-generated constructor stub
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}


	public Survey getSurvey() {
		return survey;
	}


	public void setSurvey(Survey survey) {
		this.survey = survey;
	}
	
	
}
