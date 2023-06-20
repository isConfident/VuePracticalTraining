package com.foreground.service.serviceImpl;

import com.foreground.dao.AccessoriesDao;
import com.foreground.entity.Accessories;
import com.foreground.entity.Commodity;
import com.foreground.service.AccessoriesService;
import com.foreground.service.CommodityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("accessoriesService")
public class AccessoriesServiceImpl implements AccessoriesService {
    @Resource
    @Qualifier
    private AccessoriesDao accessoriesDao;

    @Override
    public List<Accessories> queryAllAccessoriesAndCommodity() {
        List<Accessories> accessoriesList=accessoriesDao.queryAllAccessoriesAndCommodity();
        for (int i = 1; i <accessoriesList.size() ; i++) {
            for (int j = 0; j <accessoriesList.get(i).getData().size() ; j++) {
                accessoriesList.get(0).getData().add(accessoriesList.get(i).getData().get(j));
            }
        }
        return accessoriesList;
    }
}
