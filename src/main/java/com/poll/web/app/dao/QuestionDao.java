package com.poll.web.app.dao;

import java.util.List;

import com.poll.web.app.entity.Question;

public interface QuestionDao {

	List<Question> getQuestions(Long id);

	Question getQuestionById(Long id);

	void saveQuestion(Question question, Long surveyId);

	void deleteQuestion(Long id);

}
