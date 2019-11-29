package com.rabbitmq.workfair;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.util.ConnectionUtils;

public class Send {
    private static final String QUEUE_NAME="rabbit_work_test";
    public static void main(String[] args) throws Exception {
        // 获取连接
        Connection connection = ConnectionUtils.getConnection();
        // 创建队列
        Channel channel = connection.createChannel();

        // 消费者发送者确认之前，消息队列不发送到消费者，一次只处理一个消息，限制消费者发送给同一消费者 不得超过一条消息
        channel.basicQos(1);

        channel.queueDeclare(QUEUE_NAME,false,false,false,null);

        for (int i = 0; i < 50; i++) {
            String msg = "hello " + i;
            channel.basicPublish("",QUEUE_NAME,null,msg.getBytes());
            System.out.println("send msg to rabbitmq:" + msg);
            Thread.sleep(i*5);
        }
        channel.close();
        connection.close();
    }
}
