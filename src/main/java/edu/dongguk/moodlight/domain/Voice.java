package edu.dongguk.moodlight.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Getter
@Setter
@ToString
public class Voice {

    private int voiceNum;
    private String token;
    private String senderToken;
    private int flag;
    private String voiceName;
    private String saveVoiceName;
    private Date date;
    private String contentType;
    private long length;

}