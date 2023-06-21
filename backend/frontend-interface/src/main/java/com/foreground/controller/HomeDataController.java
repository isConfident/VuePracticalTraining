package com.foreground.controller;

import com.foreground.entity.HomeData;
import com.foreground.service.HomeDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/homeData")
public class HomeDataController {
    @Autowired
    private HomeDataService homeDataService;

    @GetMapping("/query")
    public List<HomeData> query(){ return homeDataService.queryAllHomeDataAndCommodity(); }

}

