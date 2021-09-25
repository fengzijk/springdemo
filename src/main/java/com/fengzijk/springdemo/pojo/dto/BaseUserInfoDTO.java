package com.fengzijk.springdemo.pojo.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.io.Serializable;
/**
*-------------------------------------------------
* <pre>用户基础信息</pre>
* @className  : BaseUserInfoDTO
* @author : fengzijk
* @email: guozhifengvip@gmail.com
* @date : 2021/8/9 下午6:02
*--------------------------------------------------
*/
@Getter
@Setter
@Accessors(chain = true)
@ToString
public class BaseUserInfoDTO implements Serializable {

    private Long userId;
    private Long userName;
}
