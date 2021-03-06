
/*
 *   All rights Reserved, Designed By ZTE-ITS
 *   Copyright:    Copyright(C) 2019-2025
 *   Company       FENGZIJK LTD.
 *   @Author:    fengzijk
 *   @Email: guozhifengvip@163.com
 *   @Version    V1.0
 *   @Date:   2019年04月24日 15时01分
 *   Modification       History:
 *   ------------------------------------------------------------------------------------
 *   Date                  Author        Version        Discription
 *   -----------------------------------------------------------------------------------
 *  2019-04-24 15:01:48    fengzijk         1.0         Why & What is modified: <修改原因描述>
 */

package com.fengzijk.springdemo.config.redis;

import org.redisson.api.RLock;

import java.util.concurrent.TimeUnit;

/**
 * -------------------------------------------------
 *
 * @Descprition : 分布式锁工具类
 * @Author : fengzijk
 * @email: guozhifengvip@163.com
 * @Time : 2019/3/23 10:57
 * --------------------------------------------------
 */
public class RedissonLockUtil {
        private static DistributedLocker redissLock;

        public static void setLocker(DistributedLocker locker) {
            redissLock = locker;
        }

        public static RLock lock(String lockKey) {
          return   redissLock.lock(lockKey);
        }

        public static void unlock(String lockKey) {
            redissLock.unlock(lockKey);
        }

        /**
         * 带超时的锁
         * @param lockKey
         * @param timeout 超时时间   单位：秒
         * @return
         */
        public static RLock lock(String lockKey, int timeout) {
           return redissLock.lock(lockKey, timeout);
        }

        /**
         * 带超时的锁
         * @param lockKey
         * @param unit 时间单位
         * @param timeout 超时时间
         */
        public static RLock lock(String lockKey, TimeUnit unit , int timeout) {
           return redissLock.lock(lockKey, unit, timeout);
        }
}
