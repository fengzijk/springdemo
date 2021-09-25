package com.fengzijk.springdemo.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.fengzijk.springdemo.pojo.entity.IpWhiteListEntity;

import java.util.List;

public interface IpWhiteListService extends IService<IpWhiteListEntity> {
    List<IpWhiteListEntity> get ();
}
