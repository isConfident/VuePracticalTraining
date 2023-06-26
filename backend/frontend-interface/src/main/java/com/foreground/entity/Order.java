package com.foreground.entity;

public class Order {
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
    private String invoice;
    private Integer address_id;
    private String order_comment;
    private String order_date;
    private String paymentType;

    public Order() {
    }

    public Order(Integer id, String img_url, String name, String content, String bright, String title, Double price, Integer value, Integer user_id, Integer shopping_id, String invoice, Integer address_id, String order_comment, String order_date, String paymentType) {
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
        this.invoice = invoice;
        this.address_id = address_id;
        this.order_comment = order_comment;
        this.order_date = order_date;
        this.paymentType = paymentType;
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

    /**
     * 获取
     * @return invoice
     */
    public String getInvoice() {
        return invoice;
    }

    /**
     * 设置
     * @param invoice
     */
    public void setInvoice(String invoice) {
        this.invoice = invoice;
    }

    /**
     * 获取
     * @return address_id
     */
    public Integer getAddress_id() {
        return address_id;
    }

    /**
     * 设置
     * @param address_id
     */
    public void setAddress_id(Integer address_id) {
        this.address_id = address_id;
    }

    /**
     * 获取
     * @return order_comment
     */
    public String getOrder_comment() {
        return order_comment;
    }

    /**
     * 设置
     * @param order_comment
     */
    public void setOrder_comment(String order_comment) {
        this.order_comment = order_comment;
    }

    /**
     * 获取
     * @return order_date
     */
    public String getOrder_date() {
        return order_date;
    }

    /**
     * 设置
     * @param order_date
     */
    public void setOrder_date(String order_date) {
        this.order_date = order_date;
    }

    /**
     * 获取
     * @return paymentType
     */
    public String getPaymentType() {
        return paymentType;
    }

    /**
     * 设置
     * @param paymentType
     */
    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }

    public String toString() {
        return "Order{id = " + id + ", img_url = " + img_url + ", name = " + name + ", content = " + content + ", bright = " + bright + ", title = " + title + ", price = " + price + ", value = " + value + ", user_id = " + user_id + ", shopping_id = " + shopping_id + ", invoice = " + invoice + ", address_id = " + address_id + ", order_comment = " + order_comment + ", order_date = " + order_date + ", paymentType = " + paymentType + "}";
    }
}
