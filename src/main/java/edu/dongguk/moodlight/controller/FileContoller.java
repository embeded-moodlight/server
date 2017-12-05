package edu.dongguk.moodlight.controller;

import edu.dongguk.moodlight.domain.Voice;
import edu.dongguk.moodlight.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/api/files")
public class FileContoller {

    private FileService fileService;

    @Autowired
    FileContoller(FileService fileService){
        this.fileService = fileService;
    }

    @PostMapping
    void addVoiceFile(@ModelAttribute Voice voice, MultipartFile file){
        fileService.addVoice(voice, file);
    }
}
