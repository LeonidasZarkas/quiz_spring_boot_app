package com.example.Quiz.services;

import java.util.List;
import com.example.Quiz.models.Question;

public interface QuestionServiceInterface {
    
    public List<Question> getAllQuestions();
    public Question getQuestionById(Integer id);
    public void createQuestion(Question question);
    public void deleteQuestionById(Integer id);
}
