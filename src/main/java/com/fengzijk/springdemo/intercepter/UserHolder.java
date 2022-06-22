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

package com.fengzijk.springdemo.intercepter;


import com.fengzijk.springdemo.entity.dto.BaseUserInfoDTO;

/**
 * <pre>用户基础新封装</pre>
 *
 * @author : fengzijk
 * @email: guozhifengvip@gmail.com
 * @date : 2021/8/9 下午6:05
 */
public class UserHolder {
    private static final ThreadLocal<BaseUserInfoDTO> USER_HOLDER = new InheritableThreadLocal<>();

    public static void add(BaseUserInfoDTO loginInfo) {
        USER_HOLDER.set(loginInfo);
    }

    public static BaseUserInfoDTO getCurrentUser() {

        return USER_HOLDER.get();
    }

    public static void remove() {
        USER_HOLDER.remove();
    }
}
