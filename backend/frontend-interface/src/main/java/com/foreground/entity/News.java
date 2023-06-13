package com.foreground.entity;

public class News {
    private int id;
    private String newsTitle;
    private String newsImg;
    private String newsCon;
    private String newsTime;
    private String newsDetail;

    public News() {
    }

    public News(int id, String newsTitle, String newsImg, String newsCon, String newsTime, String newsDetail) {
        this.id = id;
        this.newsTitle = newsTitle;
        this.newsImg = newsImg;
        this.newsCon = newsCon;
        this.newsTime = newsTime;
        this.newsDetail = newsDetail;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNewsTitle() {
        return newsTitle;
    }

    public void setNewsTitle(String newsTitle) {
        this.newsTitle = newsTitle;
    }

    public String getNewsImg() {
        return newsImg;
    }

    public void setNewsImg(String newsImg) {
        this.newsImg = newsImg;
    }

    public String getNewsCon() {
        return newsCon;
    }

    public void setNewsCon(String newsCon) {
        this.newsCon = newsCon;
    }

    public String getNewsTime() {
        return newsTime;
    }

    public void setNewsTime(String newsTime) {
        this.newsTime = newsTime;
    }

    public String getNewsDetail() {
        return newsDetail;
    }

    public void setNewsDetail(String newsDetail) {
        this.newsDetail = newsDetail;
    }
}
