package com.rabbitmq.ps;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.util.ConnectionUtils;

public class Send {
    private static final String EXCHANGE_NAME = "test_exchange_fanout";
    public static void main(String[] args) throws Exception {
        Connection connection = ConnectionUtils.getConnection();
        Channel channel = connection.createChannel();
        //声明交换机
        channel.exchangeDeclare(EXCHANGE_NAME,"fanout");
        // 发送消息
        String msg = new String("hello ps");
        channel.basicPublish(EXCHANGE_NAME,"",null,msg.getBytes());
        System.out.println("Send :" + msg);
        channel.close();
        connection.close();
    }
}
