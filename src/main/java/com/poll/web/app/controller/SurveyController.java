package com.poll.web.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.poll.web.app.entity.Survey;
import com.poll.web.app.service.SurveyService;

@Controller
@RequestMapping("/survey")
public class SurveyController {
	
	@Autowired
	private SurveyService surveyService;
	
	@GetMapping("/list")
	public String listSurveys(Model theModel) {
		
		List<Survey> theSurveys = surveyService.getSurveys();
		
		theModel.addAttribute("surveys", theSurveys);
		
		return "list-surveys";
		
	}

	@GetMapping("/addSurvey")
	public String addSurvey(Model theModel) {
		
		Survey theSurvey = new Survey();
		theModel.addAttribute("survey",theSurvey);
		
		return "add-survey";
	}
	
	@PostMapping("/saveSurvey")
	public String saveSurvey(@ModelAttribute("survey") Survey theSurvey) {
		surveyService.saveSurvey(theSurvey);
		
		return "redirect:/survey/list";
	}
	
	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("surveyId") Long theId, Model theModel) {
		
		Survey theSurvey = surveyService.getSurveyById(theId);
		
		theModel.addAttribute("survey", theSurvey);
		
		return "add-survey";
	}
	
	@GetMapping("/delete")
	public String deleteSurvey(@RequestParam("surveyId") Long id) {
		
		surveyService.deleteSurvey(id);
		
		return "redirect:/survey/list";
		
	}
	
	
}
