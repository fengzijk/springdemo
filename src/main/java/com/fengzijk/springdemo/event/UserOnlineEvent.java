/*
 *   All rights Reserved, Designed By ZTE-ITS
 *   Copyright:    Copyright(C) 2019-2025
 *   Company       FENGZIJK LTD.
 *   @Author:    fengzijk
 *   @Email: guozhifengvip@163.com
 *   @Version    V1.0
 *   @Date:   2022年07月01日 00时01分
 *   Modification       History:
 *   ------------------------------------------------------------------------------------
 *   Date                  Author        Version        Description
 *   -----------------------------------------------------------------------------------
 *  2022-07-01 00:01:06    fengzijk         1.0         Why & What is modified: <修改原因描述>
 *
 *
 */

package com.fengzijk.springdemo.event;

import java.io.Serializable;
import java.util.Date;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.springframework.context.ApplicationEvent;

@Setter
@Getter
@Accessors(chain = true)
public class UserOnlineEvent extends ApplicationEvent implements Serializable {


    private static final long serialVersionUID = 7735718249268186087L;
    /**
     * 用户id
     */
    private Long userId;

    /**
     * 用户果号
     */
    private String username;
    /**
     * 最后活跃时间，即最近一次接口请求时间 有五分钟的误差区间
     */
    private Date lastOnlineTime;

    /**
     * 客户端IP，120.77.177.219
     */
    private String remoteClientIp;

    /**
     * 客户端版本号ios 去除点 安卓 版本号 eg 1203 1225
     */
    private String appVersion;

    /**
     * 客户端型号，如：iPhone10,6
     */
    private String clientModel;

    /**
     * 用户设备操作类型 安卓-ANDROID 苹果-IOS
     */
    private String clientChannel;

    /**
     * APP的唯一标识
     */
    private String deviceId;


    public UserOnlineEvent(Object source, Long userId, String username, Date lastOnlineTime, String remoteClientIp, String appVersion,
            String clientModel, String clientChannel,String deviceId) {
        super(source);
        this.userId = userId;
        this.username = username;
        this.lastOnlineTime = lastOnlineTime;
        this.remoteClientIp = remoteClientIp;
        this.appVersion = appVersion;
        this.clientModel = clientModel;
        this.clientChannel = clientChannel;
        this.deviceId=deviceId;
    }
}
