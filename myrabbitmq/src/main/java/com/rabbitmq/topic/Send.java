package com.rabbitmq.topic;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.util.ConnectionUtils;

public class Send {
    private static final String EXCHANGE_NAME = "test_exchange_topic";
    public static void main(String[] args) throws Exception{
        Connection connection = ConnectionUtils.getConnection();
        Channel channel = connection.createChannel();
        //channel.basicQos(1);
        channel.exchangeDeclare(EXCHANGE_NAME,"topic");
        String msg = "商品!";

        channel.basicPublish(EXCHANGE_NAME,"good.add",null,msg.getBytes());
        System.out.println("Send ：" + msg);

        channel.close();
        connection.close();
    }
}
