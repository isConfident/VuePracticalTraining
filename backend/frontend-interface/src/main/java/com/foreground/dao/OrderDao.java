package com.foreground.dao;

import com.foreground.entity.Order;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface OrderDao {

    @Insert("insert into order_user values(null,#{img_url},#{name},#{content},#{bright},#{title},#{price},#{value},#{invoice},#{user_id},#{shopping_id},#{address_id},#{order_date},#{order_comment},#{paymentType})")
    public Integer addSimpleOrder(Order order);

    @Select("select * from order_user where user_id = #{user_id}")
    public List<Order> queryAllOrderByUserId(Order order);

    @Delete("delete from order_user where user_id = #{user_id} and shopping_id = #{shopping_id}")
    public Integer delSimpleOrderByUserId(Order order);
}
