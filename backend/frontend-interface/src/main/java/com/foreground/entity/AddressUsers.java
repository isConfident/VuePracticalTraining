package com.foreground.entity;

public class AddressUsers {
    private Integer id;
    private String addressDetail;
    private String areaCode;
    private String city;
    private String country;
    private String county;
    private Boolean isDefault;
    private String name;
    private String postalCode;
    private String province;
    private String tel;
    private Integer user_id;


    public AddressUsers() {
    }

    public AddressUsers(Integer id, String addressDetail, String areaCode, String city, String country, String county, Boolean isDefault, String name, String postalCode, String province, String tel, Integer userId) {
        this.id = id;
        this.addressDetail = addressDetail;
        this.areaCode = areaCode;
        this.city = city;
        this.country = country;
        this.county = county;
        this.isDefault = isDefault;
        this.name = name;
        this.postalCode = postalCode;
        this.province = province;
        this.tel = tel;
        this.user_id = userId;
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
     * @return addressDetail
     */
    public String getAddressDetail() {
        return addressDetail;
    }

    /**
     * 设置
     * @param addressDetail
     */
    public void setAddressDetail(String addressDetail) {
        this.addressDetail = addressDetail;
    }

    /**
     * 获取
     * @return areaCode
     */
    public String getAreaCode() {
        return areaCode;
    }

    /**
     * 设置
     * @param areaCode
     */
    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode;
    }

    /**
     * 获取
     * @return city
     */
    public String getCity() {
        return city;
    }

    /**
     * 设置
     * @param city
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * 获取
     * @return country
     */
    public String getCountry() {
        return country;
    }

    /**
     * 设置
     * @param country
     */
    public void setCountry(String country) {
        this.country = country;
    }

    /**
     * 获取
     * @return county
     */
    public String getCounty() {
        return county;
    }

    /**
     * 设置
     * @param county
     */
    public void setCounty(String county) {
        this.county = county;
    }

    /**
     * 获取
     * @return isDefault
     */
    public Boolean getIsDefault() {
        return isDefault;
    }

    /**
     * 设置
     * @param isDefault
     */
    public void setIsDefault(Boolean isDefault) {
        this.isDefault = isDefault;
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
     * @return postalCode
     */
    public String getPostalCode() {
        return postalCode;
    }

    /**
     * 设置
     * @param postalCode
     */
    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    /**
     * 获取
     * @return province
     */
    public String getProvince() {
        return province;
    }

    /**
     * 设置
     * @param province
     */
    public void setProvince(String province) {
        this.province = province;
    }

    /**
     * 获取
     * @return tel
     */
    public String getTel() {
        return tel;
    }

    /**
     * 设置
     * @param tel
     */
    public void setTel(String tel) {
        this.tel = tel;
    }

    /**
     * 获取
     * @return userId
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

    public String toString() {
        return "AddressUsers{id = " + id + ", addressDetail = " + addressDetail + ", areaCode = " + areaCode + ", city = " + city + ", country = " + country + ", county = " + county + ", isDefault = " + isDefault + ", name = " + name + ", postalCode = " + postalCode + ", province = " + province + ", tel = " + tel + ", userId = " + user_id + "}";
    }
}
