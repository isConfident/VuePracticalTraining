package com.foreground.dao;

import com.foreground.entity.News;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface NewsDao {
    List<News> getAllNews();
}
