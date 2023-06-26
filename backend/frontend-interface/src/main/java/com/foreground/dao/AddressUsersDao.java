package com.foreground.dao;

import com.foreground.entity.AddressUsers;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AddressUsersDao {
    @Select("select * from address_users where user_id = #{id}")
    public List<AddressUsers> queryAllAddressUsersByUserId(@Param("id") Integer id);
}
