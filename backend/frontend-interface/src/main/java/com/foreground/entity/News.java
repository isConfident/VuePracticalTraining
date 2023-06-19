package com.foreground.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

public class News {
    private int id;
    private String newsTitle;
    private String newsImg;
    private String newsCon;
    private String newsTime;
    private int sc;
    private String newsDetail;


    public News() {
    }

    public News(int id, String newsTitle, String newsImg, String newsCon, String newsTime, int sc, String newsDetail) {
        this.id = id;
        this.newsTitle = newsTitle;
        this.newsImg = newsImg;
        this.newsCon = newsCon;
        this.newsTime = newsTime;
        this.sc = sc;
        this.newsDetail = newsDetail;
    }

    /**
     * 获取
     * @return id
     */
    public int getId() {
        return id;
    }

    /**
     * 设置
     * @param id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * 获取
     * @return newsTitle
     */
    public String getNewsTitle() {
        return newsTitle;
    }

    /**
     * 设置
     * @param newsTitle
     */
    public void setNewsTitle(String newsTitle) {
        this.newsTitle = newsTitle;
    }

    /**
     * 获取
     * @return newsImg
     */
    public String getNewsImg() {
        return newsImg;
    }

    /**
     * 设置
     * @param newsImg
     */
    public void setNewsImg(String newsImg) {
        this.newsImg = newsImg;
    }

    /**
     * 获取
     * @return newsCon
     */
    public String getNewsCon() {
        return newsCon;
    }

    /**
     * 设置
     * @param newsCon
     */
    public void setNewsCon(String newsCon) {
        this.newsCon = newsCon;
    }

    /**
     * 获取
     * @return newsTime
     */
    public String getNewsTime() {
        return newsTime;
    }

    /**
     * 设置
     * @param newsTime
     */
    public void setNewsTime(String newsTime) {
        this.newsTime = newsTime;
    }

    /**
     * 获取
     * @return sc
     */
    public int getSc() {
        return sc;
    }

    /**
     * 设置
     * @param sc
     */
    public void setSc(int sc) {
        this.sc = sc;
    }

    /**
     * 获取
     * @return newsDetail
     */
    public String getNewsDetail() {
        return newsDetail;
    }

    /**
     * 设置
     * @param newsDetail
     */
    public void setNewsDetail(String newsDetail) {
        this.newsDetail = newsDetail;
    }

    public String toString() {
        return "News{id = " + id + ", newsTitle = " + newsTitle + ", newsImg = " + newsImg + ", newsCon = " + newsCon + ", newsTime = " + newsTime + ", sc = " + sc + ", newsDetail = " + newsDetail + "}";
    }
}
