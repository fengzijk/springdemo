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

package com.fengzijk.springdemo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import lombok.experimental.FieldNameConstants;


/**
 * <pre>功能描述:</pre>
 *
 * @author : fengzijk
 * @email: guozhifengvip@gmail.com
 * @date : 2021/8/9 下午6:51
 */
@EqualsAndHashCode(callSuper = true)
@Data
@Accessors(chain = true)
@FieldNameConstants
@TableName("short_param_url")
public class ShortParamEntity extends BaseEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    @TableId(type = IdType.ASSIGN_ID)
    private Long id;
    private String md5Code;
    private String originalParam;
    private String shortParam;
    private String redirectUrl;
    /**
     * 1 url 2 参数
     */
    private Integer type;


}
