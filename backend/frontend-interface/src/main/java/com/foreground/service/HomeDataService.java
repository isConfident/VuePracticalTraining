package com.foreground.service;

import com.foreground.entity.HomeData;

import java.util.List;

public interface HomeDataService {
//    List<HomeData> getAllHomeData();
    List<HomeData> queryAllHomeDataAndCommodity();

    List<HomeData> querySingleHomeDataAndCommodity(Integer id);
}
