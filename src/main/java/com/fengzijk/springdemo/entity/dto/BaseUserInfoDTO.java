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

package com.fengzijk.springdemo.entity.dto;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * <pre>用户基础信息</pre>
 *
 * @author : fengzijk
 * @className : BaseUserInfoDTO
 * @email: guozhifengvip@gmail.com
 * @date : 2021/8/9 下午6:02
 */
@Getter
@Setter
@Accessors(chain = true)
@ToString
public class BaseUserInfoDTO implements Serializable {

    private Long userId;
    private Long userName;
}
