package com.example.myapplicationdemo02.entity;

public class Hero {
    private String hName;

    public Hero() {
    }

    public Hero(String hName) {
        this.hName = hName;
    }

    public String gethName() {
        return hName;
    }

    public void sethName(String hName) {
        this.hName = hName;
    }
}
