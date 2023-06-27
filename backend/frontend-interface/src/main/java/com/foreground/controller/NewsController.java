package com.foreground.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.foreground.entity.News;
import com.foreground.service.NewsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/news")
@Api(tags = "新闻接口")
public class NewsController {

    @Autowired
//    @Qualifier("newsService")
    private NewsService newsService;

    @RequestMapping( "/query")
    @ApiOperation(value = "查询所有新闻")
    private List<News> query() {
        return newsService.getAllNews();
    }

//    @RequestMapping("/get")
//    public void getJson(@RequestBody String json) throws IOException {
//        ObjectMapper objectMapper = new ObjectMapper();
//        News news = objectMapper.readValue(json, News.class);
//
//    }


}
