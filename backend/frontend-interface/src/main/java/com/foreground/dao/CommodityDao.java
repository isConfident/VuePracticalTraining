package com.foreground.dao;

import com.foreground.entity.Commodity;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface CommodityDao {
    List<Commodity> getAllCommodity();

    @Select("select * from commodity where titleId = #{titleId}")
    @Results({
            @Result(column = "id", property = "id"),
            @Result(column = "titleId", property = "titleId"),
            @Result(column = "nameId", property = "nameId"),
            @Result(column = "type", property = "type"),
            @Result(column = "img_url", property = "img_url"),
            @Result(column = "name", property = "name"),
            @Result(column = "content", property = "content"),
            @Result(column = "bright", property = "bright"),
            @Result(column = "title", property = "title"),
            @Result(column = "price", property = "price"),
            @Result(column = "value", property = "value"),
            @Result(column = "id", property = "swiper", javaType = List.class,
                    many = @Many(select = "com.foreground.dao.SwiperDao.queryAllSwipersById")),
            @Result(column = "id", property = "images", javaType = List.class,
                    many = @Many(select = "com.foreground.dao.ImagesDao.queryAllImagesById")),
            @Result(column = "id", property = "homePeiZhi", javaType = List.class,
                    many = @Many(select = "com.foreground.dao.HomePeiZhiDao.queryAllHomePeiZhiById"))
    })
    List<Commodity> queryAllCommodityByTitleId(@Param("titleId") Integer titleId);

    @Select("select * from commodity where nameId = #{nameId} and type = 'phone'")
    @Results({
            @Result(column = "id", property = "id"),
            @Result(column = "titleId", property = "titleId"),
            @Result(column = "nameId", property = "nameId"),
            @Result(column = "type", property = "type"),
            @Result(column = "img_url", property = "img_url"),
            @Result(column = "name", property = "name"),
            @Result(column = "content", property = "content"),
            @Result(column = "bright", property = "bright"),
            @Result(column = "title", property = "title"),
            @Result(column = "price", property = "price"),
            @Result(column = "value", property = "value"),
            @Result(column = "id", property = "swiper", javaType = List.class,
                    many = @Many(select = "com.foreground.dao.SwiperDao.queryAllSwipersById")),
            @Result(column = "id", property = "images", javaType = List.class,
                    many = @Many(select = "com.foreground.dao.ImagesDao.queryAllImagesById")),
            @Result(column = "id", property = "homePeiZhi", javaType = List.class,
                    many = @Many(select = "com.foreground.dao.HomePeiZhiDao.queryAllHomePeiZhiById"))
    })
    List<Commodity> queryAllCommodityByNameIdAndPhone(@Param("nameId") Integer nameId);

    @Select("select * from commodity where nameId = #{nameId} and type = 'accessories'")
    @Results({
            @Result(column = "id", property = "id"),
            @Result(column = "titleId", property = "titleId"),
            @Result(column = "nameId", property = "nameId"),
            @Result(column = "type", property = "type"),
            @Result(column = "img_url", property = "img_url"),
            @Result(column = "name", property = "name"),
            @Result(column = "content", property = "content"),
            @Result(column = "bright", property = "bright"),
            @Result(column = "title", property = "title"),
            @Result(column = "price", property = "price"),
            @Result(column = "value", property = "value"),
            @Result(column = "id", property = "swiper", javaType = List.class,
                    many = @Many(select = "com.foreground.dao.SwiperDao.queryAllSwipersById")),
            @Result(column = "id", property = "images", javaType = List.class,
                    many = @Many(select = "com.foreground.dao.ImagesDao.queryAllImagesById")),
            @Result(column = "id", property = "homePeiZhi", javaType = List.class,
                    many = @Many(select = "com.foreground.dao.HomePeiZhiDao.queryAllHomePeiZhiById"))
    })
    List<Commodity> queryAllCommodityByNameIdAndAccessories(@Param("nameId") Integer nameId);

    @Select("select * from commodity")
    @Results({
            @Result(column = "id", property = "id"),
            @Result(column = "titleId", property = "titleId"),
            @Result(column = "nameId", property = "nameId"),
            @Result(column = "type", property = "type"),
            @Result(column = "img_url", property = "img_url"),
            @Result(column = "name", property = "name"),
            @Result(column = "content", property = "content"),
            @Result(column = "bright", property = "bright"),
            @Result(column = "title", property = "title"),
            @Result(column = "price", property = "price"),
            @Result(column = "value", property = "value"),
            @Result(column = "id", property = "swiper", javaType = List.class,
                    many = @Many(select = "com.foreground.dao.SwiperDao.queryAllSwipersById")),
            @Result(column = "id", property = "images", javaType = List.class,
                    many = @Many(select = "com.foreground.dao.ImagesDao.queryAllImagesById")),
            @Result(column = "id", property = "homePeiZhi", javaType = List.class,
                    many = @Many(select = "com.foreground.dao.HomePeiZhiDao.queryAllHomePeiZhiById"))
    })
    List<Commodity> queryAllCommodityAndSwiperAndImages();


    @Select("select * from commodity where id = #{id}")
    @Results({
            @Result(column = "id", property = "id"),
            @Result(column = "titleId", property = "titleId"),
            @Result(column = "nameId", property = "nameId"),
            @Result(column = "type", property = "type"),
            @Result(column = "img_url", property = "img_url"),
            @Result(column = "name", property = "name"),
            @Result(column = "content", property = "content"),
            @Result(column = "bright", property = "bright"),
            @Result(column = "title", property = "title"),
            @Result(column = "price", property = "price"),
            @Result(column = "value", property = "value"),
            @Result(column = "id", property = "swiper", javaType = List.class,
                    many = @Many(select = "com.foreground.dao.SwiperDao.queryAllSwipersById")),
            @Result(column = "id", property = "images", javaType = List.class,
                    many = @Many(select = "com.foreground.dao.ImagesDao.queryAllImagesById")),
            @Result(column = "id", property = "homePeiZhi", javaType = List.class,
                    many = @Many(select = "com.foreground.dao.HomePeiZhiDao.queryAllHomePeiZhiById"))
    })
    Commodity querySingleCommodityAndSwiperAndImages(Integer id);
}
