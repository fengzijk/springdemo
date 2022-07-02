/*
 *   All rights Reserved, Designed By ZTE-ITS
 *   Copyright:    Copyright(C) 2019-2025
 *   Company       FENGZIJK LTD.
 *   @Author:    fengzijk
 *   @Email: guozhifengvip@163.com
 *   @Version    V1.0
 *   @Date:   2022年06月30日 23时58分
 *   Modification       History:
 *   ------------------------------------------------------------------------------------
 *   Date                  Author        Version        Description
 *   -----------------------------------------------------------------------------------
 *  2022-06-30 23:58:58    fengzijk         1.0         Why & What is modified: <修改原因描述>
 *
 *
 */

package com.fengzijk.springdemo.event;

import java.util.Objects;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.transaction.event.TransactionPhase;
import org.springframework.transaction.event.TransactionalEventListener;

@Component
@Slf4j
public class UserEventListener {

//    /**
//     * 监听用户浏览事件 如果服务者三小时内访问被指配求助的用户im 钉钉播报
//     *
//     * @param event 用户浏览事件
//     * @author guozhifeng
//     * @date 2021/10/14 9:22
//     */
//    @Async
//    @EventListener
//    public void userVisitorImUserCustomerRequestDingTalk(UnLockRedissonEvent event) {
//        if (Objects.isNull(event) || Objects.isNull(event.getLock())) {
//            return;
//        }
//
//        log.info("解锁 线程id:{},名称：{},锁:{},herad:{}", Thread.currentThread().getId(), Thread.currentThread().getName(), event.getLock().getName(), event.getLock().isHeldByCurrentThread());
//        event.getLock().unlock();
//
//    }

    @TransactionalEventListener(phase =TransactionPhase.AFTER_COMPLETION)
    public void test1(UnLockRedissonEvent event) {
        if (Objects.isNull(event) || Objects.isNull(event.getLock())) {
            return;
        }

        log.info("解锁1 线程id:{},名称：{},锁:{},herad:{}", Thread.currentThread().getId(), Thread.currentThread().getName(), event.getLock().getName(), event.getLock().isHeldByCurrentThread());
        event.getLock().unlock();

    }
}
