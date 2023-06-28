package com.foreground.controller;


import com.foreground.entity.Images;
import com.foreground.service.ImagesService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/images")
@Api(tags = "商品详情图接口")
public class ImagesController {
    @Autowired
    private ImagesService imagesService;


    @RequestMapping("/query")
    @ApiOperation(value = "查询所有商品详情图")
    public List<Images> query(){ return imagesService.getAllImages(); }
}
