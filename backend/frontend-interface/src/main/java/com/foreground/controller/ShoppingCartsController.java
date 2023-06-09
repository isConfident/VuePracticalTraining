package com.foreground.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.foreground.entity.Result;
import com.foreground.entity.ShoppingCarts;
import com.foreground.entity.User;
import com.foreground.service.ShoppingCartsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/shoppingCarts")
@Api(tags = "用户购物车接口")
public class ShoppingCartsController {
    @Autowired
    private ShoppingCartsService shoppingCartsService;
    private final ObjectMapper objectMapper = new ObjectMapper();

    private final Result result = new Result();
    @PostMapping("/queryShoppingCarts")
    @ApiOperation(value = "查询用户所有购物车商品")
    public List<ShoppingCarts> queryAllShoppingCartsByUserId(@RequestBody String _user) throws IOException {
        User user = objectMapper.readValue(_user, User.class);
        return shoppingCartsService.queryAllShoppingCartsByUserId(user.getId());
    }

    @PostMapping("/delShoppingCarts")
    @ApiOperation(value = "删除用户购物车商品")
    public Result delSimpleShoppingCarts(@RequestBody String _shoppingCarts) throws IOException {
        ShoppingCarts shoppingCarts = objectMapper.readValue(_shoppingCarts, ShoppingCarts.class);
        Integer flag = shoppingCartsService.delSimpleShoppingCarts(shoppingCarts.getUser_id(), shoppingCarts.getShopping_id());
        if(flag > 0){
            result.setMsgAndData("删除成功",flag);
        }else{
            result.setMsgAndData("删除失败",flag);
        }
        return result;
    }

    @PostMapping("/addShoppingCarts")
    @ApiOperation(value = "添加用户购物车商品")
    public Result addSimpleShoppingCarts(@RequestBody String _shoppingCarts) throws IOException {
        ShoppingCarts shoppingCarts = objectMapper.readValue(_shoppingCarts, ShoppingCarts.class);
        Integer flag = shoppingCartsService.addSimpleShoppingCarts(shoppingCarts);
        if(flag > 0){
            result.setMsgAndData("添加成功",flag);
        }else{
            result.setMsgAndData("添加失败",flag);
        }
        return result;
    }

    @PostMapping("/queryCount")
    @ApiOperation(value = "添加用户购物车总商品数量")
    public Result queryShoppingCartsCount(@RequestBody String _shoppingCarts) throws IOException {
        ShoppingCarts shoppingCarts = objectMapper.readValue(_shoppingCarts, ShoppingCarts.class);
        Integer count = shoppingCartsService.queryShoppingCartsCount(shoppingCarts);
        result.setMsgAndData("查询成功",count);
        return result;
    }
}
