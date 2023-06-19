package com.foreground.entity;

public class Images {
    private int id;
    private int commodityId;
    private String one;

    public Images() {
    }

    public Images(int id, int commodityId, String one) {
        this.id = id;
        this.commodityId = commodityId;
        this.one = one;
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
     * @return one
     */
    public String getOne() {
        return one;
    }

    /**
     * 设置
     * @param one
     */
    public void setOne(String one) {
        this.one = one;
    }

    public String toString() {
        return "Images{id = " + id + ", commodityId = " + commodityId + ", one = " + one + "}";
    }
}
