/*
 *   All rights Reserved, Designed By ZTE-ITS
 *   Copyright:    Copyright(C) 2019-2025
 *   Company       FENGZIJK LTD.
 *   @Author:    fengzijk
 *   @Email: guozhifengvip@163.com
 *   @Version    V1.0
 *   @Date:   2022年07月03日 00时40分
 *   Modification       History:
 *   ------------------------------------------------------------------------------------
 *   Date                  Author        Version        Description
 *   -----------------------------------------------------------------------------------
 *  2022-07-03 00:40:42    fengzijk         1.0         Why & What is modified: <修改原因描述>
 *
 *
 */

package com.fengzijk.springdemo.common.annotation;

import com.fengzijk.springdemo.common.validation.EnumValidator;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import javax.validation.Constraint;
import javax.validation.Payload;

@Target({ElementType.FIELD, ElementType.METHOD, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = {EnumValidator.class})
@Documented
public @interface EnumValid {

    String message() default "";

    // 作用参考@Validated和@Valid的区别
    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    /**
     * 目标枚举类
     */
    Class<?> target() default Class.class;

    /**
     * 是否必填参数 默认必填 如果非必填 传值不是NULL或空字符串也会校验
     */
    boolean required() default true;
}
