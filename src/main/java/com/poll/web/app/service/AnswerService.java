package com.poll.web.app.service;

import com.poll.web.app.entity.Answer;

public interface AnswerService {
	
	public void saveAnswer(Answer answer, int questionId);

}
