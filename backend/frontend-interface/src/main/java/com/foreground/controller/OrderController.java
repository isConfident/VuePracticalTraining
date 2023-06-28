package com.foreground.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.foreground.entity.Order;
import com.foreground.entity.Result;
import com.foreground.service.OrderService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.ClassGenerator;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/order")
@Api(tags = "用户订单接口")
public class OrderController {
    @Autowired
    public OrderService orderService;
    private final ObjectMapper objectMapper = new ObjectMapper();
    private final Result result = new Result();

    @PostMapping("/addSimpleOrder")
    @ApiOperation(value = "添加用户订单")
    public Result addSimpleOrder(@RequestBody String _order) throws IOException {
        Order order = objectMapper.readValue(_order, Order.class);
        Integer count = orderService.addSimpleOrder(order);
        if(count > 0){

            result.setMsgAndData("提交成功",count);
        }else{
            result.setMsgAndData("提交失败",count);
        }
        return result;
    };

    @PostMapping("/queryAllOrderByUserId")
    @ApiOperation(value = "查询用户订单")
    public Result queryAllOrderByUserId(@RequestBody String _order) throws IOException {
        Order order = objectMapper.readValue(_order, Order.class);
        List<Order> orders = orderService.queryAllOrderByUserId(order);
        if(orders.isEmpty()){
            result.setMsgAndData("您还没有订单哦~",order);
        }else{
            result.setMsgAndData("查询成功",orders);
        }
        return result;
    };

    @PostMapping("/delSimpleOrderByUserId")
    @ApiOperation(value = "删除用户订单")
    public Result delSimpleOrderByUserId(@RequestBody String _order) throws IOException {
        Order order = objectMapper.readValue(_order, Order.class);
        Integer flag = orderService.delSimpleOrderByUserId(order);
        if(flag > 0){
            result.setMsgAndData("删除成功",flag);
        }else{
            result.setMsgAndData("删除失败",flag);
        }
        return result;
    };
}
