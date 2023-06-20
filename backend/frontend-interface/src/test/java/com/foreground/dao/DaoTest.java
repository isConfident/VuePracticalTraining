package com.foreground.dao;

import com.foreground.config.SpringConfig;
import com.foreground.entity.Accessories;
import com.foreground.entity.News;
import com.foreground.service.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringConfig.class)
public class DaoTest {
    @Autowired
    private NewsService newsService;
    @Autowired
    private AccessoriesService accessoriesService;
    @Autowired
    private CommodityService commodityService;
    @Autowired
    private HomeDataService homeDataService;
    @Autowired
    private ImagesService imagesService;
    @Autowired
    private PhoneService phoneService;
    @Autowired
    private SwiperService swiperService;
    @Autowired
    private UserService userService;

    public DaoTest() {
    }


    @Test
    public void test() {

//        System.out.println(newsService.getAllNews());
//        System.out.println(accessoriesService.queryAllAccessoriesAndCommodity());
//        System.out.println(commodityService.getAllCommodity());
//        System.out.println(homeDataService.getAllHomeData());
//        System.out.println(imagesService.getAllImages());
//        System.out.println(phoneService.getAllPhone());
//        System.out.println(swiperService.getAllSwiper());
//        System.out.println(homeDataService.queryAllHomeDataAndCommodity());
//        System.out.println(phoneService.queryAllPhoneAndCommodity());
//        System.out.println(accessoriesService.queryAllAccessoriesAndCommodity());
//        System.out.println(commodityService.queryAllCommodityAndSwiperAndImages());
//        System.out.println( userService.userLogin("xiaohu","222222"));
        System.out.println(userService.userRegister("cccccc","777777"));


    }


}
