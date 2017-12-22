package edu.dongguk.moodlight.mapper;

import edu.dongguk.moodlight.domain.Color;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface ColorMapper {

    @Insert({"INSERT INTO COLORS (token, r, g, b, flag, discomfort_rate) " +
            "VALUES (#{token}, #{r}, #{g}, #{b}, #{flag}, #{discomfortRate})"})
    void insertColor(Color color) throws DuplicateKeyException;

    @Update("UPDATE COLORS" +
            " SET r = #{r}, g = #{g}, b = #{b}, flag = #{flag}" +
            " WHERE token = #{token}")
    void updateColor(Color color);


}