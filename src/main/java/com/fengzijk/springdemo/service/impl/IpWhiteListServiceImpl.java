package com.fengzijk.springdemo.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fengzijk.springdemo.entity.IpWhiteListEntity;
import com.fengzijk.springdemo.mapper.IpWhiteListMapper;
import com.fengzijk.springdemo.service.IpWhiteListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

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
}
