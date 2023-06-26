package com.foreground.dao;

import com.foreground.entity.Collect;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface CollectDao {
    @Insert("insert into collect values(null,#{img_url},#{name},#{content},#{bright},#{title},#{price},#{value},#{user_id},#{shopping_id})")
    public Integer addSingleCollect(Collect collect);

    @Select("select * from collect where shopping_id = #{shopping_id}")
    public Collect isCollect(Collect collect);

    @Select("select * from collect where user_id = #{user_id}")
    public List<Collect> queryAllCollectByUserId(Collect collect);

    @Delete("delete from collect where user_id = #{user_id} and shopping_id = #{shopping_id}")
    public Integer delSingleCollectByUserIdAndShoppingId(Collect collect);
}
