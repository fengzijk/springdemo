/*
package com.fengzijk.springdemo.config.mybatis;


import com.alibaba.fastjson.JSONObject;
import com.fengzijk.springdemo.intercepter.UserHolder;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.apache.ibatis.binding.MapperMethod;
import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.SqlCommandType;
import org.apache.ibatis.plugin.*;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;
import java.util.Objects;
import java.util.Optional;
import java.util.Properties;
import java.util.concurrent.atomic.AtomicReference;

*/
/**
 * <pre>
 * 拦截所有执行的SQL，进行必要字段的数据填充
 * </pre>
 *
 * @author guozhifeng
 * @date 2021/8/3 11:32
 * <p>
 * 创建人
 * <p>
 * 修改人
 * <p>
 * 设置拼接 用户id和管理员id值
 * @param sqlCommandType
 * @param object
 * @param userId
 * @throws java.lang.Exception
 * <p>
 * 通过反射动态设置属性和值
 * @param object
 * @param declaredField
 * @param value
 * @throws java.lang.Exception
 * <p>
 * 参数为Map类型时，mybatis-plus 转换参数为et-entity 设置用户id和管理员id
 * @param sqlCommandType Sql 类型
 * @param object         或得到的对象
 * @param userId         用户Id
 * @throws java.lang.Exception
 *//*

@Intercepts({@Signature(type = Executor.class, method = "update", args = {MappedStatement.class, Object.class})})
@Component
@Slf4j
public class MybatisAddCommonFieldInterceptor implements Interceptor {


    */
/**
 * 创建人
 *//*

    private static final String CREATE_ID = "createId";

    */
/**
 * 修改人
 *//*

    private static final String UPDATE_ID = "updateId";


    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        AtomicReference<Long> userId = new AtomicReference<>(1L);
        Optional.ofNullable(UserHolder.getCurrentUser()).ifPresent(u -> userId.set(u.getUserId()));


        MappedStatement mappedStatement = (MappedStatement) invocation.getArgs()[0];
        Object object = invocation.getArgs()[1];
        // 获取sql类型只有 INSERT操作 与UPDATE操作 才处理
        SqlCommandType sqlCommandType = mappedStatement.getSqlCommandType();

        // if(){object instanceof DefaultSqlSession.StrictMap}

        // mybatis-plus 批量插入为 for循环插入会进这里
        if (object instanceof MapperMethod.ParamMap) {
            try {
                handleParamMap(sqlCommandType, object, userId.get());
            } catch (Exception e) {
                log.error("object:{}, userId:{}, e:{}", JSONObject.toJSON(object), userId.get(), ExceptionUtils.getStackTrace(e));
                // 获取不到属性按原SQL执行
                return invocation.proceed();
            }
        } else {
            // 单条插入/修改
            try {
                setColumn(sqlCommandType, object, userId.get());
            } catch (Exception e) {
                log.error("object:{}, userId:{},  e:{}", JSONObject.toJSON(object), userId.get(),
                        ExceptionUtils.getStackTrace(e));
                // 获取不到属性按原SQL执行
                return invocation.proceed();
            }
        }

        return invocation.proceed();
    }

    */
/**
 * 设置拼接 用户id和管理员id值
 *
 * @param sqlCommandType
 * @param object
 * @param userId
 * @throws java.lang.Exception
 *//*

    private void setColumn(SqlCommandType sqlCommandType, Object object, Long userId) throws Exception {
        // 如果是 SELECT 操作直接返回
        if (SqlCommandType.SELECT.name().equalsIgnoreCase(sqlCommandType.name())) {
            return;
        }

        // INSERT操作
        if (SqlCommandType.INSERT.name().equalsIgnoreCase(sqlCommandType.name())) {
            if (Objects.nonNull(userId)) {
                setFieldVal(object, CREATE_ID, userId);
                setFieldVal(object, UPDATE_ID, userId);
            }

            // UPDATE操作
        } else if (SqlCommandType.UPDATE.name().equalsIgnoreCase(sqlCommandType.name())) {
            if (Objects.nonNull(userId)) {
                setFieldVal(object, UPDATE_ID, userId);
            }
        }
    }

    */
/**
 * 通过反射动态设置属性和值
 *
 * @param object
 * @param declaredField
 * @param value
 * @throws java.lang.Exception
 *//*

    private void setFieldVal(Object object, String declaredField, Object value) throws Exception {
        Field field;
        Class<? extends Object> clz = object.getClass();

        try {
            field = clz.getDeclaredField(declaredField);
        } catch (NoSuchFieldException nse) {
            // 查找父类是否有该属性
            // TODO(备忘)只支持一层继承的属性
            try {
                field = clz.getSuperclass().getDeclaredField(declaredField);
            } catch (NoSuchFieldException nse2) {
                return;
            }
        }

        if (field == null) {
            return;
        }
        boolean isAccessible = field.isAccessible();
        if (!isAccessible) {
            field.setAccessible(true);
        }

        // 判断属性值是否为空 属性值为空才设置获取到的值
        if (Objects.isNull(field.get(object))) {
            field.set(object, value);
            field.setAccessible(isAccessible);
        }
    }

    @Override
    public Object plugin(Object target) {
        return Plugin.wrap(target, this);
    }

    @Override
    public void setProperties(Properties properties) {
    }


    */
/**
 * 参数为Map类型时，mybatis-plus 转换参数为et-entity 设置用户id和管理员id
 *
 * @param sqlCommandType Sql 类型
 * @param object         或得到的对象
 * @param userId         用户Id
 * @throws java.lang.Exception
 *//*

    @SuppressWarnings("rawtypes")
    private void handleParamMap(SqlCommandType sqlCommandType, Object object, Long userId) throws Exception {
        MapperMethod.ParamMap map = (MapperMethod.ParamMap) object;
        if (!map.containsKey("et")) {
            return;
        }
        try {
            setColumn(sqlCommandType, ((MapperMethod.ParamMap) object).get("et"), userId);
        } catch (Exception e) {
            log.error("object:{}, userId:{}, e:{}", JSONObject.toJSON(object), userId,
                    ExceptionUtils.getStackTrace(e));
        }
    }

}
*/
