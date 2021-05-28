package com.poll.web.app.dao;

import com.poll.web.app.entity.Answer;

public interface AnswerDao {
	
	void saveAnswer(Answer answer, int questionId);

}
