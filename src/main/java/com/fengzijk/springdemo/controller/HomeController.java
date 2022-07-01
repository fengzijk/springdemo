/*
 *   All rights Reserved, Designed By ZTE-ITS
 *   Copyright:    Copyright(C) 2019-2025
 *   Company       FENGZIJK LTD.
 *   @Author:    fengzijk
 *   @Email: guozhifengvip@163.com
 *   @Version    V1.0
 *   @Date:   2022年06月22日 21时31分
 *   Modification       History:
 *   ------------------------------------------------------------------------------------
 *   Date                  Author        Version        Description
 *   -----------------------------------------------------------------------------------
 *  2022-06-22 21:31:04    fengzijk         1.0         Why & What is modified: <修改原因描述>
 *
 *
 */

package com.fengzijk.springdemo.controller;

import com.fengzijk.springdemo.config.model.ResponseEntity;
import com.fengzijk.springdemo.config.redis.RedisQueueHandle;
import com.fengzijk.springdemo.config.redis.RedisUtil;
import com.fengzijk.springdemo.config.redis.RedissonLockUtil;
import com.fengzijk.springdemo.entity.IpWhiteListEntity;
import com.fengzijk.springdemo.entity.ShortParamEntity;
import com.fengzijk.springdemo.entity.dto.ShortParamDTO;
import com.fengzijk.springdemo.event.UnLockRedissonEvent;
import com.fengzijk.springdemo.mapper.IpWhiteListMapper;
import com.fengzijk.springdemo.service.IShortParamService;
import com.fengzijk.springdemo.service.IpWhiteListService;
import com.fengzijk.springdemo.util.JsonUtil;
import com.fengzijk.springdemo.util.modelmapper.ModelMapperUtil;
import java.time.LocalDateTime;
import java.util.EventListener;
import java.util.List;
import java.util.concurrent.TimeUnit;
import lombok.extern.slf4j.Slf4j;
import org.redisson.api.RLock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/")
@Slf4j
public class HomeController {

    @Autowired
    IpWhiteListService whiteListService;
    @Autowired
    private RedisUtil redisUtil;
    @Autowired
    private IShortParamService shortParamService;

    @Autowired
    private RedisQueueHandle redisQueueHandle;

    @Autowired
    private ApplicationEventPublisher eventPublisher;

    @Autowired
    private IpWhiteListMapper  listMapper;



    /**
     * index
     */
    @GetMapping("/index")
    public ResponseEntity<List<IpWhiteListEntity>> index() {


        List<IpWhiteListEntity> lists = whiteListService.get();
        RedissonLockUtil.lock("gzf", TimeUnit.SECONDS, 100);

        redisQueueHandle.put("gzf", "test");
        return new ResponseEntity<List<IpWhiteListEntity>>().ok().setdata(lists);
    }

    /**
     * index
     */
    @GetMapping("/test/{param}")
    public ResponseEntity<ShortParamDTO> testShort(@PathVariable(value = "param") String param) {
        ShortParamEntity param1 = shortParamService.longToShort("param", param);
        param1.setOriginalParam(null);
        ShortParamDTO map = ModelMapperUtil.map(param1, ShortParamDTO.class);
        return new ResponseEntity<ShortParamDTO>().ok().setdata(map);
    }

    /**
     * index
     */
    @GetMapping("/get")
    public ResponseEntity<List<IpWhiteListEntity>> save() {

        whiteListService.selectone();
        IpWhiteListEntity listEntity2 =  listMapper.selectByxxId(25L);
        log.info("listEntity2================:{}", JsonUtil.tojson(listEntity2));
        return new ResponseEntity<List<IpWhiteListEntity>>().ok().setdata(null);
    }


    /**
     * index
     */
    @GetMapping("/save1/{id}")

    public ResponseEntity<List<IpWhiteListEntity>> save1(@PathVariable(value = "id") String id) {



        IpWhiteListEntity ipWhiteListEntity = new IpWhiteListEntity();
        ipWhiteListEntity.setType("235");
        ipWhiteListEntity.setId(25L);
        ipWhiteListEntity.setState(false);
        ipWhiteListEntity.setStartIp(id);
        ipWhiteListEntity.setEndIp("11111");
        ipWhiteListEntity.setCreateId(0L);
        ipWhiteListEntity.setUpdateId(0L);
        ipWhiteListEntity.setCreateTime(LocalDateTime.now());
        ipWhiteListEntity.setUpdateTime(LocalDateTime.now());
        whiteListService.updateById(ipWhiteListEntity);

        return new ResponseEntity<List<IpWhiteListEntity>>().ok().setdata(null);
    }
}
