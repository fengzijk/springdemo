package com.fengzijk.springdemo.service.impl;

import com.fengzijk.springdemo.service.IMongoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;


/**
 * -------------------------------------------------
 * <pre>功能描述:</pre>
 *
 * @author : guozhifeng
 * @date : 2021/9/25 11:08
 * --------------------------------------------------
 */
@Service
public class MongoServiceImpl implements IMongoService {

    @Autowired
    private MongoTemplate mongoTemplate;


}
