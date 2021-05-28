package com.poll.web.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.poll.web.app.dao.QuestionDao;
import com.poll.web.app.entity.Question;

@Service
public class QuestionServiceImpl implements QuestionService {
	
	@Autowired
	private QuestionDao questionDao;

	@Override
	@Transactional
	public List<Question> getQuestions(int id) {
		return questionDao.getQuestions(id);
	}

	@Override
	@Transactional
	public Question getQuestionById(int id) {
		return questionDao.getQuestionById(id);
	}

	@Override
	@Transactional
	public void saveQuestion(Question question, int surveyId) {
		questionDao.saveQuestion(question, surveyId);

	}

	@Override
	@Transactional
	public void deleteQuestion(int id) {
		questionDao.deleteQuestion(id);

	}

}
