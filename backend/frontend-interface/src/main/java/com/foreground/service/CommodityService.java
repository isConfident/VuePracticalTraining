package com.foreground.service;

import com.foreground.entity.Commodity;
import com.foreground.entity.HomeData;

import java.util.List;

public interface CommodityService {
//    List<Commodity> getAllCommodity();

    List<Commodity> queryAllCommodityAndSwiperAndImages();
}
