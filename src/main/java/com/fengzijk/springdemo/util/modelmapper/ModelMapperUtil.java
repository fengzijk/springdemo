package com.fengzijk.springdemo.util.modelmapper;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class ModelMapperUtil {
    private static ModelMapper modelMapper = SingletonModelMapper.getInstance();

    /**
     * 实体转换
     *
     * @param entity   原始
     * @param outClass 目标
     * @return 目标类型的实体
     */
    public static <D, T> D map(final T entity, Class<D> outClass) {
        if (entity == null) {
            return null;
        }
        return modelMapper.map(entity, outClass);
    }

    /**
     * 集合转换
     *
     * @param entityList 原始集合
     * @param d   目标集合类
     * @param <D>
     * @param <T>
     * @return 目标类型的集合
     */
    public static <D, T> List<D> mapList(final Collection<T> entityList, Class<D> d) {
        if (entityList == null) {
            return null;
        }
        return entityList.stream()
                .map(entity -> map(entity, d))
                .collect(Collectors.toList());
    }

    public static <S, D> D map(final S source, D destination) {
        modelMapper.map(source, destination);
        return destination;
    }
}