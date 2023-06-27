package com.foreground.service.serviceImpl;

import com.foreground.dao.UserDao;
import com.foreground.entity.User;
import com.foreground.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service("userService")
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;


    @Override
    public User isUsername(User user) {
        return userDao.isUsername(user);
    }

    @Override
    public List<User> isUsernames(User user) {
        return userDao.isUsernames(user);
    }

    @Override
    public User isPassword(User user) {
        return userDao.isPassword(user);
    }

    @Override
    public User querySimpleUserAndAddressesAndShoppingCartsById(Integer id) {
        return userDao.querySimpleUserAndAddressesAndShoppingCartsById(id);
    }

    @Override
    public Integer addSingleUser(User user) {
        User flag = isUsername(user);
        if(flag != null){
            return 0;
        }
        return userDao.addSingleUser(user);
    }

    @Override
    public Integer alterSingleUserName(User user) {
        return userDao.alterSingleUserName(user);
    }

    @Override
    public Integer alterSingleUserInfo(User user) {
        return userDao.alterSingleUserInfo(user);
    }

    @Override
    public Integer alterUserPassword(User user) {
        return userDao.alterUserPassword(user);
    }
}
