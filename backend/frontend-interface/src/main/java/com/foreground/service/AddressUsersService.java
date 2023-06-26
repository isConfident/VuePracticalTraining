package com.foreground.service;

import com.foreground.entity.AddressUsers;
import com.foreground.entity.User;

import java.util.List;

public interface AddressUsersService {

    public AddressUsers querySingleAddressUsersById(AddressUsers addressUsers);
    public List<AddressUsers> queryAllAddressUsersByUserId(Integer id);
    public int addSimpleAddressUsers(AddressUsers addressUsers);

    public int delSimpleAddressUsers(Integer userId,Integer id);

    public int alterSimpleAddressUsers(AddressUsers addressUser);

    public AddressUsers queryDefaultAddress(AddressUsers addressUsers);
}
