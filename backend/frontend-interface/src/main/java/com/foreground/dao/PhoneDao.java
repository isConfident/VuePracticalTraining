package com.foreground.dao;

import com.foreground.entity.Phone;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface PhoneDao {
    List<Phone> getAllPhone();

    @Select("select * from phone")
    @Results({
            @Result(column = "id", property = "id"),
            @Result(column = "name", property = "name"),
            @Result(column = "id", property = "data",javaType = List.class,
                    many=@Many(select = "com.foreground.dao.CommodityDao.queryAllCommodityByNameIdAndPhone"))
    })
    List<Phone> queryAllPhoneAndCommodity();


}
