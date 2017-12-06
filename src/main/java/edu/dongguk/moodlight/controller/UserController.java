package edu.dongguk.moodlight.controller;

import edu.dongguk.moodlight.domain.User;
import edu.dongguk.moodlight.domain.UserDTO;
import edu.dongguk.moodlight.service.ColorService;
import edu.dongguk.moodlight.service.DiffuserService;
import edu.dongguk.moodlight.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private UserService userService;
    private ColorService colorService;
    private DiffuserService diffuserService;

    @Autowired
    UserController(UserService userService, ColorService colorService, DiffuserService diffuserService) {
        this.userService = userService;
        this.colorService = colorService;
        this.diffuserService = diffuserService;
    }

    @GetMapping
    public List<User> getUsers() {
        return userService.getUsers();
    }


    @PostMapping
    public void addUser(@RequestBody UserDTO userDTO) {
        String token = userDTO.getToken();
        userService.addUser(token, userDTO.getUser());
        colorService.addColors(token, userDTO.getColors());
        diffuserService.addDiffusers(token, userDTO.getDiffusers());
    }

}
