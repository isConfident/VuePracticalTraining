package com.foreground.entity;

public class AddressUsers {
    private Integer id;
    private String name;
    private String phone;
    private String area;
    private String detailAddress;
    private Integer userId;

    public AddressUsers() {
    }

    public AddressUsers(Integer id, String name, String phone, String area, String detailAddress, Integer userId) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.area = area;
        this.detailAddress = detailAddress;
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
     * @return phone
     */
    public String getPhone() {
        return phone;
    }

    /**
     * 设置
     * @param phone
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * 获取
     * @return area
     */
    public String getArea() {
        return area;
    }

    /**
     * 设置
     * @param area
     */
    public void setArea(String area) {
        this.area = area;
    }

    /**
     * 获取
     * @return detailAddress
     */
    public String getDetailAddress() {
        return detailAddress;
    }

    /**
     * 设置
     * @param detailAddress
     */
    public void setDetailAddress(String detailAddress) {
        this.detailAddress = detailAddress;
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
        return "AddressUsers{id = " + id + ", name = " + name + ", phone = " + phone + ", area = " + area + ", detailAddress = " + detailAddress + ", userId = " + userId + "}";
    }
}
