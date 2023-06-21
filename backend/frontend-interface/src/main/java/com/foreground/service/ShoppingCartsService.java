package com.foreground.service;

import com.foreground.entity.ShoppingCarts;

import java.util.List;

public interface ShoppingCartsService {
    public List<ShoppingCarts> queryAllShoppingCartsByUserId(Integer id);
}
