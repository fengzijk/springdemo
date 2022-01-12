package com.fengzijk.springdemo.pojo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import lombok.experimental.FieldNameConstants;





/**
*-------------------------------------------------
* <pre>功能描述:</pre>
* @author : fengzijk
* @email: guozhifengvip@gmail.com
* @date : 2021/8/9 下午6:51
*--------------------------------------------------
*/
@EqualsAndHashCode(callSuper = true)
@Data
@Accessors(chain = true)
@FieldNameConstants
@TableName("short_param_url")
public class ShortParamEntity extends BaseEntity implements Serializable {
    @TableId(type = IdType.ASSIGN_ID)
    private Long id;

    @TableField("start_ip")
    private String md5Code;

    @TableField("original_param")
    private String originalParam;
    @TableField("short_param")
    private String shortParam;
    @TableField("redirect_url")
    private String redirectUrl;

    /**
     * 1 url 2 参数
     */
    private Integer type;

    private static final long serialVersionUID = 1L;


}