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

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fengzijk.springdemo.entity.DemoEntity;
import com.fengzijk.springdemo.mapper.DemoMapper;
import com.fengzijk.springdemo.service.DemoService;
import com.fengzijk.springdemo.util.JsonUtil;
import java.util.concurrent.TimeUnit;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Slf4j
public class DemoServiceImpl extends ServiceImpl<DemoMapper, DemoEntity> implements DemoService {
    @Autowired
    private DemoMapper demoMapper;



    @SneakyThrows
    @Override
    @Transactional
    public DemoEntity selectTest() {
        DemoEntity listEntity1 = demoMapper.selectByxxId(25L);
        log.info("1================:{}", JsonUtil.tojson(listEntity1));
        TimeUnit.SECONDS.sleep(10);

        DemoEntity listEntity2 = demoMapper.selectByxxId(25L);
        log.info("2================:{}", JsonUtil.tojson(listEntity2));
        TimeUnit.SECONDS.sleep(10);

        DemoEntity listEntity3 = demoMapper.selectByxxId(25L);
        log.info("3================:{}", JsonUtil.tojson(listEntity3));
        return listEntity1;
    }



}
