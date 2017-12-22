package edu.dongguk.moodlight.controller;

import edu.dongguk.moodlight.domain.Color;
import edu.dongguk.moodlight.service.ColorService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/colors")
public class ColorController {

    private Logger logger = (Logger) LoggerFactory.getLogger(ColorController.class);

    private ColorService colorService;

    @Autowired
    public ColorController(ColorService colorService){
        this.colorService = colorService;
    }

    @PostMapping
    public void addColor(@RequestBody Color color){
        logger.info(color.toString());
        colorService.addColor(color);
    }

    @PostMapping("/jh")
    public void addColor(){
        System.out.println("color");
    }

    @GetMapping("/{num}")
    public void addRandomColor(@PathVariable int num){
        Color color = new Color();
        color.setToken("AIJF83uaf");
        for(int i=0; i<num; i++) {
            color.setR((int)(Math.random() * 255));
            color.setG((int)(Math.random() * 255));
            color.setB((int)(Math.random() * 255));
            color.setFlag((int)(Math.random() * 255));
            color.setDiscomfortRate((int)(Math.random() * 255));
            System.out.println(color.toString());
            colorService.addColor(color);
        }
    }

}
