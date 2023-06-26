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

    @PostMapping("/register")
    public Result addSingleUser(@RequestBody String _user) throws IOException {
        User user = objectMapper.readValue(_user, User.class);
        Integer flag = userService.addSingleUser(user);
        if(flag > 0){
            result.setMsgAndData("注册成功",flag);
        }else{
            result.setMsgAndData("用户名已存在",flag);
        }
        return result;
    };

    @PostMapping("/alterUser")
    public Integer alterSingleUserName(@RequestBody String _user) throws IOException {
        User user = objectMapper.readValue(_user, User.class);
        if(userService.isUsername(user) != null){
            return 0;
        }
        return userService.alterSingleUserName(user);
    };


    public String urlDecode(String urlString) throws UnsupportedEncodingException {
        return URLDecoder.decode(urlString,"UTF-8");
    }
}
