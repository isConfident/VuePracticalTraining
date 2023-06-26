package com.foreground.service.serviceImpl;

import com.foreground.dao.AddressUsersDao;
import com.foreground.entity.AddressUsers;
import com.foreground.service.AddressUsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressUsersServiceImpl implements AddressUsersService {
    @Autowired
    private AddressUsersDao addressUsersDao;

    @Override
    public AddressUsers querySingleAddressUsersById(AddressUsers addressUsers) {
        return addressUsersDao.querySingleAddressUsersById(addressUsers);
    }

    @Override
    public List<AddressUsers> queryAllAddressUsersByUserId(Integer id) {
        return addressUsersDao.queryAllAddressUsersByUserId(id);
    }

    @Override
    public int addSimpleAddressUsers(AddressUsers addressUsers) {
        return addressUsersDao.addSimpleAddressUsers(addressUsers);
    }

    @Override
    public int delSimpleAddressUsers(Integer userId, Integer id) {
        return addressUsersDao.delSimpleAddressUsers(userId,id);
    }

    @Override
    public int alterSimpleAddressUsers(AddressUsers addressUser) {
       if(addressUser.getIsDefault()){
           List<AddressUsers> addressUsers = addressUsersDao.queryAllAddressUsersByUserId(addressUser.getUser_id());
           for (AddressUsers user : addressUsers) {
               user.setIsDefault(false);
               addressUsersDao.alterSimpleAddressUsers(user);
           }
       }
        return addressUsersDao.alterSimpleAddressUsers(addressUser);
    }

    @Override
    public AddressUsers queryDefaultAddress(AddressUsers addressUsers) {
        return addressUsersDao.queryDefaultAddress(addressUsers);
    }
}
