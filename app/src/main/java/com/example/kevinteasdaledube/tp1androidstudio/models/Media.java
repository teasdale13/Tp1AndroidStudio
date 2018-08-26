package com.example.kevinteasdaledube.tp1androidstudio.models;

import java.io.Serializable;

public class Media implements Serializable{



    private String title;
    private type mediaType;

    public enum type{
        Book ("Livre"),
        DVD ("DVD"),
        CD ("CD"),
        MP3 ("MP3"),
        MP4 ("MP4");

        private String value;

        type(String value) {
            this.value = value;
        }

        public String getType(){
            return value;
        }
    }

    public type getMediaType() {
        return mediaType;
    }

    public void setMediaType(type mediaType) {
        this.mediaType = mediaType;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }


    //Constructeur de Media
    protected Media(String title){
        this.setTitle( title );


    }




}
