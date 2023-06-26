package com.foreground.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.foreground.entity.AddressUsers;
import com.foreground.entity.Result;
import com.foreground.entity.User;
import com.foreground.service.AddressUsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/address")
public class AddressUsersController {
    @Autowired
    private AddressUsersService addressUsersService;
    private final ObjectMapper objectMapper = new ObjectMapper();

    private final Result result = new Result();

    @PostMapping("/querySingleAddress")
    public Result querySingleAddressUsersById(@RequestBody String _addressUser) throws IOException {
        AddressUsers addressUsers = objectMapper.readValue(_addressUser, AddressUsers.class);
        addressUsers = addressUsersService.querySingleAddressUsersById(addressUsers);
        if(addressUsers != null){
            result.setMsgAndData("查询成功",addressUsers);
        }else{
            result.setMsgAndData("查询失败",addressUsers);
        }
        return result;
    }

    @PostMapping("/queryAddress")
    public List<AddressUsers> queryAllAddressUsersByUserId(@RequestBody String _user) throws IOException {
        User user = objectMapper.readValue(_user, User.class);
        return addressUsersService.queryAllAddressUsersByUserId(user.getId());
    }

    @PostMapping("/addAddress")
    public Result addressUsers(@RequestBody String _address) throws IOException {
        AddressUsers addressUsers = objectMapper.readValue(_address, AddressUsers.class);
        int flag = addressUsersService.addSimpleAddressUsers(addressUsers);
        if(flag > 0){
            result.setMsgAndData("添加成功",flag);
        }else{
            result.setMsgAndData("添加失败",flag);
        }
        return result;
    }

    @PostMapping("/delAddress")
    public Result delSimpleAddressUsers(@RequestBody String _address) throws IOException {
        AddressUsers addressUsers = objectMapper.readValue(_address, AddressUsers.class);
        int flag = addressUsersService.delSimpleAddressUsers(addressUsers.getUser_id(), addressUsers.getId());
        if(flag > 0){
            result.setMsgAndData("删除成功",flag);
        }else{
            result.setMsgAndData("删除失败",flag);
        }
        return result;
    }

    @PostMapping("/alterAddress")
    public Result alterSimpleAddressUsers(@RequestBody String _address) throws IOException {
        AddressUsers addressUsers = objectMapper.readValue(_address, AddressUsers.class);
        int flag = addressUsersService.alterSimpleAddressUsers(addressUsers);
        if(flag > 0){
            result.setMsgAndData("修改成功",flag);
        }else{
            result.setMsgAndData("修改失败",flag);
        }
        return result;
    }

    @PostMapping("/queryDefault")
    public Result queryDefaultAddress(@RequestBody String _address) throws IOException {
        AddressUsers _addressUsers = objectMapper.readValue(_address, AddressUsers.class);
        AddressUsers addressUsers = addressUsersService.queryDefaultAddress(_addressUsers);
        result.setMsgAndData("查询成功",addressUsers);
        return result;
    }


}
