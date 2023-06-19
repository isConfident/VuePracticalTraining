package com.foreground.controller;

import com.foreground.entity.HomeData;
import com.foreground.service.HomeDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/homedata")
public class HomeDataController {
    @Autowired
    private HomeDataService homeDataService;

    @RequestMapping("/query")
    public List<HomeData> query(){
        return homeDataService.queryAllHomeDataAndCommodity();
    }
}
