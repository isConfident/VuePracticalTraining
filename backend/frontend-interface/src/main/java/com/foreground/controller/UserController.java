package com.foreground.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.foreground.entity.Result;
import com.foreground.entity.User;
import com.foreground.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.SocketTimeoutException;
import java.net.URLDecoder;


@RestController
@RequestMapping("/api/user")
public class UserController {
    @Autowired
    private UserService userService;

    private final ObjectMapper objectMapper = new ObjectMapper();

    private final Result result = new Result();
    @PostMapping("/login")
    public Result login(@RequestBody String _user) throws IOException {
        User user = objectMapper.readValue(urlDecode(_user), User.class);
        User isUsername = userService.isUsername(user);
        if(isUsername != null){
            User isPassword = userService.isPassword(user);
            System.out.println(isPassword);
            if(isPassword != null){
                result.setMsgAndData("登录成功",isPassword);
            }else{
                result.setMsgAndData("密码错误",isPassword);
            }
        }else{
            result.setMsgAndData("用户不存在",isUsername);
        }
        return result;
    }

    @PostMapping("/querySimpleUserInfo")
    @ResponseBody
    public User querySimpleUserAndAddressesAndShoppingCartsById( Integer id){
        return userService.querySimpleUserAndAddressesAndShoppingCartsById(id);
    };


    public String urlDecode(String urlString) throws UnsupportedEncodingException {
        return URLDecoder.decode(urlString,"UTF-8");
    }
}
