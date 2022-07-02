/*
 *   All rights Reserved, Designed By ZTE-ITS
 *   Copyright:    Copyright(C) 2019-2025
 *   Company       FENGZIJK LTD.
 *   @Author:    fengzijk
 *   @Email: guozhifengvip@163.com
 *   @Version    V1.0
 *   @Date:   2022年07月02日 14时33分
 *   Modification       History:
 *   ------------------------------------------------------------------------------------
 *   Date                  Author        Version        Description
 *   -----------------------------------------------------------------------------------
 *  2022-07-02 14:33:03    fengzijk         1.0         Why & What is modified: <修改原因描述>
 *
 *
 */

package com.fengzijk.springdemo.config.redis;

//
//@Configuration
//public class SerializerConfig {
//    @Bean
//    public LocalDateTimeSerializer localDateTimeDeserializer() {
//        return new LocalDateTimeSerializer(DateTimeFormatter.ofPattern(DateUtil.DATE_TIME_PATTERN));
//    }
//
//    @Bean
//    public LocalDateSerializer localDateDeserializer() {
//        return new LocalDateSerializer(DateTimeFormatter.ofPattern(DateUtil.DATE_TIME_PATTERN));
//    }
//
//    @Bean
//    public ObjectMapper serializingObjectMapper() {
//        JavaTimeModule module = new JavaTimeModule();
//        LocalDateTimeDeserializer localDateTimeDeserializer =
//                new LocalDateTimeDeserializer(DateTimeFormatter.ofPattern(DateUtil.DATE_TIME_PATTERN));
//        module.addDeserializer(LocalDateTime.class, localDateTimeDeserializer);
//        return Jackson2ObjectMapperBuilder.json()
//                .modules(module)
//                .serializerByType(Long.class, ToStringSerializer.instance)
//                .serializerByType(Long.TYPE, ToStringSerializer.instance)
//                .serializerByType(LocalDateTime.class, localDateTimeDeserializer())
//                .serializerByType(LocalDate.class, localDateDeserializer())
//                .featuresToDisable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS)
//                .build();
//    }
//}
