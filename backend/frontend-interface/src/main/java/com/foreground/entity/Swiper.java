package com.foreground.entity;

public class Swiper {
    private int id;
    private int commodityId;
    private String swipe;


    public Swiper() {
    }

    public Swiper(int id, int commodityId, String swipe) {
        this.id = id;
        this.commodityId = commodityId;
        this.swipe = swipe;
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
     * @return commodityId
     */
    public int getCommodityId() {
        return commodityId;
    }

    /**
     * 设置
     * @param commodityId
     */
    public void setCommodityId(int commodityId) {
        this.commodityId = commodityId;
    }

    /**
     * 获取
     * @return swipe
     */
    public String getSwipe() {
        return swipe;
    }

    /**
     * 设置
     * @param swipe
     */
    public void setSwipe(String swipe) {
        this.swipe = swipe;
    }

    public String toString() {
        return "Swiper{id = " + id + ", commodityId = " + commodityId + ", swipe = " + swipe + "}";
    }
}
