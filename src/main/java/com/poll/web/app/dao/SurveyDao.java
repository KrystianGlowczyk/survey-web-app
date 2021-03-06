package com.poll.web.app.dao;

import java.util.List;

import com.poll.web.app.entity.Survey;

public interface SurveyDao {
	
	public List<Survey> getSurveys();
	
	public Survey getSurveyById(int id);
	
	public void saveSurvey(Survey survey);
	
	public void deleteSurvey(int id);

}
