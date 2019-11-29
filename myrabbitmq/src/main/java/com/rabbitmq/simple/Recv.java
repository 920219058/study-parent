package com.rabbitmq.simple;

import com.rabbitmq.client.*;
import com.rabbitmq.util.ConnectionUtils;

import java.io.IOException;

public class Recv {
    private static String QUEUE_NAME = "rabbit_test";
    public static void main(String[] args) throws Exception{
        //获取连接
        Connection connection = ConnectionUtils.getConnection();
        // 创建频道
        Channel character = connection.createChannel();
        // 队列声明
        character.queueDeclare(QUEUE_NAME,false,false,false,null);
        //定义一个消费者
        DefaultConsumer consumer = new DefaultConsumer(character){
            //获取达到的消息
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                String msg = new String(body,"utf-8");
                System.out.println("new api recv :" + msg);
                //super.handleDelivery(consumerTag, envelope, properties, body);
            }
        };
        // 监听队列
        character.basicConsume(QUEUE_NAME,true,consumer);
          
    }
}
