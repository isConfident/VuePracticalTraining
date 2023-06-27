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

    @Select("select * from user where userName = #{userName}")
    public List<User> isUsernames(User user);

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

    @Insert("insert into user values(null,#{userName},#{userPassword},null,null)")
    public Integer addSingleUser(User user);


    @Update("update user set userName = #{userName},age = #{age},birthday=#{birthday} where id = #{id}")
    public Integer alterSingleUserName(User user);

    @Update("update user set age = #{age},birthday=#{birthday} where id = #{id}")
    public Integer alterSingleUserInfo(User user);

    @Update("update user set userPassword = #{userPassword} where userName = #{userName}")
    public Integer alterUserPassword(User user);
}
