package com.foreground.service.serviceImpl;

import com.foreground.dao.NewsDao;
import com.foreground.entity.News;

import com.foreground.service.NewsService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;


@Service("newsService")
public class NewsServiceImpl implements NewsService {
    @Resource
    @Qualifier
    private NewsDao newsDao;


    @Override
    public List<News> getAllNews() {
        return this.newsDao.getAllNews();
    }
}
