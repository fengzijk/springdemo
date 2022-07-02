/*
 *   All rights Reserved, Designed By ZTE-ITS
 *   Copyright:    Copyright(C) 2019-2025
 *   Company       FENGZIJK LTD.
 *   @Author:    fengzijk
 *   @Email: guozhifengvip@163.com
 *   @Version    V1.0
 *   @Date:   2022年07月03日 00时41分
 *   Modification       History:
 *   ------------------------------------------------------------------------------------
 *   Date                  Author        Version        Description
 *   -----------------------------------------------------------------------------------
 *  2022-07-03 00:41:53    fengzijk         1.0         Why & What is modified: <修改原因描述>
 *
 *
 */

package com.fengzijk.springdemo.common.validation;

import com.fengzijk.springdemo.common.annotation.EnumValid;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import org.apache.commons.lang3.StringUtils;

/**
 * <pre>
 * 自定义枚举校验处理类
 * </pre>
 *
 * @author : guozhifeng
 * @date : 2022/6/17 10:47
 */
public class EnumValidator implements ConstraintValidator<EnumValid, String> {

    /**
     * 枚举校验注解
     */
    private EnumValid annotation;

    @Override
    public void initialize(EnumValid constraintAnnotation) {

        annotation = constraintAnnotation;
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext constraintValidatorContext) {
        boolean result = false;

        Class<?> cls = annotation.target();
        boolean required = annotation.required();

        // target为枚举 并且value有值 或者必填 才进行校验
        if (cls.isEnum() && (StringUtils.isNotBlank(value) || required)) {

            // 必填&&为空
            if (StringUtils.isBlank(value)) {
                return false;
            }

            Object[] objects = cls.getEnumConstants();
            try {
                Method method = cls.getMethod("getCode");
                for (Object obj : objects) {
                    Object code = method.invoke(obj);
                    if (value.equalsIgnoreCase(code.toString())) {
                        result = true;
                        break;
                    }
                }
            } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException ignored) {
            }
        } else if (!cls.isEnum()) {
            // 非枚举类
            return false;
        } else {
            // 非必填&&为空
            result = true;
        }
        return result;
    }
}
