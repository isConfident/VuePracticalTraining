package com.foreground.controller;

import com.foreground.entity.Phone;
import com.foreground.service.PhoneService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/phone")
@Api(tags = "手机商品接口")
public class PhoneController {
    @Autowired
    private PhoneService phoneService;

    @GetMapping ("/query")
    @ApiOperation(value = "查询所有手机商品")
    public List<Phone> query(){ return phoneService.queryAllPhoneAndCommodity(); }
}