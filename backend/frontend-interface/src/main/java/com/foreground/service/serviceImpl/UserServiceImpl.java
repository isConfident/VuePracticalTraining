package com.foreground.service.serviceImpl;

import com.foreground.dao.UserDao;
import com.foreground.entity.User;
import com.foreground.service.UserService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("userService")
public class UserServiceImpl implements UserService {
    @Resource
    @Qualifier
    private UserDao userDao;

    @Override
    public String userLogin(String userName, String userPassword) {

        if ( userDao.userLogin(userName,userPassword)==null){
            return "登录失败！";
        }else {
            return "登陆成功！";
        }
    }

    @Override
    public String userRegister(String userName, String userPassword) {
        if (userDao.userRegister1(userName)==null){
            userDao.userRegister2(userName,userPassword);
            return "注册成功!";
        }
        return "注册失败！已有用户名。";
    }

    @Override
    public User querySimpleUserAndAddressesAndShoppingCartsById(Integer id) {
        return userDao.querySimpleUserAndAddressesAndShoppingCartsById(id);
    }
}
