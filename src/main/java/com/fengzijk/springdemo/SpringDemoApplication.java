package com.fengzijk.springdemo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
*-------------------------------------------------
* <pre>功能描述:</pre>
* @author : fengzijk
* @email: guozhifengvip@gmail.com
* @date : 2021/7/10 上午1:32
*--------------------------------------------------
*/
@SpringBootApplication
@MapperScan("com.fengzijk.springdemo.mapper")
@EnableScheduling
public class SpringDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringDemoApplication.class, args);
    }

}
