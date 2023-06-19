package com.foreground.dao;

import com.foreground.entity.Images;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ImagesDao {
    List<Images> getAllImages();

    @Select("select * from images where commodityId = #{id}")
    List<Images> queryAllImagesById(@Param("id") Integer commodityId);
}
