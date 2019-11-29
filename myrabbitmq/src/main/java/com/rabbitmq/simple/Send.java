package com.rabbitmq.simple;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.util.ConnectionUtils;

public class Send {
    private static final String QUEUE_NAME="rabbit_test";
    public static void main(String[] args) throws Exception {
        Connection connection = ConnectionUtils.getConnection();
        Channel channel = connection.createChannel();
        channel.queueDeclare(QUEUE_NAME,false,false,false,null);
        String msg = "hello simple";
        channel.basicPublish("",QUEUE_NAME,null,msg.getBytes());
        System.out.println("------------");
        channel.close();
        connection.close();
    }
}
