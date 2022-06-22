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
