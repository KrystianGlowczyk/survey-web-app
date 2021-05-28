package com.poll.web.app.dao;

import com.poll.web.app.entity.Answer;
import com.poll.web.app.entity.Question;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class AnswerDaoImpl implements AnswerDao {

	@Autowired
	public SessionFactory sessionFactory;


	@Override
	public void saveAnswer(Answer answer, int questionId) {
		
		Session session = sessionFactory.getCurrentSession();
		
		Question question = session.get(Question.class, questionId);
		
		answer.setQuestion(question);
		
		session.saveOrUpdate(answer);

	}

}
