package com.foreground.dao;

import com.foreground.entity.HomePeiZhi;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface HomePeiZhiDao {
    List<HomePeiZhi> getAllHomePeiZhi();

    @Select("select * from homepeizhi where commodityId = #{id}")
    List<HomePeiZhi> queryAllHomePeiZhiById(@Param("id") Integer commodityId);
}
