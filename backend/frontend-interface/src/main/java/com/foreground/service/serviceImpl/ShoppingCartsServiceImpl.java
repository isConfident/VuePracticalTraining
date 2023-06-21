package com.foreground.service.serviceImpl;

import com.foreground.dao.ShoppingCartsDao;
import com.foreground.entity.ShoppingCarts;
import com.foreground.service.ShoppingCartsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ShoppingCartsServiceImpl implements ShoppingCartsService {
    @Autowired
    private ShoppingCartsDao shoppingCartsDao;
    @Override
    public List<ShoppingCarts> queryAllShoppingCartsByUserId(Integer id) {
        return shoppingCartsDao.queryAllShoppingCartsByUserId(id);
    }
}
