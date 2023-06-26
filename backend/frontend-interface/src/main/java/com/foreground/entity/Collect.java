package com.foreground.entity;

public class Collect {
    private Integer id;
    private String img_url;
    private String name;
    private String content;
    private String bright;
    private String title;
    private Double price;
    private Integer value;
    private Integer user_id;
    private Integer shopping_id;

    public Collect() {
    }

    public Collect(Integer id, String img_url, String name, String content, String bright, String title, Double price, Integer value, Integer user_id, Integer shopping_id) {
        this.id = id;
        this.img_url = img_url;
        this.name = name;
        this.content = content;
        this.bright = bright;
        this.title = title;
        this.price = price;
        this.value = value;
        this.user_id = user_id;
        this.shopping_id = shopping_id;
    }

    /**
     * 获取
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
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
    public Double getPrice() {
        return price;
    }

    /**
     * 设置
     * @param price
     */
    public void setPrice(Double price) {
        this.price = price;
    }

    /**
     * 获取
     * @return value
     */
    public Integer getValue() {
        return value;
    }

    /**
     * 设置
     * @param value
     */
    public void setValue(Integer value) {
        this.value = value;
    }

    /**
     * 获取
     * @return user_id
     */
    public Integer getUser_id() {
        return user_id;
    }

    /**
     * 设置
     * @param user_id
     */
    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    /**
     * 获取
     * @return shopping_id
     */
    public Integer getShopping_id() {
        return shopping_id;
    }

    /**
     * 设置
     * @param shopping_id
     */
    public void setShopping_id(Integer shopping_id) {
        this.shopping_id = shopping_id;
    }

    public String toString() {
        return "Collect{id = " + id + ", img_url = " + img_url + ", name = " + name + ", content = " + content + ", bright = " + bright + ", title = " + title + ", price = " + price + ", value = " + value + ", user_id = " + user_id + ", shopping_id = " + shopping_id + "}";
    }
}
