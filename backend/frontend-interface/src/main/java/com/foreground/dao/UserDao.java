package com.foreground.dao;

import com.foreground.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UserDao {
    @Select("select * from user where userName = #{userName} and userPassword = #{userPassword}")
    User userLogin(@Param("userName")String userName,@Param("userPassword")String userPassword);

    @Select("select * from user where userName = #{userName}")
    User userRegister1(@Param("userName")String userName);


    @Insert("insert into user(userName,userPassword) values(#{userName},#{userPassword})")
    Integer userRegister2(@Param("userName")String userName,@Param("userPassword")String userPassword);
}
