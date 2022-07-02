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

package com.fengzijk.springdemo.service;

import com.fengzijk.springdemo.entity.ShortParamEntity;

/**
 * <pre>短连接或者参数缩短</pre>
 *
 * @author fengzijk
 * @email: guozhifengvip@gmail.com
 * @date 2021/8/9 下午6:54
 */
public interface IShortParamService {

    /**
     * <pre> 查询md5Code是否存在 </pre>
     *
     * @param md5Code MD5code
     * @return java.lang.Boolean
     * @date 2021/8/9 下午7:00
     */
    Boolean isExistByMd5Code(String md5Code);

    /**
     * <pre>功能描述</pre>
     *
     * @param type
     * @param param
     * @return com.fengzijk.springdemo.entity.ShortParamEntity
     * @author fengzijk
     * @date 2022/4/9 02:31
     */
    ShortParamEntity longToShort(String type, String param);

    String shortToLong(String shortParam);

    String longToShortUrl();

}
