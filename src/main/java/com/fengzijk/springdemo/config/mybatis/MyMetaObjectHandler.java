package com.fengzijk.springdemo.config.mybatis;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import com.fengzijk.springdemo.intercepter.UserHolder;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;


/**
 * -------------------------------------------------
 * <pre>功能描述:</pre>
 *
 * @author : fengzijk
 * @className : MyMetaObjectHandler
 * @email: guozhifengvip@gmail.com
 * @date : 2021/8/9 下午8:23
 * --------------------------------------------------
 */
@Slf4j
@Component
public class MyMetaObjectHandler implements MetaObjectHandler {

    /**
     * 创建人
     */
    private static final String CREATE_ID = "createId";
    /**
     * 创建时间
     */
    private static final String CREATE_TIME = "createTime";
    /**
     * 修改人
     */
    private static final String UPDATE_ID = "updateId";

    /**
     * 修改时间
     */
    private static final String UPDATE_TIME = "updateTime";


    @Override
    public void insertFill(MetaObject metaObject) {
        AtomicReference<Long> userId = new AtomicReference<>(1L);
        Optional.ofNullable(UserHolder.getCurrentUser()).ifPresent(u -> userId.set(u.getUserId()));
        this.fillStrategy(metaObject, CREATE_ID, userId.get());
        this.fillStrategy(metaObject, UPDATE_ID, userId.get());
        this.setFieldValByName(CREATE_TIME, LocalDateTime.now(), metaObject);
        this.setFieldValByName(UPDATE_TIME, LocalDateTime.now(), metaObject);
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        AtomicReference<Long> userId = new AtomicReference<>(1L);
        Optional.ofNullable(UserHolder.getCurrentUser()).ifPresent(u -> userId.set(u.getUserId()));
        this.fillStrategy(metaObject, UPDATE_ID, userId.get());
        this.setFieldValByName(UPDATE_TIME, LocalDateTime.now(), metaObject);
    }
}
