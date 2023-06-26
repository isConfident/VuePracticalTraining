package com.foreground.service.serviceImpl;

import com.foreground.dao.AddressUsersDao;
import com.foreground.entity.AddressUsers;
import com.foreground.entity.User;
import com.foreground.service.AddressUsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressUsersServiceImpl implements AddressUsersService {
    @Autowired
    private AddressUsersDao addressUsersDao;
    @Override
    public List<AddressUsers> queryAllAddressUsersByUserId(Integer id) {
        return addressUsersDao.queryAllAddressUsersByUserId(id);
    }
}
