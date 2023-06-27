package com.foreground.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.foreground.entity.AddressUsers;
import com.foreground.entity.Result;
import com.foreground.entity.User;
import com.foreground.service.AddressUsersService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/address")
@Api(tags = "收货地址接口")
public class AddressUsersController {
    @Autowired
    private AddressUsersService addressUsersService;
    private final ObjectMapper objectMapper = new ObjectMapper();

    private final Result result = new Result();

    @PostMapping("/querySingleAddress")
    @ApiOperation(value = "查询用户收货地址")
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
    @ApiOperation(value = "查询用户所有收货地址")
    public List<AddressUsers> queryAllAddressUsersByUserId(@RequestBody String _user) throws IOException {
        User user = objectMapper.readValue(_user, User.class);
        return addressUsersService.queryAllAddressUsersByUserId(user.getId());
    }

    @PostMapping("/addAddress")
    @ApiOperation(value = "添加用户收货地址")
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
    @ApiOperation(value = "删除用户收货地址")
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
    @ApiOperation(value = "修改用户收货地址")
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
    @ApiOperation(value = "查询是否为用户默认收货地址")
    public Result queryDefaultAddress(@RequestBody String _address) throws IOException {
        AddressUsers _addressUsers = objectMapper.readValue(_address, AddressUsers.class);
        AddressUsers addressUsers = addressUsersService.queryDefaultAddress(_addressUsers);
        result.setMsgAndData("查询成功",addressUsers);
        return result;
    }


}
