package edu.dongguk.moodlight.mapper;


import edu.dongguk.moodlight.domain.Question;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface QuestionMapper {

    @Results(id = "questionResult", value = {
            @Result(property = "questionId", column = "question_id", id = true),
            @Result(property = "question", column = "question"),
            @Result(property = "situationId", column = "situation_id"),
            @Result(property = "date", column = "date")
    })
    @Select("SELECT * FROM QUESTIONS WHERE question_id = #{id}")
    Question selectQuestionById(int id);

}
