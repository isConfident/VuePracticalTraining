package com.foreground.dao;

import com.foreground.entity.Swiper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface SwiperDao {
    List<Swiper> getAllSwiper();

    @Select("select * from swiper where commodityId = #{id}")
    List<Swiper> queryAllSwipersById(@Param("id") Integer commodityId);
}
