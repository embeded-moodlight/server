package edu.dongguk.moodlight.service;

import edu.dongguk.moodlight.domain.Question;
import edu.dongguk.moodlight.mapper.QuestionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QuestionService {

    private QuestionMapper questionMapper;

    @Autowired
    public QuestionService(QuestionMapper questionMapper){
        this.questionMapper = questionMapper;
    }

    public Question getQuestionById(){
        int id = (int) (Math.random() * 8 + 1);
        return questionMapper.selectQuestionById(id);
    }
}
