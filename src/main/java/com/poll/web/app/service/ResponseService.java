package com.poll.web.app.service;

import com.poll.web.app.entity.Response;

import java.util.List;

public interface ResponseService {
    public void save(List<Response> list);

    public List<Response> findByUsername(String username, String surveyId);

    public List<Response> findBySurveyId(String surveyId);
}
