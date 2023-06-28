package com.foreground.controller;


import com.foreground.entity.Commodity;
import com.foreground.service.CommodityService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/commodity")
@Api(tags = "商品信息接口")
public class CommodityController {
    @Autowired
    private CommodityService commodityService;

    @RequestMapping("/query")
    @ApiOperation(value = "查询所有商品信息")
    public List<Commodity> query(){
        return commodityService.queryAllCommodityAndSwiperAndImages();
    }

    @GetMapping("/singleQuery")
    @ApiOperation(value = "查询商品对应的轮播图和详情图")
    public Commodity querySingleCommodityAndSwiperAndImages(@RequestParam("id") Integer id){
        return commodityService.querySingleCommodityAndSwiperAndImages(id);
    };
}
