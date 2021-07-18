package com.fengzijk.springdemo.controller;

import com.fengzijk.springdemo.config.model.ResponseEntity;
import com.fengzijk.springdemo.config.redis.RedisQueueHandle;
import com.fengzijk.springdemo.service.IpWhiteListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/mq")
public class MqController {

    @Autowired
    IpWhiteListService whiteListService;

    @Autowired
    private RedisQueueHandle redisQueueHandle;

/*    @Autowired
    private RabbitProviderSender rabbitProviderSender;



    *//**
     * index
     *//*
    @GetMapping("/rabbit")
    public ResponseEntity<String> rabbitTest() {
        String  ss="{gzf:\"1212123\"}";
        rabbitProviderSender.send(ss,null);
        return new ResponseEntity<String>().ok();
    }*/
    /**
     * index
     */
    @GetMapping("/redis/")
    public ResponseEntity<String> index() {


        redisQueueHandle.put("gzf", "test");
        System.out.println(1111);
        return new ResponseEntity<String>().ok();
    }

}
