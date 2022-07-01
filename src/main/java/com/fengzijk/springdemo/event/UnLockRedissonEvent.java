/*
 *   All rights Reserved, Designed By ZTE-ITS
 *   Copyright:    Copyright(C) 2019-2025
 *   Company       FENGZIJK LTD.
 *   @Author:    fengzijk
 *   @Email: guozhifengvip@163.com
 *   @Version    V1.0
 *   @Date:   2022年07月01日 00时04分
 *   Modification       History:
 *   ------------------------------------------------------------------------------------
 *   Date                  Author        Version        Description
 *   -----------------------------------------------------------------------------------
 *  2022-07-01 00:04:49    fengzijk         1.0         Why & What is modified: <修改原因描述>
 *
 *
 */

package com.fengzijk.springdemo.event;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.redisson.api.RLock;
import org.springframework.context.ApplicationEvent;

@Setter
@Getter
@Accessors(chain = true)
public class UnLockRedissonEvent extends ApplicationEvent implements Serializable {

    private static final long serialVersionUID = -5893580380704987064L;

    private RLock lock;

    public UnLockRedissonEvent(Object source, RLock lock) {
        super(source);
        this.lock = lock;
    }
}
