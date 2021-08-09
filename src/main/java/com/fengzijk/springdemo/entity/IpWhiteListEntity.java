package com.fengzijk.springdemo.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import lombok.experimental.FieldNameConstants;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

/**
*-------------------------------------------------
* <pre>功能描述</pre>
* @className  : IpWhiteList
* @author : fengzijk
* @email: guozhifengvip@gmail.com
* @date : 2021/8/9 下午5:57
*--------------------------------------------------
*/
@EqualsAndHashCode(callSuper = true)
@Data
@Accessors(chain = true)
@FieldNameConstants
@TableName("ip_white_list")
public class IpWhiteListEntity extends BaseEntity implements Serializable {
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

    private static final long serialVersionUID = 1L;
}