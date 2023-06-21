package com.foreground.controller;

import com.foreground.entity.User;
import com.foreground.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("/login")
    public String loginUser(String userName,String userPassword){ return userService.userLogin(userName,userPassword);}

    @RequestMapping("/register")
    public String registerUser(String userName,String userPassword){ return userService.userRegister(userName,userPassword);}

    @PostMapping("/querySimpleUserInfo")
    @ResponseBody
    public User querySimpleUserAndAddressesAndShoppingCartsById( Integer id){
        return userService.querySimpleUserAndAddressesAndShoppingCartsById(id);
    };
}
