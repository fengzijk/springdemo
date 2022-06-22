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

package com.fengzijk.springdemo.task;

import com.fengzijk.springdemo.config.redis.RedisKeyBuilder;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.redisson.api.RQueue;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SpringDemoTask {

    private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    @Autowired
    private RedissonClient redissonClient;

    // @Scheduled(fixedRate = 1000)
    public void reportCurrentTime() {
        System.out.println("NOW：" + sdf.format(new Date()));
        RQueue<String> queue = redissonClient
                .getQueue(RedisKeyBuilder.KEY_PREFIX + ":" + "gzf");
        String promotionId = queue.poll();
        // 有促销ID，则进行起价更新
        if (promotionId != null) {
            System.out.println("++++++++++++++");
            System.out.println(promotionId);
        }
    }

}

