package com.foreground.controller;

import com.foreground.entity.Accessories;
import com.foreground.service.AccessoriesService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/accessories")
@Api(tags = "配件商品接口")
public class AccessoriesController {
    @Autowired
    private AccessoriesService accessoriesService;


   @RequestMapping("/query")
   @ApiOperation(value = "查询所有配件商品")
    public List<Accessories> query(){
        return accessoriesService.queryAllAccessoriesAndCommodity();
    }
}