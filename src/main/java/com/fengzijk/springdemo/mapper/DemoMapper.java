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

package com.fengzijk.springdemo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.fengzijk.springdemo.entity.DemoEntity;
import org.apache.ibatis.annotations.Options;
import org.springframework.stereotype.Repository;

/**
 * <pre>功能描述:</pre>   repeatable-read
 *
 * @author fengzijk
 * @email: guozhifengvip@gmail.com
 * @date 2021/9/21 12:45 上午
 */
@Repository
public interface DemoMapper extends BaseMapper<DemoEntity> {

   @Options(flushCache=Options.FlushCachePolicy.TRUE)
   DemoEntity selectByxxId(Long id);
}
