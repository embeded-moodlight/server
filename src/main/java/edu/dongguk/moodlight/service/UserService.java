package edu.dongguk.moodlight.service;

import edu.dongguk.moodlight.domain.User;
import edu.dongguk.moodlight.domain.UserPreference;
import edu.dongguk.moodlight.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private UserMapper userMapper;

    @Autowired
    UserService(UserMapper userMapper){
        this.userMapper = userMapper;
    }

    public void addUser(String token, User user){
        user.setToken(token);
        userMapper.insertUser(user);
    }

    public List<User> getUsers(){
        return userMapper.findAll();
    }

    public void modifyMoodLight(User user){
        userMapper.updateMoodLight(user);
    }

    public List<UserPreference> getUserPreferencesByToken(String token){
        return userMapper.selectPreferenceByUser(token);
    }
}
