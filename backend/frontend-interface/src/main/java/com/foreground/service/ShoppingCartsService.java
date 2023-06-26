package com.foreground.service;

import com.foreground.entity.ShoppingCarts;

import java.util.List;

public interface ShoppingCartsService {
    public List<ShoppingCarts> queryAllShoppingCartsByUserId(Integer id);
    public Integer delSimpleShoppingCarts(Integer userId,Integer id);

    public Integer addSimpleShoppingCarts(ShoppingCarts shoppingCarts);

    public Integer queryShoppingCartsCount(ShoppingCarts shoppingCarts);
}
