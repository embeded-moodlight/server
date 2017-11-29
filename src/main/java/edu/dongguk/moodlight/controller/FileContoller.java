package edu.dongguk.moodlight.controller;

import edu.dongguk.moodlight.domain.User;
import edu.dongguk.moodlight.persistence.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/files")
public class FileContoller {

    @Autowired
    FileContoller(){
    }

}
