package com.app.preetaharit.activities.models;

/**
 * Created by Rahul on 28-08-2017.
 */

public class CMenu {
    private String title;
    private String img;
    public CMenu(){

    }
    public CMenu(String title, String img){
        this.title = title;
        this.img = img;
    }
    public void setTitle(String title){
        this.title = title;
    }
    public void setImg(String img){
        this.img = img;
    }
    public String getTitle(){
        return this.title;
    }
    public String getImg(){
        return this.img;
    }
}
