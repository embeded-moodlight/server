package edu.dongguk.moodlight.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class DiscomfortIndex {

    private String token;
    private double temperature;
    private double humidity;
    private String discomfortExpression;
}
