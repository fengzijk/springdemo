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
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * <pre>功能描述:</pre>
 *
 * @author : fengzijk
 * @email: guozhifengvip@gmail.com
 * @date : 2021/9/21 12:52 上午
 */
@Data
@Accessors
public class ShortParamDTO implements Serializable {
    private static final long serialVersionUID = 6143628633832376527L;
    private String md5Code;
    private String originalParam;
    private String shortParam;
    private String redirectUrl;
}
