package com.foreground.dao;

import com.foreground.entity.Swiper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SwiperDao {
    List<Swiper> getAllSwiper();
}
