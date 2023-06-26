package com.foreground.service.serviceImpl;

import com.foreground.dao.UserDao;
import com.foreground.entity.User;
import com.foreground.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service("userService")
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;


    @Override
    public User isUsername(User user) {
        return userDao.isUsername(user);
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
}
