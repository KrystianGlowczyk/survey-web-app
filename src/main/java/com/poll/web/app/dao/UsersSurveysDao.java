package com.poll.web.app.dao;

import com.poll.web.app.entity.UsersSurveys;

import java.util.List;

public interface UsersSurveysDao {
    void save(UsersSurveys usersSurveys);
    List<UsersSurveys> isResp(String userId, String surveyId);
    List<Integer> getRespId(String userId);
}
