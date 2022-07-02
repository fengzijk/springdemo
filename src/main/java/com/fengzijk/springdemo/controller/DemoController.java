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

package com.fengzijk.springdemo.controller;


import com.fengzijk.springdemo.config.model.ResponseEntity;
import com.fengzijk.springdemo.entity.DemoEntity;
import com.fengzijk.springdemo.mapper.DemoMapper;
import com.fengzijk.springdemo.service.DemoService;
import com.fengzijk.springdemo.util.JsonUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/test")
@Slf4j
public class DemoController {

    @Autowired
    private DemoService demoService;

    @Autowired
    private DemoMapper demoMapper;


    @GetMapping("/get")
    public ResponseEntity<String> test() {

        demoService.selectTest();
        DemoEntity listEntity2 = demoMapper.selectByxxId(25L);
        log.info("listEntity2================:{}", JsonUtil.tojson(listEntity2));

        return new ResponseEntity<String>().ok().setdata("success");
    }


}
