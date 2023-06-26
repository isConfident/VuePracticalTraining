package com.foreground.dao;

import com.foreground.entity.AddressUsers;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Repository
public interface AddressUsersDao {

    @Select("select * from address_users where id = #{id} and user_id = #{user_id}")
    public AddressUsers querySingleAddressUsersById(AddressUsers addressUsers);
    @Select("select * from address_users where user_id = #{id}")
    public List<AddressUsers> queryAllAddressUsersByUserId(@Param("id") Integer id);
    @Insert("insert into address_users values(null,#{addressDetail},#{areaCode},#{city},#{country},#{county},#{isDefault},#{name},#{postalCode},#{province},#{tel},#{user_id})")
    public Integer addSimpleAddressUsers(AddressUsers addressUsers);

    @Delete("delete from address_users where user_id = #{user_id} and id = #{id}")
    public Integer delSimpleAddressUsers(@Param("user_id") Integer userId,@Param("id") Integer id);

    @Update("update address_users set addressDetail = #{addressDetail},areaCode = #{areaCode},city=#{city},country=#{country},county=#{county},isDefault=#{isDefault},name=#{name},postalCode=#{postalCode},province=#{province},tel=#{tel},user_id=#{user_id} where id = #{id}")
    public Integer alterSimpleAddressUsers(AddressUsers addressUsers);


    @Select("select * from address_users where user_id = #{user_id} and isDefault = #{isDefault}")
    public AddressUsers queryDefaultAddress(AddressUsers addressUsers);
}
