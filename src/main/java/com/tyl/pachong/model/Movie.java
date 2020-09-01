package com.tyl.pachong.model;


public class Movie {

    private String title;//标题
    private String rate;//评分

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getRate() {
        return rate;
    }

    public void setRate(String rate) {
        this.rate = rate;
    }

    @Override
    public String toString() {
        return "'" + title + '\'' +
                " '" + rate + '\'' ;
    }
}

