package com.example.quizapp.controller;

import com.example.quizapp.model.Question;
import com.example.quizapp.Service.QuestionService;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("Question")
public class QuestionController {

    @Autowired
    QuestionService questionService;

    @GetMapping("allQuestions")
    public ResponseEntity<List<Question>> getAllquestion() {  // ← Question not TypePatternQuestions.Question
        return questionService.getAllquestion();
    }
    @GetMapping("Category/{category}")
    public ResponseEntity<List<Question>> getQuestionByCategory(@PathVariable String category){
        return questionService.getQuestionByCategory(category);
    }
    @PostMapping("add")
    public ResponseEntity<String> addQuestion(@RequestBody Question question){
        return questionService.addQuestion(question);
    }
    @GetMapping("home")
    public String greet (HttpServletRequest req){
        return "welcome to home page"+req.getSession().getId();
    }
    @GetMapping("/csrftoken")
    public CsrfToken getcsrftoken(HttpServletRequest req){
        return (CsrfToken) (req.getAttribute("_csrf"));
    }
}