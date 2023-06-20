package com.foreground.controller;


import com.foreground.entity.Images;
import com.foreground.service.ImagesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/images")
public class ImagesController {
    @Autowired
    private ImagesService imagesService;

    @RequestMapping("/query")
    public List<Images> query(){ return imagesService.getAllImages(); }
}
