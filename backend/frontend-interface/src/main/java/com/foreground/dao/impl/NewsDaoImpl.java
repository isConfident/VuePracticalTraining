package com.foreground.dao.impl;

import com.foreground.dao.NewsDao;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class NewsDaoImpl implements NewsDao {
    @Autowired
    private SqlSessionFactory sqlSessionFactory;

}
