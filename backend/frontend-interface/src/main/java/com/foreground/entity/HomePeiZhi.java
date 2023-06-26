package com.foreground.entity;

public class HomePeiZhi {
    private int id;
    private int commodityId;
    private String peiZhiName;
    private String peiZhiInformation;


    public HomePeiZhi() {
    }

    public HomePeiZhi(int id, int commodityId, String peiZhiName, String peiZhiInformation) {
        this.id = id;
        this.commodityId = commodityId;
        this.peiZhiName = peiZhiName;
        this.peiZhiInformation = peiZhiInformation;
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
     * @return peiZhiName
     */
    public String getPeiZhiName() {
        return peiZhiName;
    }

    /**
     * 设置
     * @param peiZhiName
     */
    public void setPeiZhiName(String peiZhiName) {
        this.peiZhiName = peiZhiName;
    }

    /**
     * 获取
     * @return peiZhiInformation
     */
    public String getPeiZhiInformation() {
        return peiZhiInformation;
    }

    /**
     * 设置
     * @param peiZhiInformation
     */
    public void setPeiZhiInformation(String peiZhiInformation) {
        this.peiZhiInformation = peiZhiInformation;
    }

    public String toString() {
        return "HomePeiZhi{id = " + id + ", commodityId = " + commodityId + ", peiZhiName = " + peiZhiName + ", peiZhiInformation = " + peiZhiInformation + "}";
    }
}
