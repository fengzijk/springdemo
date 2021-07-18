package com.fengzijk.springdemo.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fengzijk.springdemo.entity.IpWhiteList;
import com.fengzijk.springdemo.mapper.IpWhiteListMapper;
import com.fengzijk.springdemo.service.IpWhiteListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class IpWhiteListServiceImpl extends ServiceImpl<IpWhiteListMapper, IpWhiteList> implements IpWhiteListService {
    @Autowired
    IpWhiteListMapper listMapper;


    @Override
    public List<IpWhiteList> get() {
        LambdaQueryWrapper<IpWhiteList> lambda3 = Wrappers.<IpWhiteList>lambdaQuery();
        lambda3.ne(IpWhiteList::getCreateTime, LocalDateTime.now());
        return super.baseMapper.selectList(lambda3);
    }
}
