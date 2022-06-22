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

package com.fengzijk.springdemo.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fengzijk.springdemo.entity.IpWhiteListEntity;
import com.fengzijk.springdemo.mapper.IpWhiteListMapper;
import com.fengzijk.springdemo.service.IpWhiteListService;
import java.time.LocalDateTime;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IpWhiteListServiceImpl extends ServiceImpl<IpWhiteListMapper, IpWhiteListEntity> implements IpWhiteListService {
    @Autowired
    private IpWhiteListMapper listMapper;


    @Override
    public List<IpWhiteListEntity> get() {
        LambdaQueryWrapper<IpWhiteListEntity> lambda3 = Wrappers.<IpWhiteListEntity>lambdaQuery();
        lambda3.ne(IpWhiteListEntity::getCreateTime, LocalDateTime.now());
        return super.baseMapper.selectList(lambda3);
    }

    @Override
    public int saveOrUpdate1(IpWhiteListEntity entity) {
        return listMapper.saveOrUpdate(entity);
    }
}
