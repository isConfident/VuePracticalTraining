package com.foreground.service;

import com.foreground.entity.User;

public interface UserService {
    String userLogin(String userName,String userPassword);

    String userRegister(String userName,String userPassword);
}
