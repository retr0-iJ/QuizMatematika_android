package com.example.bootcampandroidday1_immanueljoseph_2301852215.model;

import java.io.Serializable;

public class ScoreData implements Serializable {
    private String username;
    private Integer score;

    public ScoreData(String username, Integer score) {
        this.username = username;
        this.score = score;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }
}
