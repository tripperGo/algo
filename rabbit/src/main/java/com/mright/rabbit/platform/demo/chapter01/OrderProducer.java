package com.mright.rabbit.platform.demo.chapter01;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.MessageProperties;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @author: mright
 * @date: Created in 2020/5/24 3:19 PM
 * @desc:
 */
public class OrderProducer {
    private static final String EXCHANGE_NAME = "exchange_order";
    private static final String ROUTING_KEY = "routingkey_order";
    private static final String QUEUE_NAME = "queue_order";
    private static final String IP_ADDRESS = "192.168.31.52";
    private static final int PORT = 5672;

    public static void main(String[] args) throws IOException, TimeoutException {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost(IP_ADDRESS);
        factory.setPort(PORT);
        factory.setUsername("zhaochuanzhen");
        factory.setPassword("zhen092510");
        Connection conn = factory.newConnection();
        Channel channel = conn.createChannel();
        // 创建一个type='direct'，持久化的，非自动删除的交换器
        channel.exchangeDeclare(EXCHANGE_NAME, "direct", true, false, null);
        // 创建一个持久化的，非排他的，非自动删除的队列
        channel.queueDeclare(QUEUE_NAME, true, false, false, null);
        // 将交换器于队列通过路由键绑定
        channel.queueBind(QUEUE_NAME, EXCHANGE_NAME, ROUTING_KEY);
        String message = "订单ID：002；订单名称：5G手机；订单金额：5999¥";
        channel.basicPublish(EXCHANGE_NAME, ROUTING_KEY, MessageProperties.PERSISTENT_TEXT_PLAIN, message.getBytes());
        channel.close();
        conn.close();
    }
}
