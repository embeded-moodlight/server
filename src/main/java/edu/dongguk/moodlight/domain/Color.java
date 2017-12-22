package edu.dongguk.moodlight.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Color {
    private String token;
    private int r;
    private int g;
    private int b;
    private int flag; //default 0, 밥 1, 술 2, 시험 3, 휴일 4, 데이트 5
    private int discomfortRate;
}