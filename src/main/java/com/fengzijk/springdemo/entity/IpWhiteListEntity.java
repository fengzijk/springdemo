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

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import javax.validation.constraints.NotEmpty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import lombok.experimental.FieldNameConstants;

/**
 * <pre>功能描述</pre>
 *
 * @author : fengzijk
 * @className : IpWhiteList
 * @email: guozhifengvip@gmail.com
 * @date : 2021/8/9 下午5:57
 */
@EqualsAndHashCode(callSuper = true)
@Data
@Accessors(chain = true)
@FieldNameConstants
@TableName("ip_white_list")
public class IpWhiteListEntity extends BaseEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * 主键
     */
    @NotEmpty
    private Long id;
    @NotEmpty
    private String type;
    /**
     * 状态
     */
    @NotEmpty
    private Boolean state;
    /**
     * 开始IP
     */
    @NotEmpty
    @TableField("start_ip")
    private String startIp;
    /**
     * 结束ip
     */
    @NotEmpty
    @TableField("end_ip")
    private String endIp;
}
