package com.foreground.entity;

public class ShoppingCarts {
    private Integer id;
    private String imgUrl;
    private String name;
    private String content;
    private String bright;
    private String title;
    private Double price;
    private Integer value;
    private Integer userId;

    public ShoppingCarts() {
    }

    public ShoppingCarts(Integer id, String imgUrl, String name, String content, String bright, String title, Double price, Integer value, Integer userId) {
        this.id = id;
        this.imgUrl = imgUrl;
        this.name = name;
        this.content = content;
        this.bright = bright;
        this.title = title;
        this.price = price;
        this.value = value;
        this.userId = userId;
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
     * @return imgUrl
     */
    public String getImgUrl() {
        return imgUrl;
    }

    /**
     * 设置
     * @param imgUrl
     */
    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
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
     * @return userId
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * 设置
     * @param userId
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String toString() {
        return "ShoppingCarts{id = " + id + ", imgUrl = " + imgUrl + ", name = " + name + ", content = " + content + ", bright = " + bright + ", title = " + title + ", price = " + price + ", value = " + value + ", userId = " + userId + "}";
    }
}
