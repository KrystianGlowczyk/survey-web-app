package com.poll.web.app.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.poll.web.app.entity.Question;
import com.poll.web.app.entity.Survey;

@Repository
public class QuestionDaoImpl implements QuestionDao {

	@Autowired
	public SessionFactory sessionFactory;

	@Override
	public List<Question> getQuestions(Long id) {
		Session currentSession = sessionFactory.getCurrentSession();

		Query<Question> theQuery = currentSession.createQuery("from Question where survey_id=:theId", Question.class);
		theQuery.setParameter("theId", id);
		List<Question> questions = theQuery.getResultList();

		return questions;
	}

	@Override
	public Question getQuestionById(Long id) {
		Session currentSession = sessionFactory.getCurrentSession();

		Question question = null;

		question = currentSession.get(Question.class, id);

		return question;
	}

	@Override
	public void saveQuestion(Question question, Long surveyId) {
		Session currentSession = sessionFactory.getCurrentSession();
		Survey survey = currentSession.get(Survey.class, surveyId);
		question.setSurvey(survey);
		currentSession.saveOrUpdate(question);

	}

	@Override
	public void deleteQuestion(Long id) {
		Session currentSession = sessionFactory.getCurrentSession();

		Query<Question> theQuery = currentSession.createQuery("delete from Question where id=:questionId",Question.class);

		theQuery.setParameter("questionId", id);

		theQuery.executeUpdate();

	}

}
