package com.foreground.service;

import com.foreground.entity.User;

public interface UserService {

    public User isUsername(User user);
    public User isPassword(User user);
    public User querySimpleUserAndAddressesAndShoppingCartsById(Integer id);

    public Integer addSingleUser(User user);
    public Integer alterSingleUserName(User user);
}
