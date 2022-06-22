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

package com.fengzijk.springdemo.common.response;

import lombok.Getter;

@Getter
public enum ResponseStatusEnum {

    /**
     * 请求成功
     */
    OK(200, "请求成功"),

    /**
     * 请求失败
     */
    BAD_REQUEST(400, "请求失败"),

    /**
     * 请求失败
     */
    NO_HANDLER(404, "资源不存在"),
    /**
     * 系统内部错误
     */
    SYSTEM_ERROR(500, "系统内部错误");


    private Integer code;
    private String msg;

    ResponseStatusEnum(Integer code, String name) {
        this.code = code;
        this.msg = name;
    }


    public static String getMsgByCode(Integer code) {
        if (code != null) {
            for (ResponseStatusEnum e : values()) {
                if (e.getCode().equals(code)) {
                    return e.getMsg();
                }
            }
        }
        return null;
    }

    public static ResponseStatusEnum getByCode(Integer code) {
        if (code != null) {
            for (ResponseStatusEnum e : values()) {
                if (e.getCode().equals(code)) {
                    return e;
                }
            }
        }
        return null;
    }
}
