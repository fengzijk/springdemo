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

package com.fengzijk.springdemo.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.fengzijk.springdemo.entity.IpWhiteListEntity;
import java.util.List;

public interface IpWhiteListService extends IService<IpWhiteListEntity> {
    List<IpWhiteListEntity> get();

    /**
     * <pre>功能描述</pre>
     *
     * @param entity
     * @return int
     * @author guozhifeng
     * @date 2022/6/21 22:45
     */
    int saveOrUpdate1(IpWhiteListEntity entity);

    int testSaveSleep(IpWhiteListEntity entity);

    IpWhiteListEntity selectone();


}
