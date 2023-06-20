package com.foreground.controller;

import com.foreground.entity.Phone;
import com.foreground.service.PhoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/phone")
public class PhoneController {
    @Autowired
    private PhoneService phoneService;

    @RequestMapping("/query")
    public List<Phone> query(){ return phoneService.queryAllPhoneAndCommodity(); }
}
