package com.foreground.controller;

import com.foreground.entity.Accessories;
import com.foreground.service.AccessoriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/accessories")
public class AccessoriesController {
    @Autowired
    private AccessoriesService accessoriesService;


   @RequestMapping("/query")
    public List<Accessories> query(){
        return accessoriesService.queryAllAccessoriesAndCommodity();
    }
}