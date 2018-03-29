package com.example.em.mi.bean;

/**
 * Created by pc on 2017/7/6.
 * 参与用户entity
 */

public class Participant_user {
    private String username;

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }
    public Participant_user(String username){
        this.username = username;

    }
}
