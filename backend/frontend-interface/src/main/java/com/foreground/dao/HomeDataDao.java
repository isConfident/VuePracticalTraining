package com.foreground.dao;

import com.foreground.entity.HomeData;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface HomeDataDao {
    List<HomeData> getAllHomeData();

    @Select("select * from homedata")
    @Results({
            @Result(column = "id",property = "id"),
            @Result(column = "title",property = "title"),
            @Result(column = "id",property = "data",javaType = List.class,
            many = @Many(select = "com.foreground.dao.CommodityDao.queryAllCommodityByTitleId")),

    })
    List<HomeData> queryAllHomeDataAndCommodity();
}
