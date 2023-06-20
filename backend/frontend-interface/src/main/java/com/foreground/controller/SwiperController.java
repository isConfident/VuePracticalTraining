package com.foreground.controller;


import com.foreground.entity.Swiper;
import com.foreground.service.SwiperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/swiper")
public class SwiperController {
    @Autowired
    private SwiperService swiperService;

    @RequestMapping("/query")
    public List<Swiper> query(){ return swiperService.getAllSwiper();}
}
