package com.example.Quiz.services;

import java.util.List;
import com.example.Quiz.models.Answer;

public interface AnswerServiceInterface {
    
    public List<Answer> getAllAnswers();
    public Answer getAnswerById(Integer id);
    public void createAnswer(Answer answer);
    public void deleteAnswerById(Integer id);

}
