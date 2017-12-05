package edu.dongguk.moodlight.mapper;

import edu.dongguk.moodlight.domain.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
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
}
