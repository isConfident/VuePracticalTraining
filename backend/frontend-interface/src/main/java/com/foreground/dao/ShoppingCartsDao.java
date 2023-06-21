package com.foreground.dao;

import com.foreground.entity.ShoppingCarts;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface ShoppingCartsDao {
    @Select("select * from shopping_carts where user_id = #{id}")
    public List<ShoppingCarts> queryAllShoppingCartsByUserId(@Param("id") Integer id);
}
