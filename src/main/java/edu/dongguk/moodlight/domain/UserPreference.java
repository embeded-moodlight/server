package edu.dongguk.moodlight.domain;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class UserPreference {
    private String token;
    private int r;
    private int g;
    private int b;
    private int flag;
    private int discomfortRate;
}
