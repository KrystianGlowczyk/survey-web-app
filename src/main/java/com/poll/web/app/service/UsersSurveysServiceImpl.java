package com.poll.web.app.service;

import com.poll.web.app.dao.UsersSurveysDao;
import com.poll.web.app.entity.UsersSurveys;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UsersSurveysServiceImpl implements UsersSurveysService{

    @Autowired
    private UsersSurveysDao usersSurveysDao;


    @Override
    @Transactional
    public void save(UsersSurveys usersSurveys) {
        usersSurveysDao.save(usersSurveys);
    }

    @Override
    @Transactional
    public List<UsersSurveys> isResp(String userId, String surveyId) {
        return usersSurveysDao.isResp(userId,surveyId);
    }

    @Override
    @Transactional
    public List<Integer> getRespId(String userId) {
        return usersSurveysDao.getRespId(userId);
    }
}
