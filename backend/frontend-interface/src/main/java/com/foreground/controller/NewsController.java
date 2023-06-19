package com.foreground.controller;

import com.foreground.entity.News;
import com.foreground.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/news")
public class NewsController {

    @Autowired
    @Qualifier("newsService")
    private NewsService newsService;

    @RequestMapping("/getAllNews")
    private List<News> getAllNews(Model model) {
        model.addAttribute("news",newsService.getAllNews());
        return this.newsService.getAllNews();

    }
}
