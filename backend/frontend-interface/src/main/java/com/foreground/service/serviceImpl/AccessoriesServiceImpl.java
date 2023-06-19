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
    @Autowired
    private CommodityService commodityService;

    @Override
    public List<Accessories> getAllAccessories() {
        List<Accessories> accessoriesList = this.accessoriesDao.getAllAccessories();
        List<Commodity> commodityList = this.commodityService.getAllCommodity();
        for (int i = 0; i < accessoriesList.size(); i++) {
            for (int j = 0; j < commodityList.size(); j++) {
                if (accessoriesList.get(i).getId() == commodityList.get(j).getNameId()) {
                    accessoriesList.get(i).getData().add(commodityList.get(j));
                }
            }
        }
        return accessoriesList;
    }
}
