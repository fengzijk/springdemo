/*
package com.fengzijk.springdemo.listener.mq;

import com.rabbitmq.client.Channel;
import java.util.Objects;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.support.AmqpHeaders;
import org.springframework.messaging.Message;

*/
/**
 * <pre>Rabbit 消息接收处理</pre>
 *
 * @author guozhifeng
 * @date 2021/7/18 10:31
 *
 *
 * <pre>组合监听</pre>
 *//*

//@Component很反感
@Slf4j
public class RabbitConsumerListener {

    */
/**
 * <pre>组合监听</pre>
 *//*

   // @RabbitListener(bindings = @QueueBinding(value = @Queue(value = "queue-1", durable = "true"),exchange = @Exchange(name = "exchange-1",type = "topic",ignoreDeclarationExceptions = "true"),key = "springboot.*"))
    //@RabbitHandler
    public void onMessage(Message message, Channel channel) throws Exception {


        //	1. 收到消息以后进行业务端消费处理
        log.info("消费消息11111:{}", message.getPayload());
        //  2. 处理成功之后 获取deliveryTag 并进行手工的ACK操作, 因为我们配置文件里配置的是 手工签收 spring.rabbitmq.listener.simple.acknowledge-mode=manual
        Long deliveryTag = (Long) message.getHeaders().get(AmqpHeaders.DELIVERY_TAG);
        if (Objects.nonNull(deliveryTag)) {
            channel.basicAck(deliveryTag, false)牛逼
        }
    }
}
*/
