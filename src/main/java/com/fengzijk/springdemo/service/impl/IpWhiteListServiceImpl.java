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

package com.fengzijk.springdemo.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fengzijk.springdemo.config.redis.RedisUtil;
import com.fengzijk.springdemo.config.redis.RedissonLockUtil;
import com.fengzijk.springdemo.entity.IpWhiteListEntity;
import com.fengzijk.springdemo.event.UnLockRedissonEvent;
import com.fengzijk.springdemo.mapper.IpWhiteListMapper;
import com.fengzijk.springdemo.service.IpWhiteListService;
import com.fengzijk.springdemo.util.JsonUtil;
import java.time.LocalDateTime;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Resource;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.redisson.api.RLock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionSynchronizationManager;

@Service
@Slf4j
public class IpWhiteListServiceImpl extends ServiceImpl<IpWhiteListMapper, IpWhiteListEntity> implements IpWhiteListService {
    @Autowired
    private IpWhiteListMapper listMapper;

    @Autowired
    private ApplicationEventPublisher eventPublisher;

    @Resource
    private RedisUtil  redisUtil;

    @Override
    public List<IpWhiteListEntity> get() {
        LambdaQueryWrapper<IpWhiteListEntity> lambda3 = Wrappers.lambdaQuery();
        lambda3.ne(IpWhiteListEntity::getCreateTime, LocalDateTime.now());
        return super.baseMapper.selectList(lambda3);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int saveOrUpdate1(IpWhiteListEntity entity) {
        IpWhiteListEntity listEntity1 = super.baseMapper.selectById(12);
        log.info("listEntity1================:{}", JsonUtil.tojson(listEntity1));
        try {
            TimeUnit.SECONDS.sleep(100);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        IpWhiteListEntity listEntity2 = super.baseMapper.selectById(12);
        log.info("listEntity2================:{}", JsonUtil.tojson(listEntity2));
        return 1;
    }


    @SneakyThrows
    @Override
    @Transactional
    public IpWhiteListEntity selectone() {
        IpWhiteListEntity listEntity1 = listMapper.selectByxxId(25L);

        redisUtil.set("111",listEntity1);
        log.info("1================:{}", JsonUtil.tojson(listEntity1));

        IpWhiteListEntity ipWhiteListEntity =  redisUtil.get("111");

        log.info("redis:{}",ipWhiteListEntity);
        return null;
    }

















    @Override
    @Transactional(rollbackFor = Exception.class)
    public int testSaveSleep(IpWhiteListEntity entity) {
        RLock rLock = RedissonLockUtil.lock("11111");
        log.info("获得 线程id:{},名称：{},锁:{},herad:{}", Thread.currentThread().getId(), Thread.currentThread().getName(), rLock.getName(), rLock.isHeldByCurrentThread());
        if (rLock == null) {
            rLock.isLocked();
        }
        try {
            listMapper.saveOrUpdate(entity);
        } catch (Exception ignored) {

        } finally {
            eventPublisher.publishEvent(new UnLockRedissonEvent(this, rLock));
        }


        log.info("事务：{}==={}", TransactionSynchronizationManager.isActualTransactionActive());

        return 0;
    }

}
