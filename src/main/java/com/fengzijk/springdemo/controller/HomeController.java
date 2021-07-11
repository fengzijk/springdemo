package com.fengzijk.springdemo.controller;

import com.fengzijk.springdemo.config.model.ResponseEntity;
import com.fengzijk.springdemo.config.redis.RedisQueueHandle;
import com.fengzijk.springdemo.config.redis.RedisUtil;
import com.fengzijk.springdemo.config.redis.RedissonLockUtil;
import com.fengzijk.springdemo.entity.IpWhiteList;
import com.fengzijk.springdemo.service.IpWhiteListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping(value = "/")
public class HomeController {

    @Autowired
    private RedisUtil redisUtil;

    @Autowired
    IpWhiteListService whiteListService;

    @Autowired
    private RedisQueueHandle redisQueueHandle;

    /**
     * index
     */
    @GetMapping("/index")
    public ResponseEntity<String> index() {
        redisUtil.set("xxx", "hhhhhhhhhhhhh");

        List<IpWhiteList> lists = whiteListService.get();
        RedissonLockUtil.lock("gzf", TimeUnit.SECONDS, 100);

        redisQueueHandle.put("gzf", "test");
        System.out.println(1111);
        RedissonLockUtil.unlock("gzf");
        return new ResponseEntity<String>().ok().setdata("string");
    }

}
