package edu.dongguk.moodlight.controller;

import edu.dongguk.moodlight.domain.Question;
import edu.dongguk.moodlight.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/questions")
public class QuestionController {

    public QuestionService questionService;

    @Autowired
    public QuestionController(QuestionService questionService){
        this.questionService = questionService;
    }

    @GetMapping("/today")
    public Question getQuestionById(){
        System.out.println("get-today");
        return questionService.getQuestionById();
    }

    @PostMapping("/today")
    public Question postQuestionById(){
        System.out.println("post-today");
        return questionService.getQuestionById();
    }

}
