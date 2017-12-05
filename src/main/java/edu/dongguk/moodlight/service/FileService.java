package edu.dongguk.moodlight.service;

import edu.dongguk.moodlight.domain.Voice;
import edu.dongguk.moodlight.mapper.FileMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

@Service
public class FileService {

    private FileMapper fileMapper;

    private static final String BASE_DIR = "/Users/YJH/Desktop/";

    @Autowired
    FileService(FileMapper fileMapper) {
        this.fileMapper = fileMapper;
    }

    @Transactional
    public void addVoice(Voice voice, MultipartFile file) {
        int fileNum = fileMapper.insertVoiceMeta(voice);

        String formattedDate = BASE_DIR + new SimpleDateFormat("yyyy" + File.separator + "MM" + File.separator + "dd").format(new Date());

        File f = new File(formattedDate);

        if (!f.exists()) {
            f.mkdirs();
        }

        String uuid = UUID.randomUUID().toString();

        voice.setVoiceNum(fileNum);
        voice.setVoiceName(file.getOriginalFilename());
        voice.setSaveVoiceName(formattedDate + File.separator + uuid);
        voice.setContentType(file.getContentType());
        voice.setLength(file.getSize());

        try (InputStream in = file.getInputStream();
             FileOutputStream fos = new FileOutputStream(voice.getSaveVoiceName())) {

            int readCount = 0;
            byte[] buffer = new byte[1024];
            while ((readCount = in.read(buffer)) != -1) {
                fos.write(buffer, 0, readCount);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        fileMapper.insertVoiceFile(voice);
    }

}

