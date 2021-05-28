package com.poll.web.app.service;

import java.util.List;

public interface UsersSurveysService {
    void save(com.poll.web.app.entity.UsersSurveys usersSurveys);
    List<com.poll.web.app.entity.UsersSurveys> isResp(String userId, String surveyId);
    List<Integer> getRespId(String userId);
}
