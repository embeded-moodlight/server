package edu.dongguk.moodlight.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class UserDTO {

    private String token;
    private User user;
    private Color[] colors;
    private Diffuser[] diffusers;
}
