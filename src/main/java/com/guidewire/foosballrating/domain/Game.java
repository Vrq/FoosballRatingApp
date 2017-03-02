package com.guidewire.foosballrating.domain;


import java.io.Serializable;
import java.util.Date;


public class Game implements Serializable {

    private static final long serialVersionUID = 1L;

    private long id;

    private String aPlayer1;

    private String aPlayer2;

    private String bPlayer1;

    private String bPlayer2;

    private Integer aScore;

    private Integer bScore;

    private Date dateOfGame;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getaPlayer1() {
        return aPlayer1;
    }

    public void setaPlayer1(String aPlayer1) {
        this.aPlayer1 = aPlayer1;
    }

    public String getaPlayer2() {
        return aPlayer2;
    }

    public void setaPlayer2(String aPlayer2) {
        this.aPlayer2 = aPlayer2;
    }

    public String getbPlayer1() {
        return bPlayer1;
    }

    public void setbPlayer1(String bPlayer1) {
        this.bPlayer1 = bPlayer1;
    }

    public String getbPlayer2() {
        return bPlayer2;
    }

    public void setbPlayer2(String bPlayer2) {
        this.bPlayer2 = bPlayer2;
    }

    public Integer getaScore() {
        return aScore;
    }

    public void setaScore(Integer aScore) {
        this.aScore = aScore;
    }

    public Integer getbScore() {
        return bScore;
    }

    public void setbScore(Integer bScore) {
        this.bScore = bScore;
    }

    public Date getDateOfGame() {
        return dateOfGame;
    }

    public void setDateOfGame(Date dateOfGame) {
        this.dateOfGame = dateOfGame;
    }
}
