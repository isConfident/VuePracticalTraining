package com.foreground.service.serviceImpl;

import com.foreground.dao.HomeDataDao;
import com.foreground.dao.PhoneDao;
import com.foreground.entity.Accessories;
import com.foreground.entity.Commodity;
import com.foreground.entity.Phone;
import com.foreground.service.CommodityService;
import com.foreground.service.PhoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("phoneService")
public class PhoneServiceImpl implements PhoneService {
    @Resource
    @Qualifier
    private PhoneDao phoneDao;
    @Autowired
    private CommodityService commodityService;

    @Override
    public List<Phone> getAllPhone() {

        List< Phone> phoneList=this.phoneDao.getAllPhone();
        List<Commodity> commodityList=this.commodityService.getAllCommodity();
        for (int i = 0; i < phoneList.size(); i++) {
            for (int j = 0; j <commodityList.size() ; j++) {
                if (phoneList.get(i).getId()==commodityList.get(j).getNameId()){
                    phoneList.get(i).getData().add(commodityList.get(j));
                }
            }
        }
        return phoneList;
    }
}
