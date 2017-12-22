package edu.dongguk.moodlight.controller;

import edu.dongguk.moodlight.domain.Voice;
import edu.dongguk.moodlight.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.List;

@Controller
@RequestMapping("/api/files")
public class FileContoller {

    private FileService fileService;

    @Autowired
    FileContoller(FileService fileService){
        this.fileService = fileService;
    }

    @PostMapping
    public void addVoiceFile(@ModelAttribute Voice voice, MultipartFile file){
        fileService.addVoice(voice, file);
    }

    @GetMapping("/box/{token}")
    @ResponseBody
    public List<Voice> getVoicesByToken(@PathVariable String token){
        return fileService.getVoicesByUser(token);
    }

    @GetMapping("/{voiceNum}")
    @ResponseBody
    public void getVoiceByVoiceNum(@PathVariable int voiceNum, HttpServletResponse response) throws FileNotFoundException {
        Voice voice = fileService.getVoiceByVoiceNum(voiceNum);

        if (isValidVoice(voice, response)) {
            FileInputStream fis = new FileInputStream(voice.getSaveVoiceName());

            try {
                FileCopyUtils.copy(fis, response.getOutputStream()); // 파일을 저장할때도 사용할 수 있다.
                response.getOutputStream().flush();
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            } finally {
                try {
                    fis.close();
                } catch (Exception ex) {
                }
            }
        }
    }

    public boolean isValidVoice(Voice voice, HttpServletResponse response){
        if (voice == null) {
            return false;
        } else {
            response.setHeader("Content-Disposition", "inline; filename=\"" + voice.getVoiceName() + "\";");
            response.setHeader("Content-Transfer-Encoding", "binary");
            response.setHeader("Content-Type", voice.getContentType());
            response.setHeader("Content-Length", "" + voice.getLength());
            response.setHeader("Pragma", "no-cache;");
            response.setHeader("Expires", "-1;");
            return true;
        }
    }

}
