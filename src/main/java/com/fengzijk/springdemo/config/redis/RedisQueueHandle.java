package com.fengzijk.springdemo.config.redis;

import org.redisson.api.RDelayedQueue;
import org.redisson.api.RQueue;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;
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
