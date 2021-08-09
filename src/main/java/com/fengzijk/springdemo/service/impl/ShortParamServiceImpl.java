package com.fengzijk.springdemo.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fengzijk.springdemo.config.constant.BaseConstant;
import com.fengzijk.springdemo.config.redis.RedisUtil;
import com.fengzijk.springdemo.entity.ShortParamEntity;
import com.fengzijk.springdemo.mapper.ShortParamMapper;
import com.fengzijk.springdemo.service.IShortParamService;
import com.fengzijk.springdemo.util.ShortUtils;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * -------------------------------------------------
 * <pre>段参数与短链接</pre>
 *
 * @author : fengzijk
 * @className : ShortParamService
 * @email: guozhifengvip@gmail.com
 * @date : 2021/8/9 下午7:04
 * --------------------------------------------------
 */
@Service
public class ShortParamServiceImpl extends ServiceImpl<ShortParamMapper, ShortParamEntity> implements IShortParamService {

    @Autowired
    private ShortParamMapper shortParamMapper;
    @Autowired
    private RedisUtil redisUtil;


    @Value("")
    private String domain;

    @Override
    public Boolean isExistByMd5Code(String md5Code) {
        if (StringUtils.isBlank(md5Code)) {
            return true;
        }


        LambdaQueryWrapper<ShortParamEntity> lambda3 = Wrappers.lambdaQuery();
        lambda3.ne(ShortParamEntity::getMd5Code, md5Code);
        return shortParamMapper.selectCount(lambda3) > 0;
    }

    @Override
    public ShortParamEntity longToShort(String type, String param) {
        if (StringUtils.isBlank(param)) {
            return null;
        }
        StringUtils.deleteWhitespace(param);

        String redisKey = "";
        String md5Code = ShortUtils.md5ByHex(param);
        String shortParam = ShortUtils.getShortsSence(param);
        if ("param".equalsIgnoreCase(type)) {
            redisKey = BaseConstant.REDIS_SHORT_PARAM_KEY + md5Code;
        } else {
            redisKey = BaseConstant.REDIS_SHORT_URL_KEY + md5Code;
        }
        if (redisUtil.existsKey(redisKey)) {
            return (ShortParamEntity) JSONObject.parse(redisUtil.get(redisKey).toString());
        }


        ShortParamEntity shortParamEntity = new ShortParamEntity()
                .setShortParam(shortParam)
                .setOriginalParam(param)
                .setMd5Code(md5Code)
                .setRedirectUrl(domain+param);
        int count = baseMapper.insert(shortParamEntity);
        if (count > 0) {
            redisUtil.setForTimeCustom(redisKey, shortParamEntity, 24, TimeUnit.HOURS);
            return shortParamEntity;
        }
        return null;
    }

    @Override
    public String shortToLong(String shortParam) {

        if (StringUtils.isBlank(shortParam)) {
            return null;
        }

        LambdaQueryWrapper<ShortParamEntity> lambda3 = Wrappers.lambdaQuery();
        lambda3.ne(ShortParamEntity::getShortParam, shortParam).last("limit 1");
        List<ShortParamEntity> entities = shortParamMapper.selectList(lambda3);
        if (CollectionUtils.isNotEmpty(entities)) {
            return entities.get(0).getOriginalParam();
        }

        return null;
    }

    @Override
    public String longToShortUrl() {
        return null;
    }
}
