package com.foreground.dao;

import com.foreground.entity.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface UserDao {
    @Select("select * from user where userName = #{userName} and userPassword = #{userPassword}")
    User userLogin(@Param("userName")String userName,@Param("userPassword")String userPassword);

    @Select("select * from user where userName = #{userName}")
    User userRegister1(@Param("userName")String userName);


    @Insert("insert into user(userName,userPassword) values(#{userName},#{userPassword})")
    Integer userRegister2(@Param("userName")String userName,@Param("userPassword")String userPassword);

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
