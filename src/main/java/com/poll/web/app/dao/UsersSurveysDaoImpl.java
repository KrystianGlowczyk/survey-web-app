package com.poll.web.app.dao;

import com.poll.web.app.entity.UsersSurveys;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UsersSurveysDaoImpl implements UsersSurveysDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void save(UsersSurveys usersSurveys) {
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.saveOrUpdate(usersSurveys);
    }

    @Override
    public List<UsersSurveys> isResp(String idUser, String idSurvey) {
        Session currentSession = sessionFactory.getCurrentSession();
        Query<UsersSurveys> theQuery = currentSession.createQuery("from UsersSurveys where userId=:userId and surveyId=:surveyId", UsersSurveys.class);
        theQuery.setParameter("userId", idUser);
        theQuery.setParameter("surveyId", idSurvey);
        List<UsersSurveys> list = theQuery.getResultList();

        return list;
    }

    @Override
    public List<Integer> getRespId(String userId) {
        Session currentSession = sessionFactory.getCurrentSession();
        Query<Integer> theQuery = currentSession.createQuery("SELECT surveyId FROM UsersSurveys q where userId=:userId", Integer.class);
        theQuery.setParameter("userId", userId);
        List<Integer> list = theQuery.getResultList();

        return list;
    }
}
