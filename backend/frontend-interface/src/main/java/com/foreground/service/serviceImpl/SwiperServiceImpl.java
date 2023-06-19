package com.foreground.service.serviceImpl;

import com.foreground.dao.CommodityDao;
import com.foreground.dao.SwiperDao;
import com.foreground.entity.Swiper;
import com.foreground.service.SwiperService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("swiperService")
public class SwiperServiceImpl implements SwiperService {
    @Resource
    @Qualifier
    private SwiperDao swiperDao;

    @Override
    public List<Swiper> getAllSwiper() {
        return swiperDao.getAllSwiper();
    }
}
