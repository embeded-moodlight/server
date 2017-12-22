package edu.dongguk.moodlight.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Getter
@Setter
@ToString
public class Question {
    private int questionId;
    private String question;
    private int situationId;
    private Date date;
}
