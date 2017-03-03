package com.guidewire.foosballrating.domain;

import java.io.Serializable;
import java.util.Date;

public class Score implements Serializable {

    private static final long serialVersionUID = 1L;

    private int id;
    private String username;
    private int rank;
    private int points;
    private Date creationTime;

    public Score(){}

    public Score(String username, int rank, int points){
        this.username = username;
        this.rank = rank;
        this.points = points;
        this.creationTime = new Date();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public Date getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(Date creationTime) {
        this.creationTime = creationTime;
    }


}
