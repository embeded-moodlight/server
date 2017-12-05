package edu.dongguk.moodlight.mapper;

import edu.dongguk.moodlight.domain.Color;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface ColorMapper {

    @Insert("INSERT INTO COLORS (token, rgb, flag} VALUES (#{token}, #{rgb}, #{flag})")
    void insertColor(Color color);

    @Update("Update COROLS " +
            "SET rgb = #{rgb}, flag = #{flag} " +
            "WHERE token = #{token}")
    void updateColor(Color color);


}