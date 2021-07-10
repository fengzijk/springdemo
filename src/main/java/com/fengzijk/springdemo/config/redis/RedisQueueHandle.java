package com.fengzijk.springdemo.config.redis;

import org.redisson.api.RDelayedQueue;
import org.redisson.api.RQueue;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.TimerTask;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
@Component
public class RedisQueueHandle {

    @Autowired
    private RedissonClient redissonClient;


    public Boolean put(String queueName, String str) {
        RQueue<String> queue = redissonClient
                .getQueue(RedisKeyBuilder.KEY_PREFIX+":"+queueName);
        // 使用延迟队列
        RDelayedQueue<String> delayedQueue = redissonClient.getDelayedQueue(queue);
        delayedQueue.offer(str, 2, TimeUnit.MINUTES);
        // 使用后释放掉
        delayedQueue.destroy();
        return true;
    }


    @PostConstruct
    public void init() {
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
        // 每秒检测一次
        executor.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                RQueue<String> queue = redissonClient
                        .getQueue(RedisKeyBuilder.KEY_PREFIX+":"+"gzf");
                String promotionId = queue.poll();
                // 有促销ID，则进行起价更新
                if (promotionId != null) {
                    System.out.println(promotionId);
                }
            }
        }, 0, 1, TimeUnit.SECONDS);
    }
}
