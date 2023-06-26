package com.foreground.dao;

import com.foreground.entity.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface UserDao {


    @Select("select * from user where userName = #{userName}")
    public User isUsername(User user);

    @Select("select * from user where userName = #{userName} and userPassword = #{userPassword}")
    public User isPassword(User user);

    @Select("select * from user where id = #{id}")
    @Results({
            @Result(column = "id",property = "id"),
            @Result(column = "userName",property = "userName"),
            @Result(column = "userPassword",property = "userPassword"),
            @Result(column = "id",property = "addressUsersList",javaType = List.class,
            many=@Many(select = "com.foreground.dao.AddressUsersDao.queryAllAddressUsersByUserId")),
            @Result(column = "id",property = "shoppingCartsList",javaType = List.class,
            many=@Many(select = "com.foreground.dao.ShoppingCartsDao.queryAllShoppingCartsByUserId"))
    })
    public User querySimpleUserAndAddressesAndShoppingCartsById(@Param("id") Integer id);
}
