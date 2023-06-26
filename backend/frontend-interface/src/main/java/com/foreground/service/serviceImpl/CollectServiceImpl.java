package com.foreground.service.serviceImpl;

import com.foreground.dao.CollectDao;
import com.foreground.entity.Collect;
import com.foreground.service.CollectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CollectServiceImpl implements CollectService {
    @Autowired
    private CollectDao collectDao;
    @Override
    public Integer addSingleCollect(Collect collect) {
        if(isCollect(isCollect(collect)) != null){
            return 0;
        }
        return collectDao.addSingleCollect(collect);
    }

    @Override
    public Collect isCollect(Collect collect) {
        return collectDao.isCollect(collect);
    }

    @Override
    public List<Collect> queryAllCollectByUserId(Collect collect) {
        return collectDao.queryAllCollectByUserId(collect);
    }
}
