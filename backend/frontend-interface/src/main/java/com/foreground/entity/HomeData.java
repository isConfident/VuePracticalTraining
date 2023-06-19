package com.foreground.entity;

import java.util.ArrayList;
import java.util.List;

public class HomeData {
    private int id;
    private String title;
    private List<Commodity> data=new ArrayList<Commodity>();

    public HomeData() {
    }

    public HomeData(int id, String title, List<Commodity> data) {
        this.id = id;
        this.title = title;
        this.data = data;
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
     * @return title
     */
    public String getTitle() {
        return title;
    }

    /**
     * 设置
     * @param title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * 获取
     * @return data
     */
    public List<Commodity> getData() {
        return data;
    }

    /**
     * 设置
     * @param data
     */
    public void setData(List<Commodity> data) {
        this.data = data;
    }

    public String toString() {
        return "HomeData{id = " + id + ", title = " + title + ", data = " + data + "}";
    }
}
