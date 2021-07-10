package com.fengzijk.springdemo.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.fengzijk.springdemo.entity.IpWhiteList;

import java.util.List;

public interface IpWhiteListService extends IService<IpWhiteList> {
    List<IpWhiteList> get ();
}
