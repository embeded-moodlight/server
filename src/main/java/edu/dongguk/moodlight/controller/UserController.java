package edu.dongguk.moodlight.controller;

import edu.dongguk.moodlight.domain.User;
import edu.dongguk.moodlight.domain.UserDTO;
import edu.dongguk.moodlight.domain.UserPreference;
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
        System.out.println("users");
        return userService.getUsers();
    }

    @PostMapping
    public void addUser(@RequestBody UserDTO userDTO) {
        String token = userDTO.getToken();
        userService.addUser(token, userDTO.getUser());
        colorService.addColors(token, userDTO.getColors());
        diffuserService.addDiffusers(token, userDTO.getDiffusers());
    }

    @PutMapping
    public void addMoodLight(@RequestBody User user){
        userService.modifyMoodLight(user);
    }

    @GetMapping("/{token}")
    public List<UserPreference> getUserPreferencesByToken(@PathVariable String token){
        return userService.getUserPreferencesByToken(token);
    }

    @GetMapping("/test")
    public UserPreference getDeepLearningTest(){
        UserPreference userPreference = new UserPreference();
        userPreference.setFlag((int)(Math.random() * 6));
        userPreference.setDiscomfortRate((int)(Math.random() * 100));
        System.out.println(userPreference.toString());
        return userPreference;
    }

    @PostMapping("/test")
    public void postDeepLearningTest(@RequestBody String userPreference){
        System.out.println(userPreference.toString());
    }
}
