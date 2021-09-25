package com.fengzijk.springdemo.pojo.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;
/**
*-------------------------------------------------
* <pre>数据库基础字段</pre>
* @className  : BaseEntity
* @author : fengzijk
* @email: guozhifengvip@gmail.com
* @date : 2021/8/9 下午5:56
*--------------------------------------------------
*/
@Data
@Accessors(chain = true)
public class BaseEntity implements Serializable {

    private static final long serialVersionUID = -9039853980855787753L;
    /**
     * 创建人ID
     */
    @TableField(fill = FieldFill.INSERT)
    protected Long createId;

    /**
     * 更新人ID
     */
    @TableField(fill = FieldFill.INSERT_UPDATE)
    protected Long updateId;

    /**
     * 创建时间
     */
    @TableField(fill = FieldFill.INSERT)
    protected LocalDateTime createTime;

    /**
     * 更新时间
     */
    @TableField(fill = FieldFill.INSERT_UPDATE)
    protected LocalDateTime updateTime;

}
