package com.poll.web.app.service;

import java.util.List;

import com.poll.web.app.entity.Question;

public interface QuestionService {
	
	public List<Question> getQuestions(int id);

	public Question getQuestionById(int id);

	public void saveQuestion(Question question, int surveyId);

	public void deleteQuestion(int id);
}
