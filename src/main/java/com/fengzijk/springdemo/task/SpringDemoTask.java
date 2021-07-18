package com.fengzijk.springdemo.task;

import com.fengzijk.springdemo.config.redis.RedisKeyBuilder;
import org.redisson.api.RQueue;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;
@Component
public class SpringDemoTask {

    @Autowired
    private RedissonClient redissonClient;

        private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

       // @Scheduled(fixedRate = 1000)
        public void reportCurrentTime() {
            System.out.println("NOW：" + sdf.format(new Date()));
            RQueue<String> queue = redissonClient
                    .getQueue(RedisKeyBuilder.KEY_PREFIX+":"+"gzf");
            String promotionId = queue.poll();
            // 有促销ID，则进行起价更新
            if (promotionId != null) {
                System.out.println("++++++++++++++");
                System.out.println(promotionId);
            }
        }

    }

