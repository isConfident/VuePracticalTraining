package com.foreground.controller;

import com.foreground.entity.HomeData;
import com.foreground.service.HomeDataService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/homeData")
@Api(tags = "主页商品接口")
public class HomeDataController {
    @Autowired
    private HomeDataService homeDataService;

    @GetMapping("/query")
    @ApiOperation(value = "查询所有主页商品")
    public List<HomeData> query(){ return homeDataService.queryAllHomeDataAndCommodity(); }

//    @GetMapping("/singleQuery")
//    List<HomeData> querySingleHomeDataAndCommodity(@RequestParam("id") Integer id){
//        System.out.println(id);
//        System.out.println(homeDataService.querySingleHomeDataAndCommodity(1));
//        return null;
//    };
}

