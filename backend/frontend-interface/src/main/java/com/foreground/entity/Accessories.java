package com.foreground.entity;

import java.util.ArrayList;
import java.util.List;

public class Accessories {
    private int id;
    private String name;
    private List<Commodity> data;


    public Accessories() {
    }

    public Accessories(int id, String name, List<Commodity> data) {
        this.id = id;
        this.name = name;
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
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * 设置
     * @param name
     */
    public void setName(String name) {
        this.name = name;
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
        return "Accessories{id = " + id + ", name = " + name + ", data = " + data + "}";
    }
}
