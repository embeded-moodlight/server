package edu.dongguk.moodlight.mapper;

import edu.dongguk.moodlight.domain.User;
import edu.dongguk.moodlight.domain.UserDTO;
import edu.dongguk.moodlight.domain.UserPreference;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface UserMapper {

    @Insert("INSERT INTO USERS (token, email, name, mood_light) VALUES (#{token}, #{email}, #{name}, #{moodLight})")
    void insertUser(User user);

    @Insert("INSERT INTO FRIENDS (my_token, friend_token) VALUES (#{token}, #{friendToken})")
    void insertFriend(String token, String friendToken);

    @Select("SELECT * FROM USERS")
    List<User> findAll();

    @Update("UPDATE FRIENDS " +
            "SET flag = 1 " +
            "WHERE my_token = #{token}, friend_token = #{friendToken}")
    void agreeFriend(String token, String friendToken);


    @Update({"UPDATE USERS " +
            "SET mood_light = #{moodLight} " +
            "WHERE token = #{token}"})
    void updateMoodLight(User user);

    @Results(id = "userPreference", value = {
            @Result(property = "token", column = "token", id = true),
            @Result(property = "discomfortRate", column = "discomfort_rate")
    })
    @Select({"SELECT token, r, g, b, flag, discomfort_rate " +
            "FROM COLORS " +
            "WHERE token = #{token}"})
    List<UserPreference> selectPreferenceByUser(String token);

}

