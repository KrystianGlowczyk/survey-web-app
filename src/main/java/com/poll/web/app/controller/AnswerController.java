package com.poll.web.app.controller;

import com.poll.web.app.entity.Question;
import com.poll.web.app.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import com.poll.web.app.entity.Answer;
import com.poll.web.app.service.AnswerService;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Set;

@Controller
@RequestMapping("/answer")
public class AnswerController {
	
	@Autowired
	AnswerService answerService;

	@Autowired
	QuestionService questionService;

	@GetMapping("/addAnswer")
	public String addAnswer(Model theModel) {

		Answer answer = new Answer();
		theModel.addAttribute("answer", answer);
		
		return "add-answer";
	}
	//@PostMapping("/saveAnswer/{surveyId}")
	@PostMapping("/saveAnswer")
	public String saveAnswer(HttpServletRequest request, @RequestParam("question") String tmp, @ModelAttribute("answer") Answer answer, BindingResult result, RedirectAttributes redirectAttributes) {

		if(result.hasErrors()) {
			result.getAllErrors();
		}
		System.out.println("*******request answer********** " + answer.getId());
		System.out.println("*******request********** " + request.getParameter("title"));
		System.out.println("*******question id********** " + request.getParameter("question"));


		answerService.saveAnswer(answer,Integer.parseInt(tmp));


		//@PathVariable("surveyId") String surveyId, RedirectAttributes redirectAttributes,
		
		return "redirect:/survey/list";
	}

	
	
}
