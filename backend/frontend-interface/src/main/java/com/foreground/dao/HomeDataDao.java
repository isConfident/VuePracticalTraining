package com.foreground.dao;

import com.foreground.entity.HomeData;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface HomeDataDao {
    List<HomeData> getAllHomeData();
}
