package com.fengzijk.springdemo.pojo.dto;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
/**
*-------------------------------------------------
* <pre>功能描述:</pre>
* @author : fengzijk
* @email: guozhifengvip@gmail.com
* @date : 2021/9/21 12:52 上午
*--------------------------------------------------
*/
@Data
@Accessors
public class ShortParamDTO implements Serializable {
    private String md5Code;

    private String originalParam;

    private String shortParam;

    private String redirectUrl;

    private static final long serialVersionUID = 6143628633832376527L;
}
