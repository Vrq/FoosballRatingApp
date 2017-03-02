package com.guidewire.foosballrating.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;


@Builder
public class Game implements Serializable {

    private static final long serialVersionUID = 1L;

    @Getter
    private long id;

    @Getter
    @Setter
    private String aPlayer1;
    @Getter
    @Setter
    private String aPlayer2;
    @Getter
    @Setter
    private String bPlayer1;
    @Getter
    @Setter
    private String bPlayer2;

    @Getter
    @Setter
    private LocalDateTime dateOfGame;


}
