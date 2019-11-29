package com.rabbitmq.work;

import com.rabbitmq.client.*;
import com.rabbitmq.util.ConnectionUtils;

import java.io.IOException;

public class Recv2 {
    private static final String QUEUE_NAME="rabbit_work_test";

    public static void main(String[] args)throws Exception {
        Connection connection = ConnectionUtils.getConnection();
        Channel channel = connection.createChannel();
        channel.queueDeclare(QUEUE_NAME,false,false,false,null);
        Consumer consumer = new DefaultConsumer(channel){
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                String msg = new String (body,"utf-8");
                System.out.println("[2] Recv msg :" + msg);
                try{
                    Thread.sleep(2000);
                }catch (Exception e){
                    e.printStackTrace();
                }finally{
                    System.out.println("[2] done");
                }
                //super.handleDelivery(consumerTag, envelope, properties, body);
            }
        };
        boolean autoAck = true;
        channel.basicConsume(QUEUE_NAME,autoAck,consumer);
    }
}
