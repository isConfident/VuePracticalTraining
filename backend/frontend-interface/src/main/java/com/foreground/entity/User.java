package com.foreground.entity;

import java.util.List;

public class User {
    private int id;
    private String userName;
    private String userPassword;
    private List<AddressUsers> addressUsersList;
    private List<ShoppingCarts> shoppingCartsList;

    public User() {
    }

    public User(int id, String userName, String userPassword) {
        this.id = id;
        this.userName = userName;
        this.userPassword = userPassword;
    }

    public User(int id, String userName, String userPassword, List<AddressUsers> addressUsersList, List<ShoppingCarts> shoppingCartsList) {
        this.id = id;
        this.userName = userName;
        this.userPassword = userPassword;
        this.addressUsersList = addressUsersList;
        this.shoppingCartsList = shoppingCartsList;
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
     * @return userName
     */
    public String getUserName() {
        return userName;
    }

    /**
     * 设置
     * @param userName
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * 获取
     * @return userPassword
     */
    public String getUserPassword() {
        return userPassword;
    }

    /**
     * 设置
     * @param userPassword
     */
    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String toString() {
        return "User{id = " + id + ", userName = " + userName + ", userPassword = " + userPassword + "}";
    }

    /**
     * 获取
     * @return addressUsersList
     */
    public List<AddressUsers> getAddressUsersList() {
        return addressUsersList;
    }

    /**
     * 设置
     * @param addressUsersList
     */
    public void setAddressUsersList(List<AddressUsers> addressUsersList) {
        this.addressUsersList = addressUsersList;
    }

    /**
     * 获取
     * @return shoppingCartsList
     */
    public List<ShoppingCarts> getShoppingCartsList() {
        return shoppingCartsList;
    }

    /**
     * 设置
     * @param shoppingCartsList
     */
    public void setShoppingCartsList(List<ShoppingCarts> shoppingCartsList) {
        this.shoppingCartsList = shoppingCartsList;
    }
}
