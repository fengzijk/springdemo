package com.fengzijk.springdemo.intercepter;


import com.fengzijk.springdemo.entity.dto.BaseUserInfoDTO;

/**
*-------------------------------------------------
* <pre>用户基础新封装</pre>

* @author : fengzijk
* @email: guozhifengvip@gmail.com
* @date : 2021/8/9 下午6:05
*--------------------------------------------------
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
