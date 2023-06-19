package com.foreground.dao;

import com.foreground.entity.Phone;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PhoneDao {
    List<Phone> getAllPhone();
}
