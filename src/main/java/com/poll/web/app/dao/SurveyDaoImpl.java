package com.poll.web.app.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.poll.web.app.entity.Survey;

@Repository
public class SurveyDaoImpl implements SurveyDao {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Survey> getSurveys() {
		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		// create a query
		Query<Survey> theQuery = currentSession.createQuery("from Survey", Survey.class);

		// execute query and get the result list
		List<Survey> surveys = theQuery.getResultList();

		// return the results
		return surveys;
	}

	@Override
	public void saveSurvey(Survey survey) {
		// get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		// save/update the customer .. finally
		currentSession.saveOrUpdate(survey);

	}

	@Override
	public Survey getSurveyById(Long id) {
		// get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		// get the customer by id
		Survey theSurvey = null;
		theSurvey = currentSession.get(Survey.class, id);

		return theSurvey;
	}

	@Override
	public void deleteSurvey(Long id) {
		// get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		// delete the customer by id
		Query theQuery = currentSession.createQuery("delete from Survey where id=:surveyId");
		theQuery.setParameter("surveyId", id);
		theQuery.executeUpdate();

	}

}
