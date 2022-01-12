/*
 *   All rights Reserved, Designed By ZTE-ITS
 *   Copyright:    Copyright(C) 2021-2025
 *   Company       FENGZIJK LTD.
 *   @Author:    fengzijk
 *   @Email: guozhifengvip@163.com
 *   @Version    V1.0
 *   @Date:   2022年01月12日 21时30分
 *   Modification       History:
 *   ------------------------------------------------------------------------------------
 *   Date                  Author        Version        Discription
 *   -----------------------------------------------------------------------------------
 *  2022-01-12 21:30:26    fengzijk         1.0         Why & What is modified: <修改原因描述>
 *
 *
 */

package com.fengzijk.springdemo.service.impl;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Semaphore;
import javax.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.task.TaskExecutor;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class AsyncThreadServiceImpl {

    @Resource
    @Qualifier("taskExecutor")
    private TaskExecutor executor;


    public void test() {
        Semaphore semaphore = new Semaphore(3);
        List<Integer> paramList = Arrays.asList(1, 2, 3, 4);
        List<CompletableFuture<Void>> itemFutureList = new ArrayList<>();

        paramList.forEach(a -> {
            try {
                semaphore.acquire();
                itemFutureList.add(
                  CompletableFuture.runAsync(() -> {

                      System.out.println(a+"--------"+Thread.currentThread().getName());
                      semaphore.release();

                  }, executor));

        } catch (InterruptedException e) {
                e.printStackTrace();
            }

        });
        CompletableFuture.allOf(itemFutureList.toArray(new CompletableFuture[0])).join();


    }


}