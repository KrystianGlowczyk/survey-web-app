package com.poll.web.app.service;

import java.util.List;

import com.poll.web.app.entity.Survey;
	

public interface SurveyService {

	List<Survey> getSurveys();

	Survey getSurveyById(Long id);

	void saveSurvey(Survey survey);

	void deleteSurvey(Long id);

}
