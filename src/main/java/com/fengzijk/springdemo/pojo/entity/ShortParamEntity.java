package com.fengzijk.springdemo.pojo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import lombok.experimental.FieldNameConstants;

import java.io.Serializable;





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

    private String md5Code;

    private String originalParam;

    private String shortParam;

    private String redirectUrl;

    /**
     * 1 url 2 参数
     */
    private Integer type;

    private static final long serialVersionUID = 1L;


}