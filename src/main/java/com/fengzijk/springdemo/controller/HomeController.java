package com.fengzijk.springdemo.controller;

import com.fengzijk.springdemo.config.model.ResponseEntity;
import com.fengzijk.springdemo.config.redis.RedisQueueHandle;
import com.fengzijk.springdemo.config.redis.RedisUtil;
import com.fengzijk.springdemo.config.redis.RedissonLockUtil;
import com.fengzijk.springdemo.pojo.dto.ShortParamDTO;
import com.fengzijk.springdemo.pojo.entity.IpWhiteListEntity;
import com.fengzijk.springdemo.pojo.entity.ShortParamEntity;
import com.fengzijk.springdemo.service.IShortParamService;
import com.fengzijk.springdemo.service.IpWhiteListService;
import com.fengzijk.springdemo.service.impl.AsyncThreadServiceImpl;
import com.fengzijk.springdemo.util.modelmapper.ModelMapperUtil;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/")
public class HomeController {

    @Autowired
    private RedisUtil redisUtil;

    @Autowired
    IpWhiteListService whiteListService;

    @Autowired
    private IShortParamService shortParamService;

    @Autowired
    private RedisQueueHandle redisQueueHandle;

    @Autowired

    private AsyncThreadServiceImpl asyncThreadService;


    /**
     * index
     */
    @GetMapping("/index")
    public ResponseEntity<List<IpWhiteListEntity>> index() {
        redisUtil.set("xxx", "hhhhhhhhhhhhh");

        List<IpWhiteListEntity> lists = whiteListService.get();
        RedissonLockUtil.lock("gzf", TimeUnit.SECONDS, 100);

        redisQueueHandle.put("gzf", "test");
        System.out.println(1111);
        RedissonLockUtil.unlock("gzf");
        return new ResponseEntity<List<IpWhiteListEntity>>().ok().setdata(lists);
    }
    /**
     * index
     */
    @GetMapping("/test/{param}")
    public ResponseEntity<ShortParamDTO> testShort(@PathVariable(value = "param")String param) {
         ShortParamEntity param1 = shortParamService.longToShort(
                "param",
                param);
         param1.setOriginalParam(null);
        ShortParamDTO map = ModelMapperUtil.map(param1, ShortParamDTO.class);
        return new ResponseEntity<ShortParamDTO>().ok().setdata(map);
    }

    /**
     * index
     */
    @GetMapping("/test")
    public ResponseEntity<String> testShort() {
asyncThreadService.test();
        return new ResponseEntity<String>().ok().setdata("su");
    }
}
