package com.foreground.controller;


import com.foreground.entity.Commodity;
import com.foreground.service.CommodityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/commodity")
public class CommodityController {
    @Autowired
    private CommodityService commodityService;

    @RequestMapping("/query")
    public List<Commodity> query(){
        return commodityService.queryAllCommodityAndSwiperAndImages();
    }
}
