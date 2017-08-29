package com.app.preetaharit.activities.models;

/**
 * Created by Rahul on 28-08-2017.
 */

public class CEvent {
    private String title;
    private String desc;
    private String imgurl;
    public CEvent(){

    }
    public CEvent(String title, String desc, String imgurl){
        this.title = title;
        this.desc = desc;
        this.imgurl = imgurl;
    }
    public String getTitle(){
        return this.title;
    }
    public String getDesc(){
        return this.desc;
    }
    public String getImgurl(){
        return this.imgurl;
    }
}
