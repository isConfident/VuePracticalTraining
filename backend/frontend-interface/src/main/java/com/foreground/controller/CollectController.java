package com.foreground.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.foreground.entity.Collect;
import com.foreground.entity.Result;
import com.foreground.service.CollectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/collect")
public class CollectController {
    @Autowired
    private CollectService collectService;
    private final ObjectMapper objectMapper = new ObjectMapper();
    private final Result result = new Result();

    @PostMapping("/addSingleCollect")
    public Result addSingleCollect(@RequestBody String _collect) throws IOException {
        Collect collect = objectMapper.readValue(_collect, Collect.class);
        Integer count = collectService.addSingleCollect(collect);
        if (count > 0) {
            result.setMsgAndData("收藏成功", count);
        } else {
            result.setMsgAndData("该商品已经收藏过了", count);
        }
        return result;
    }


    @PostMapping("/queryAllCollect")
    public List<Collect> queryAllCollectByUserId(@RequestBody String _collect) throws IOException {
        return collectService.queryAllCollectByUserId(objectMapper.readValue(_collect,Collect.class));
    }
}
