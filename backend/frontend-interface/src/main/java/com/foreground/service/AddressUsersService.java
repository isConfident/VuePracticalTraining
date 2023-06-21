package com.foreground.service;

import com.foreground.entity.AddressUsers;
import com.foreground.entity.User;

import java.util.List;

public interface AddressUsersService {
    public List<AddressUsers> queryAllAddressUsersByUserId(Integer id);
}
