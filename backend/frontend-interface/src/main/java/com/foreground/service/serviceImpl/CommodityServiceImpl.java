package com.foreground.service.serviceImpl;

import com.foreground.dao.*;
import com.foreground.entity.*;
import com.foreground.service.CommodityService;
import com.foreground.service.ImagesService;
import com.foreground.service.SwiperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.awt.*;
import java.util.List;

@Service("commodityService")
public class CommodityServiceImpl implements CommodityService {
    @Resource
    @Qualifier
    private CommodityDao commodityDao;
    @Autowired
    private SwiperService swiperService;
    @Autowired
    private ImagesService imagesService;

    @Override
    public List<Commodity> getAllCommodity() {
        List<Commodity> commodityList=commodityDao.getAllCommodity();
        List<Swiper> swiperList=swiperService.getAllSwiper();
        List<Images> imagesList=imagesService.getAllImages();
        for (int i = 0; i <commodityList.size() ; i++) {
            for (int j = 0; j <swiperList.size() ; j++) {
                if (commodityList.get(i).getId()==swiperList.get(j).getCommodityId()){
                    commodityList.get(i).getSwiper().add(swiperList.get(j));
                }
            }
            for (int j = 0; j <imagesList.size() ; j++) {
                if (commodityList.get(i).getId()==imagesList.get(j).getCommodityId()){
                    commodityList.get(i).getImages().add(imagesList.get(j));
                }
            }
        }
        return commodityList;
    }

    @Override
    public List<Commodity> queryAllCommodityAndSwiperAndImages() {
        return commodityDao.queryAllCommodityAndSwiperAndImages();
    }

    @Override
    public Commodity querySingleCommodityAndSwiperAndImages(Integer id) {
        return commodityDao.querySingleCommodityAndSwiperAndImages(id);
    }
}
