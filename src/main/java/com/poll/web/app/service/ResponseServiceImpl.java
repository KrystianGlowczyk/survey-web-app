package com.poll.web.app.service;

import com.poll.web.app.dao.ResponseDao;
import com.poll.web.app.entity.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ResponseServiceImpl implements ResponseService {

    @Autowired
    private ResponseDao responseDao;

    @Override
    @Transactional
    public void save(List<Response> list) {
        responseDao.save(list);
    }

    @Override
    @Transactional
    public List<Response> findByUsername(String username, String surveyId) {
        return responseDao.findByUsername(username, surveyId);
    }

    @Override
    @Transactional
    public List<Response> findBySurveyId(String surveyId) {
        return responseDao.findBySurveyId(surveyId);
    }
}
