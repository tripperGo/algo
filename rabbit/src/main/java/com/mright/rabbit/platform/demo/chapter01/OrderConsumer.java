package com.mright.rabbit.platform.demo.chapter01;

import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * @author: mright
 * @date: Created in 2020/5/24 3:33 PM
 * @desc:
 */
public class OrderConsumer {
    private static final String QUEUE_NAME = "queue_order";
    private static final String IP_ADDRESS = "192.168.31.52";
    private static final int PORT = 5672;

    public static void main(String[] args) throws IOException, TimeoutException, InterruptedException {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setUsername("zhaochuanzhen");
        factory.setPassword("zhen092510");
        Connection conn = factory.newConnection(new Address[]{new Address(IP_ADDRESS, PORT)});
        Channel channel = conn.createChannel();
        channel.basicQos(64);
        Consumer consumer = new DefaultConsumer(channel) {
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                System.out.println("收到消息：" + new String(body));
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                channel.basicAck(envelope.getDeliveryTag(), false);
            }
        };

        channel.basicConsume(QUEUE_NAME, consumer);
        TimeUnit.SECONDS.sleep(5);
        channel.close();
        conn.close();
    }
}
