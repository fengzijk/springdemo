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

package com.fengzijk.springdemo.config.redis;

import java.util.concurrent.TimeUnit;
import org.redisson.api.RDelayedQueue;
import org.redisson.api.RQueue;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RedisQueueHandle {

    @Autowired
    private RedissonClient redissonClient;


    public Boolean put(String queueName, String str) {
        RQueue<String> queue = redissonClient
                .getQueue(RedisKeyBuilder.KEY_PREFIX + ":" + queueName);
        // 使用延迟队列
        RDelayedQueue<String> delayedQueue = redissonClient.getDelayedQueue(queue);
        delayedQueue.offer(str, 5, TimeUnit.SECONDS);
        // 使用后释放掉
        delayedQueue.destroy();
        return true;
    }


}
