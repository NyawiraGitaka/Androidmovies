package com.nyawira.thedlba;

import java.lang.reflect.Type;

public class MovieItem {

    private String title;
    private String year;
    private String iMBD;
    private String type;
    private String posterUrl;

    MovieItem(String title, String year, String iMBD, String type, String posterUrl){
        this.iMBD = iMBD;
        this.posterUrl = posterUrl;
        this.title = title;
        this.year = year;
        this.type = type;

    }
    public String getYear(){
        return year;
    }
    public String getType(){
        return type;
    }
    public String getPosterUrl(){
        return posterUrl;
    }
    public String getiMBD(){
        return iMBD;
    }
    public String getTitle(){
        return title;
    }
}
