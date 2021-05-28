package com.poll.web.app.dao;

import java.util.List;

import com.poll.web.app.entity.Question;

public interface QuestionDao {

	List<Question> getQuestions(int id);

	Question getQuestionById(int id);

	void saveQuestion(Question question, int surveyId);

	void deleteQuestion(int id);

}
