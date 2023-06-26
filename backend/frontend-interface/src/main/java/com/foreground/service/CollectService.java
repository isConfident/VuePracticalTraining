package com.foreground.service;

import com.foreground.entity.Collect;
import org.springframework.stereotype.Service;

import java.util.List;


public interface CollectService {
    public Integer addSingleCollect(Collect collect);

    public Collect isCollect(Collect collect);
    public List<Collect> queryAllCollectByUserId(Collect collect);

    public Integer delSingleCollectByUserIdAndShoppingId(Collect collect);
}
