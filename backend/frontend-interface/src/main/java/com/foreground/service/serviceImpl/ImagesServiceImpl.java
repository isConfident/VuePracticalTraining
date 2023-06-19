package com.foreground.service.serviceImpl;

import com.foreground.dao.HomeDataDao;
import com.foreground.dao.ImagesDao;
import com.foreground.entity.Images;
import com.foreground.service.ImagesService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("imagesServiceImpl")
public class ImagesServiceImpl implements ImagesService {
    @Resource
    @Qualifier
    private ImagesDao imagesDao;

    @Override
    public List<Images> getAllImages() {
        return imagesDao.getAllImages();
    }
}
