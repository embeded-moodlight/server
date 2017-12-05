package edu.dongguk.moodlight.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Color {
    private String token;
    private int rgb;
    private int flag;
}
