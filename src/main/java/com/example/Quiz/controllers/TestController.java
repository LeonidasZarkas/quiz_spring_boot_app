package com.example.Quiz.controllers;

import com.example.Quiz.dtos.AnswerDto;
import com.example.Quiz.models.Answer;
import com.example.Quiz.services.AnswerServiceInterface;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/test")
public class TestController {
  
  @Autowired
  AnswerServiceInterface answerServiceInterface;     
    
  @GetMapping("/getallanswers")
  public List<AnswerDto> getallanswers() {
      List<Answer> answerList = new ArrayList<>();
      List<AnswerDto> answerDtoList = new ArrayList<>();
      
      answerList = answerServiceInterface.getAllAnswers();
      
      for(Answer a: answerList){
          answerDtoList.add(new AnswerDto(a));
      }
    return answerDtoList;
  }
  
  @GetMapping("/all")
  public String allAccess() {
    return "Public Content.";
  }

  @GetMapping("/user")
  @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
  public String userAccess() {
    return "User Content.";
  }

  @GetMapping("/admin")
  @PreAuthorize("hasRole('ADMIN')")
  public String adminAccess() {
    return "Admin Board.";
  }
  
}