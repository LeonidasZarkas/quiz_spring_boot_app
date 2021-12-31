package com.example.Quiz.services;

import java.util.List;
import com.example.Quiz.models.Answer;
import com.example.Quiz.repos.AnswerRepository;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AnswerServiceImpl implements AnswerServiceInterface{
    
    @Autowired
    AnswerRepository answerRepository;
    
    @Override
    public List<Answer> getAllAnswers() {
        return answerRepository.findAll();
    }
    
    @Override
    public Answer getAnswerById(Integer id) {
        return answerRepository.findById(id).get();
    }
    
    @Override
    @Transactional
    public void createAnswer(Answer answer) {
        answerRepository.save(answer);
    }


    @Override
    @Transactional
    public void deleteAnswerById(Integer id) {
        answerRepository.deleteById(id);
    }

}
