package com.foreground.dao;

import com.foreground.entity.Images;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ImagesDao {
    List<Images> getAllImages();
}
