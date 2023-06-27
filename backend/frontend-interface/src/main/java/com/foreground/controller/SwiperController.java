package com.foreground.controller;


import com.foreground.entity.Swiper;
import com.foreground.service.SwiperService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/swiper")
@Api(tags = "商品轮播图接口")
public class SwiperController {
    @Autowired
    private SwiperService swiperService;

    @RequestMapping("/query")
    @ApiOperation(value = "查询所有商品轮播图")
    public List<Swiper> query(){ return swiperService.getAllSwiper();}
}
