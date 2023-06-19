package com.foreground.controller;

import com.foreground.entity.News;
import com.foreground.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/news")
public class NewsController {

    @Autowired
    @Qualifier("newsService")
    private NewsService newsService;

    @GetMapping( "/getAllNews")
    private List<News> getAllNews() {
        return newsService.getAllNews();
    }
}
