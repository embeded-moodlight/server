package edu.dongguk.moodlight.controller;

import edu.dongguk.moodlight.domain.User;
import edu.dongguk.moodlight.persistence.UserMapper;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Logger;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private UserMapper userMapper;

    @Autowired
    UserController(UserMapper userMapper){
        this.userMapper = userMapper;
    }

    @GetMapping
    public List<User> getUsers(){
        return userMapper.findAll();
    }

    @PostMapping
    public void addUser(@RequestBody User user){
        System.out.println(user.getToken());
        System.out.println(user.getEmail());
        System.out.println(user.getMoodLight());
        System.out.println(user.getName());
        userMapper.insertUser(user);

    }
}
