package com.foreground.dao;

import com.foreground.entity.ShoppingCarts;
import org.apache.ibatis.annotations.*;

import java.util.List;
@Mapper
public interface ShoppingCartsDao {
    @Select("select * from shopping_carts where user_id = #{id}")
    public List<ShoppingCarts> queryAllShoppingCartsByUserId(@Param("id") Integer id);

    @Delete("delete from shopping_carts where user_id = #{user_id} and shopping_id = #{shopping_id}")
    public Integer delSimpleShoppingCarts(@Param("user_id")Integer userId,@Param("shopping_id") Integer shopping_id);

    @Insert("insert into shopping_carts values(null,#{img_url},#{name},#{content},#{bright},#{title},#{price},#{value},#{user_id},#{shopping_id})")
    public Integer addSimpleShoppingCarts(ShoppingCarts shoppingCarts);

    @Select("select * from shopping_carts where user_id = #{user_id} and shopping_id = #{shopping_id}")
    public ShoppingCarts isRepetitionAddShoppingCarts(ShoppingCarts shoppingCarts);

    @Update("update shopping_carts set value = value + #{value} where shopping_id = #{shopping_id} and user_id = #{user_id}")
    public Integer updateShoppingCartsValue(ShoppingCarts shoppingCarts);

    @Select("select count(*) from shopping_carts where user_id = #{user_id}")
    public Integer queryShoppingCartsCount(ShoppingCarts shoppingCarts);
}
