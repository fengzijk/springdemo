package com.fengzijk.springdemo.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fengzijk.springdemo.mapper.IpWhiteListMapper;
import com.fengzijk.springdemo.pojo.entity.IpWhiteListEntity;
import com.fengzijk.springdemo.service.IpWhiteListService;
import java.time.LocalDateTime;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class IpWhiteListServiceImpl extends ServiceImpl<IpWhiteListMapper, IpWhiteListEntity> implements IpWhiteListService {


    @Override
    public List<IpWhiteListEntity> get() {
        LambdaQueryWrapper<IpWhiteListEntity> lambda3 = Wrappers.lambdaQuery();
        lambda3.ne(IpWhiteListEntity::getCreateTime, LocalDateTime.now());
        return super.baseMapper.selectList(lambda3);
    }



}
