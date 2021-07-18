package com.fengzijk.springdemo.util;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.FatalBeanException;
import org.springframework.util.Assert;
import org.springframework.util.ClassUtils;

import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;

/**
*-------------------------------------------------
* <pre>继承并扩展spring BeanUtils</pre>
* @className  : BeanCopyUtils
* @author : fengzijk
* @email: guozhifengvip@gmail.com
* @date : 2021/7/18 下午10:27
*--------------------------------------------------
*/
public class BeanCopyUtils extends BeanUtils {

    /**
     * bean对象转成map对象
     *
     * @param obj bean对象
     * @param prefix key属性的前缀
     * @return Map
     */
    public static Map<String, Object> bean2map(Object obj, String prefix) {
        if (obj == null) {
            return null;
        }

        try {

            Field[] declaredFields = obj.getClass().getDeclaredFields();
            Map<String, Object> map = new HashMap<>(declaredFields.length, 1);
            for (Field field : declaredFields) {
                field.setAccessible(true);
                Object value = field.get(obj);
                map.put(prefix + field.getName(), value == null ? "" : value);
            }
            return map;
        } catch (IllegalArgumentException | IllegalAccessException e) {
            e.printStackTrace();
        }

        return null;
    }

    /**
     * 创建目标对象,并复制对象属性
     *
     * @param source 源对象
     * @param targetClass 目标类型class
     * @param <T> 目标类型
     * @param <S> 源类型
     * @return 目标对象结果
     * @throws Exception Exception
     */
    public static <T, S> T createAndCopyProperties(S source, Class<T> targetClass) throws Exception {
        T t = targetClass.newInstance();
        copyProperties(source, t);
        return t;
    }

    /**
     * 批量设置字段值
     *
     * @param sourceList 原数据列表
     * @param propertyName 字段名称
     * @param propertyValue 字段值
     * @param <S> 原数据
     * @throws Exception Exception
     */
    public static <S> void setPropertyWithList(List<S> sourceList, String propertyName, Object propertyValue) throws Exception {

        if (sourceList == null || sourceList.isEmpty()) {
            return;
        }

        S s = sourceList.get(0);
        PropertyDescriptor propertyDescriptor = getPropertyDescriptor(s.getClass(), propertyName);
        Method writeMethod = propertyDescriptor.getWriteMethod();

        for (S obj : sourceList) {
            writeMethod.invoke(obj, propertyValue);
        }

    }


    /**
     * 提取属性列表
     *
     * @param sourceList 原数据列表
     * @param propertyName 属性名称
     * @param targetClass 提取属性的Class
     * @param <T> 目标数据 T
     * @param <S> 原数据 S
     * @return 已提出的属性列表
     * @throws Exception Exception
     */
    @SuppressWarnings("unchecked")
    public static <T, S> List<T> extractPropertyFromList(List<S> sourceList, String propertyName, Class<T> targetClass) throws Exception {
        ArrayList<T> resultList = new ArrayList<>();

        if (sourceList != null && !sourceList.isEmpty()) {
            S firstElement = sourceList.get(0);
            PropertyDescriptor propertyDescriptor = getPropertyDescriptor(firstElement.getClass(), propertyName);
            Method readMethod = propertyDescriptor.getReadMethod();

            for (S source : sourceList) {
                resultList.add((T) readMethod.invoke(source));
            }

        }
        return resultList;

    }

    /**
     * 将所有属性从源复制到目的地，不复制null值
     *
     * @param sources 源对象, 逐个合并, 后的对象非空属性覆盖前面 对象的属性.
     * @param <T> target 目标对象
     * @return 结果
     */
    public static <T> T mergeProperties(T target, Object... sources) {
        Assert.notNull(sources, "Source must not be null");
        Assert.notNull(target, "Target must not be null");

        Class<?> actualEditable = target.getClass();
        PropertyDescriptor[] targetPds = getPropertyDescriptors(actualEditable);

        // 遍历所有源
        for (Object source : sources) {
            if (source == null) {
                continue;
            }
            // 对每个源进行合并
            for (PropertyDescriptor targetPd : targetPds) {
                Method writeMethod = targetPd.getWriteMethod();
                PropertyDescriptor sourcePd = getPropertyDescriptor(source.getClass(), targetPd.getName());
                if (writeMethod == null || sourcePd == null) {
                    continue;
                }

                Method readMethod = sourcePd.getReadMethod();
                if (readMethod != null && ClassUtils.isAssignable(writeMethod.getParameterTypes()[0], readMethod.getReturnType())) {
                    try {
                        if (!Modifier.isPublic(readMethod.getDeclaringClass().getModifiers())) {
                            readMethod.setAccessible(true);
                        }
                        Object value = readMethod.invoke(source);
                        // 合并, 源数据字段为null则直接过滤, 由target决定
                        if (value == null) {
                            continue;
                        }

                        if (!Modifier.isPublic(writeMethod.getDeclaringClass().getModifiers())) {
                            writeMethod.setAccessible(true);
                        }
                        writeMethod.invoke(target, value);
                    } catch (Throwable ex) {
                        throw new FatalBeanException("Could not copy property '" + targetPd.getName() + "' from source to target", ex);
                    }
                }
            }
        }

        return target;
    }

    /**
     * List 转换对象
     *
     * @param source 源对象
     * @param targetSupplier 目标对象供应方
     * @param callBack 回调方法
     * @param <S> 源对象类型
     * @param <T> 目标对象类型
     * @return 目标对象
     */
    public static <S, T> T convertTo(S source, Supplier<T> targetSupplier, ConvertCallBack<S, T> callBack) {
        if (null == source || null == targetSupplier) {
            return null;
        }

        T target = targetSupplier.get();
        copyProperties(source, target);
        if (callBack != null) {
            callBack.callBack(source, target);
        }
        return target;
    }

    public static <S, T> List<T> convertListTo(List<S> sources, Supplier<T> targetSupplier) {
        return convertListTo(sources, targetSupplier, null);
    }

    /**
     * list 转换对象
     *
     * @param sources 源对象list
     * @param targetSupplier 目标对象供应方
     * @param callBack 回调方法
     * @param <S> 源对象类型
     * @param <T> 目标对象类型
     * @return 目标对象list
     */
    public static <S, T> List<T> convertListTo(List<S> sources, Supplier<T> targetSupplier, ConvertCallBack<S, T> callBack) {
        if (null == sources || null == targetSupplier) {
            return null;
        }

        List<T> list = new ArrayList<>(sources.size());
        for (S source : sources) {
            T target = targetSupplier.get();
            copyProperties(source, target);
            if (callBack != null) {
                callBack.callBack(source, target);
            }
            list.add(target);
        }
        return list;
    }

    /**
     * 回调接口
     *
     * @param <S> 源对象类型
     * @param <T> 目标对象类型
     */
    @FunctionalInterface
    public interface ConvertCallBack<S, T> {
        void callBack(S t, T s);
    }

}

