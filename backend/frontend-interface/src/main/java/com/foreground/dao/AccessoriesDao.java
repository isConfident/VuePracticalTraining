package com.foreground.dao;

import com.foreground.entity.Accessories;
import com.foreground.entity.Commodity;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface AccessoriesDao {
    @Select("select * from accessories")
    @Results({
            @Result(column = "id", property = "id"),
            @Result(column = "name", property = "name"),
            @Result(column = "id", property = "commodity",javaType = List.class,
                    many=@Many(select = "com.foreground.dao.CommodityDao.getAllCommodity"))
    })
    List<Accessories> queryAllAccessoriesAndCommodity();
}
