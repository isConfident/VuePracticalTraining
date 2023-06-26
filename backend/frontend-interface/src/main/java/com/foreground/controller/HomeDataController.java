package com.foreground.controller;

import com.foreground.entity.HomeData;
import com.foreground.service.HomeDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/homeData")
public class HomeDataController {
    @Autowired
    private HomeDataService homeDataService;

    @GetMapping("/query")
    public List<HomeData> query(){ return homeDataService.queryAllHomeDataAndCommodity(); }

//    @GetMapping("/singleQuery")
//    List<HomeData> querySingleHomeDataAndCommodity(@RequestParam("id") Integer id){
//        System.out.println(id);
//        System.out.println(homeDataService.querySingleHomeDataAndCommodity(1));
//        return null;
//    };
}

