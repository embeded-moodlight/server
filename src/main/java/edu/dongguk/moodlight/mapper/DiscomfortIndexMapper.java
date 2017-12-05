package edu.dongguk.moodlight.mapper;

import edu.dongguk.moodlight.domain.DiscomfortIndex;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface DiscomfortIndexMapper {

    @Insert({"INSERT INTO DISCOMFORT_INDEX (token, temperature, humidity, discomfort_expression) " +
            "VALUES (#{token}, #{temperature}, #{humidity}, #{discomfortExpression})"})
    void insertDiscomfortIndex(DiscomfortIndex discomfortIndex);

    @Update({"UPDATE DISCOMFORT_INDEX " +
            "SET temperature = #{temperature}, humidity = #{humidity}, discomfortExpression = #{discomfortExpression} " +
            "WHERE token = #{token}"})
    void updateDiscomfortIndexByToken(DiscomfortIndex discomfortIndex);
}
