package com.rabbitmq.workfair;

import com.rabbitmq.client.*;
import com.rabbitmq.util.ConnectionUtils;

import java.io.IOException;

public class Recv {
    private static final String QUEUE_NAME="rabbit_work_test";

    public static void main(String[] args)throws Exception {
        Connection connection = ConnectionUtils.getConnection();
        Channel channel = connection.createChannel();
        channel.queueDeclare(QUEUE_NAME,false,false,false,null);

        // 消费者发送者确认之前，消息队列不发送到消费者，一次只处理一个消息
        channel.basicQos(1);

        Consumer consumer = new DefaultConsumer(channel){
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                String msg = new String (body,"utf-8");
                System.out.println("[1] Recv msg :" + msg);
                try{
                    Thread.sleep(2000);
                }catch (Exception e){
                    e.printStackTrace();
                }finally{
                    System.out.println("[1] done");
                    //手动回执消息
                    channel.basicAck(envelope.getDeliveryTag(),false);
                }
                //super.handleDelivery(consumerTag, envelope, properties, body);
            }
        };
        boolean autoAck = false; // 自动应答改成false
        channel.basicConsume(QUEUE_NAME,autoAck,consumer);
    }
}
