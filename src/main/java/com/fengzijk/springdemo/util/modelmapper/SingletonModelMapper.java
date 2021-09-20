package com.fengzijk.springdemo.util.modelmapper;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;

public class SingletonModelMapper {

    private static volatile ModelMapper instance = null;

    private SingletonModelMapper() {
    }

    public static ModelMapper getInstance() {
        if (instance == null) {
            synchronized (SingletonModelMapper.class) {
                if (instance == null) {
                    instance = new ModelMapper();
                    instance.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
                }
            }
        }
        return instance;
    }
}