package com.example.Quiz.services;

import java.util.List;
import com.example.Quiz.models.Question;
import com.example.Quiz.repos.QuestionRepository;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

@Service
public class QuestionServiceImpl implements QuestionServiceInterface{
    
    @Autowired
    QuestionRepository questionRepository;
    
    @Override
    public List<Question> getAllQuestions() {
        return questionRepository.findAll();
    }

    @Override
    public Question getQuestionById(Integer id) {
        return questionRepository.findById(id).get();
    }
    
    @Override
    @Transactional
    public void createQuestion(Question question) {
        questionRepository.save(question);
    }


    @Override
    @Transactional
    public void deleteQuestionById(Integer id) {
        questionRepository.deleteById(id);
    }



}
