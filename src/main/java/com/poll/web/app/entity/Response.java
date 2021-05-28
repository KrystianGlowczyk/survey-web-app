package com.poll.web.app.entity;

import javax.persistence.*;

@Entity
@Table(name = "response")
public class Response {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "username")
    private String user;

    @Column(name = "survey_id")
    private int surveyId;

    @Column(name = "question_id")
    private int questionId;

    @Column(name = "text")
    private String text;

    @Column(name = "verification")
    private String verification;

    public Response() {
    }

    public Response(int id, String user, int surveyId, int questionId, String text, String verification) {
        this.id = id;
        this.user = user;
        this.surveyId = surveyId;
        this.questionId = questionId;
        this.text = text;
        this.verification = verification;
    }

    public Response(String user, int surveyId, int questionId, String text) {
        this.user = user;
        this.surveyId = surveyId;
        this.questionId = questionId;
        this.text = text;
    }

    public Response(int surveyId, int questionId, String text) {
        this.surveyId = surveyId;
        this.questionId = questionId;
        this.text = text;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public int getSurveyId() {
        return surveyId;
    }

    public void setSurveyId(int surveyId) {
        this.surveyId = surveyId;
    }

    public int getQuestionId() {
        return questionId;
    }

    public void setQuestionId(int questionId) {
        this.questionId = questionId;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getVerification() {
        return verification;
    }

    public void setVerification(String verification) {
        this.verification = verification;
    }
}
