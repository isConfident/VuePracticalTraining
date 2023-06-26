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

    @Override
    public Integer delSimpleShoppingCarts(Integer userId, Integer shopping_id) {
        return shoppingCartsDao.delSimpleShoppingCarts(userId, shopping_id);
    }

    @Override
    public Integer addSimpleShoppingCarts(ShoppingCarts shoppingCarts) {
        ShoppingCarts carts = shoppingCartsDao.isRepetitionAddShoppingCarts(shoppingCarts);
        if(carts != null){
            shoppingCartsDao.updateShoppingCartsValue(shoppingCarts);
            return 1;
        }
        return shoppingCartsDao.addSimpleShoppingCarts(shoppingCarts);
    }

    @Override
    public Integer queryShoppingCartsCount(ShoppingCarts shoppingCarts) {
        return shoppingCartsDao.queryShoppingCartsCount(shoppingCarts);
    }
}
