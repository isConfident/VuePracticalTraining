package com.foreground.entity;

import java.util.*;

public class Commodity {
    private int id;
    private int titleId;
    private int nameId;
    private String type;
    private String img_url;
    private String name;
    private String content;
    private String bright;
    private String title;
    private String price;
    private String value;
    private List<Swiper> swiper=new ArrayList<Swiper>();
    private List<Images> images=new ArrayList<Images>();
    private String homePeiZhi;


    public Commodity() {
    }

    public Commodity(int id, int titleId, int nameId, String type, String img_url, String name, String content, String bright, String title, String price, String value, List<Swiper> swiper, List<Images> images, String homePeiZhi) {
        this.id = id;
        this.titleId = titleId;
        this.nameId = nameId;
        this.type = type;
        this.img_url = img_url;
        this.name = name;
        this.content = content;
        this.bright = bright;
        this.title = title;
        this.price = price;
        this.value = value;
        this.swiper = swiper;
        this.images = images;
        this.homePeiZhi = homePeiZhi;
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
     * @return titleId
     */
    public int getTitleId() {
        return titleId;
    }

    /**
     * 设置
     * @param titleId
     */
    public void setTitleId(int titleId) {
        this.titleId = titleId;
    }

    /**
     * 获取
     * @return nameId
     */
    public int getNameId() {
        return nameId;
    }

    /**
     * 设置
     * @param nameId
     */
    public void setNameId(int nameId) {
        this.nameId = nameId;
    }

    /**
     * 获取
     * @return type
     */
    public String getType() {
        return type;
    }

    /**
     * 设置
     * @param type
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * 获取
     * @return img_url
     */
    public String getImg_url() {
        return img_url;
    }

    /**
     * 设置
     * @param img_url
     */
    public void setImg_url(String img_url) {
        this.img_url = img_url;
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
     * @return content
     */
    public String getContent() {
        return content;
    }

    /**
     * 设置
     * @param content
     */
    public void setContent(String content) {
        this.content = content;
    }

    /**
     * 获取
     * @return bright
     */
    public String getBright() {
        return bright;
    }

    /**
     * 设置
     * @param bright
     */
    public void setBright(String bright) {
        this.bright = bright;
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
     * @return price
     */
    public String getPrice() {
        return price;
    }

    /**
     * 设置
     * @param price
     */
    public void setPrice(String price) {
        this.price = price;
    }

    /**
     * 获取
     * @return value
     */
    public String getValue() {
        return value;
    }

    /**
     * 设置
     * @param value
     */
    public void setValue(String value) {
        this.value = value;
    }

    /**
     * 获取
     * @return swiper
     */
    public List<Swiper> getSwiper() {
        return swiper;
    }

    /**
     * 设置
     * @param swiper
     */
    public void setSwiper(List<Swiper> swiper) {
        this.swiper = swiper;
    }

    /**
     * 获取
     * @return images
     */
    public List<Images> getImages() {
        return images;
    }

    /**
     * 设置
     * @param images
     */
    public void setImages(List<Images> images) {
        this.images = images;
    }

    /**
     * 获取
     * @return homePeiZhi
     */
    public String getHomePeiZhi() {
        return homePeiZhi;
    }

    /**
     * 设置
     * @param homePeiZhi
     */
    public void setHomePeiZhi(String homePeiZhi) {
        this.homePeiZhi = homePeiZhi;
    }

    public String toString() {
        return "Commodity{id = " + id + ", titleId = " + titleId + ", nameId = " + nameId + ", type = " + type + ", img_url = " + img_url + ", name = " + name + ", content = " + content + ", bright = " + bright + ", title = " + title + ", price = " + price + ", value = " + value + ", swiper = " + swiper + ", images = " + images + ", homePeiZhi = " + homePeiZhi + "}";
    }
}
