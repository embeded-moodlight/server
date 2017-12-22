package edu.dongguk.moodlight.service;

import edu.dongguk.moodlight.domain.Color;
import edu.dongguk.moodlight.mapper.ColorMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

@Service
public class ColorService {

    private ColorMapper colorMapper;

    @Autowired
    ColorService(ColorMapper colorMapper){
        this.colorMapper = colorMapper;
    }

    public void addColor(Color color) {
        try {
            colorMapper.insertColor(color);
        } catch(DuplicateKeyException e){
            return;
        }
    }

    public void addColors(String token, Color[] colors){
        if(colors.length == 0){
            return;
        }

        for(Color color : colors) {
            color.setToken(token);
            addColor(color);
        }
    }
}
