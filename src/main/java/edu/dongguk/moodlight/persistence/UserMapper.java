package edu.dongguk.moodlight.persistence;

import edu.dongguk.moodlight.domain.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface UserMapper {


    @Insert("INSERT INTO USERS (token, email, name, mood_light) VALUES (#{token}, #{email}, #{name}, #{moodLight})")
    void insertUser(User user);

    @Select("SELECT * FROM USERS")
    List<User> findAll();
}
