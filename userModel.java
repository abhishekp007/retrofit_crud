package com.example.retrofit_crud.Model;

public class userModel {

    private int id;
    private String name,job,imglink;

    public userModel(int id, String name, String job, String imglink) {
        this.id = id;
        this.name = name;
        this.job = job;
        this.imglink = imglink;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getImglink() {
        return imglink;
    }

    public void setImglink(String imglink) {
        this.imglink = imglink;
    }
}
