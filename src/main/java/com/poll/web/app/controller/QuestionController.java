package com.poll.web.app.controller;

import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.poll.web.app.entity.Question;
import com.poll.web.app.entity.Survey;
import com.poll.web.app.service.QuestionService;
import com.poll.web.app.service.SurveyService;

@Controller
@RequestMapping("/question")
public class QuestionController {
	
	@Autowired
	private QuestionService questionService;
	
	@Autowired
	private SurveyService surveyService;
	
	@GetMapping("/list")
	public String listQuestions(HttpServletRequest httpServletRequest, Model theModel) {
		
		Survey survey = new Survey();
		survey = surveyService.getSurveyById(Integer.parseInt(httpServletRequest.getParameter("surveyId")));
		Set<Question> questions = survey.getQuestions();
		
		theModel.addAttribute("questions",questions);
		
		return "list-questions";
	}
	
	@GetMapping("/addQuestion")
	public String addQuestion(Model theModel) {
		
		Question theQuestion = new Question();
		theModel.addAttribute("question",theQuestion);
		
		return "add-question";
	}
	
	@GetMapping("/updateQuestion")
	public String updateQuestion(@RequestParam("questionId") int id ,Model theModel) {
		
		Question theQuestion = questionService.getQuestionById(id);
		theModel.addAttribute("question",theQuestion);
		
		return "add-question";
	}
	
	@PostMapping("/saveQuestion")
	public String saveQuestion(@RequestParam("survey") String tmp, @ModelAttribute("question") Question question) {
		
		//String tmp = httpServletRequest.getParameter("survey");
		questionService.saveQuestion(question, Integer.parseInt(tmp));
		
		return "redirect:/survey/list";
	}
	
	@GetMapping("/deleteQuestion")
	public String deleteQuestion(@RequestParam("questionId") int id) {
		
		questionService.deleteQuestion(id);
		
		return "redirect:/question/list";
	}

}
