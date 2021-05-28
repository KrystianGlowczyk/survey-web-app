package com.poll.web.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.poll.web.app.dao.SurveyDao;
import com.poll.web.app.entity.Survey;

@Service
public class SurveyServiceImpl implements SurveyService {
	
	@Autowired
	private SurveyDao surveyDao;

	@Override
	@Transactional
	public List<Survey> getSurveys() {
		
		return surveyDao.getSurveys();
	}

	@Override
	@Transactional
	public Survey getSurveyById(int id) {
		
		return surveyDao.getSurveyById(id);
	}

	@Override
	@Transactional
	public void saveSurvey(Survey survey) {
		surveyDao.saveSurvey(survey);

	}

	@Override
	@Transactional
	public void deleteSurvey(int id) {
		surveyDao.deleteSurvey(id);

	}

}
