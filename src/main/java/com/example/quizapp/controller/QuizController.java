package com.example.quizapp.controller;

import com.example.quizapp.Service.QuizService;
import com.example.quizapp.model.QuestionWrapper;
//import org.apache.catalina.connector.Response;
import com.example.quizapp.model.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("Quiz")
public class QuizController {
    @Autowired
    QuizService quizService;
    @PostMapping("create")
    public ResponseEntity<String> createQuiz(@RequestParam String category,@RequestParam int numQ,@RequestParam String Qtitle){
        return quizService.createQuiz(category,numQ,Qtitle);
    }

    @GetMapping("get/{id}")
    public ResponseEntity<List<QuestionWrapper>> getQuestion(@PathVariable Integer id){
        return quizService.getQuestion(id);
    }

    @PostMapping("Submit/{id}")
    public ResponseEntity<Integer> submitQuiz(@PathVariable Integer id, @RequestBody List<Response> responses){
        return quizService.calculateResult(id,responses);
    }
}
