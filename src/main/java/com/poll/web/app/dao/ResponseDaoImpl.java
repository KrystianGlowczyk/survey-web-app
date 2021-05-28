package com.poll.web.app.dao;

import com.poll.web.app.entity.Response;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ResponseDaoImpl implements ResponseDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void save(List<Response> list) {
        Session currentSession = sessionFactory.getCurrentSession();
        for (Response r : list) {
            currentSession.saveOrUpdate(r);
        }
    }

    @Override
    public List<Response> findByUsername(String username, String surveyId) {
        Session currentSession = sessionFactory.getCurrentSession();
        Query<Response> theQuery = currentSession.createQuery("from Response where surveyId=:surveyId", Response.class);
        theQuery.setParameter("surveyId", surveyId);
        List<Response> list = theQuery.getResultList();

        return list;
    }

    @Override
    public List<Response> findBySurveyId(String surveyId) {
        Session currentSession = sessionFactory.getCurrentSession();
        Query<Response> theQuery = currentSession.createQuery("from Response where surveyId=:surveyId", Response.class);
        theQuery.setParameter("surveyId", surveyId);
        List<Response> list = theQuery.getResultList();

        return list;
    }
}
