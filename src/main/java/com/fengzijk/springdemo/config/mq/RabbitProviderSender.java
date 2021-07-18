package com.fengzijk.springdemo.config.mq;

import com.fengzijk.springdemo.util.JacksonUtil;
import java.util.Map;
import java.util.UUID;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.MessagePostProcessor;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

/**
 * -------------------------------------------------
 * <pre>mq 发送消息</pre>
 *
 * @author : guozhifeng
 * @date : 2021/7/18 10:45
 * --------------------------------------------------
 */
@Component
@Slf4j
public class RabbitProviderSender {

    @Autowired
    private RabbitTemplate rabbitTemplate;


    /**
     * 对外发送消息的方法
     *
     * @param message 具体的消息内容
     * @param properties 额外的附加属性
     */
    public void send(Object message, Map<String, Object> properties) {

        MessageHeaders mhs = new MessageHeaders(properties);
        Message<?> msg = MessageBuilder.createMessage(message, mhs);
              String jsonMsg= JacksonUtil.bean2Json(msg);
        // 	指定业务唯一的iD
        CorrelationData correlationData = new CorrelationData(UUID.randomUUID().toString());
        MessagePostProcessor mpp = message1 -> {
            log.info("发送消息：{} ", message1);
            return message1;
        };

        rabbitTemplate.convertAndSend("exchange-1", "springboot.rabbit", jsonMsg, mpp, correlationData);

    }
}