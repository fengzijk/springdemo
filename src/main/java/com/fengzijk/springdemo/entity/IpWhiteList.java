package com.fengzijk.springdemo.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.experimental.Accessors;
import lombok.experimental.FieldNameConstants;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * ip_white_list
 */
@TableName("ip_white_list")
@Data
@Accessors(chain = true)
@FieldNameConstants
public class IpWhiteList implements Serializable {
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
    private Byte state;

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

    /**
     * 创建时间
     */
    @TableField("create_time")
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    @TableField("update_time")
    private LocalDateTime updateTime;

    private static final long serialVersionUID = 1L;
}