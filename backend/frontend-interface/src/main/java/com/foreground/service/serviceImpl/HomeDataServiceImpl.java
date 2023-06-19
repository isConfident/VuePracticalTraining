package com.foreground.service.serviceImpl;

import com.foreground.dao.HomeDataDao;
import com.foreground.dao.NewsDao;
import com.foreground.entity.Commodity;
import com.foreground.entity.HomeData;
import com.foreground.service.CommodityService;
import com.foreground.service.HomeDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("homeDataService")
public class HomeDataServiceImpl implements HomeDataService {
    @Resource
    @Qualifier
    private HomeDataDao homeDataDao;
    @Autowired
    private CommodityService commodityService;

    @Override
    public List<HomeData> getAllHomeData() {
        List<HomeData> homeDataList=this.homeDataDao.getAllHomeData();
        List<Commodity> commodityList=this.commodityService.getAllCommodity();
        for (int i = 0; i < homeDataList.size(); i++) {
            for (int j = 0; j <commodityList.size() ; j++) {
                if (homeDataList.get(i).getId()==commodityList.get(j).getTitleId()){
                    homeDataList.get(i).getData().add(commodityList.get(j));
                }
            }
        }
        return homeDataList;
    }
}
