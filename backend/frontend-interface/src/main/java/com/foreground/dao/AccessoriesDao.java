package com.foreground.dao;

import com.foreground.entity.Accessories;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AccessoriesDao {
    List<Accessories> getAllAccessories();
}
