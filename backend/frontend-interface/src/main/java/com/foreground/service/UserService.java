package com.foreground.service;

import com.foreground.entity.User;

import java.util.List;

public interface UserService {

    public User isUsername(User user);

    public List<User> isUsernames(User user);
    public User isPassword(User user);
    public User querySimpleUserAndAddressesAndShoppingCartsById(Integer id);

    public Integer addSingleUser(User user);
    public Integer alterSingleUserName(User user);

    public Integer alterSingleUserInfo(User user);
    public Integer alterUserPassword(User user);
}
