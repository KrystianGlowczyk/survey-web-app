package com.poll.web.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.poll.web.app.dao.AnswerDao;
import com.poll.web.app.entity.Answer;

@Service
public class AnswerServiceImpl implements AnswerService {
	
	@Autowired
	AnswerDao answerDao;

	@Override
	@Transactional
	public void saveAnswer(Answer answer, int questionId) {
		
		answerDao.saveAnswer(answer, questionId);
	}

}
