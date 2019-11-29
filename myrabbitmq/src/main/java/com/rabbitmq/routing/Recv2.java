package com.rabbitmq.routing;

import com.rabbitmq.client.*;
import com.rabbitmq.util.ConnectionUtils;

import java.io.IOException;

public class Recv2 {
    private static final String QUEUE_NAME = "test_queue_direct2";
    private static final String EXCHANGE_NAME = "test_exchange_direct";
    public static void main(String[] args)throws Exception {
        Connection connection = ConnectionUtils.getConnection();
        Channel channel = connection.createChannel();
        channel.queueDeclare(QUEUE_NAME,false,false,false,null);

        channel.basicQos(1);
        channel.queueBind(QUEUE_NAME,EXCHANGE_NAME,"error");
        channel.queueBind(QUEUE_NAME,EXCHANGE_NAME,"info");
        //channel.queueBind(QUEUE_NAME,EXCHANGE_NAME,"debug");
        Consumer consumer = new DefaultConsumer(channel){
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                String msg = new String (body,"utf-8");
                System.out.println("[2] Recv msg :" + msg);
                try{
                    Thread.sleep(200);
                }catch (Exception e){
                    e.printStackTrace();
                }finally{
                    System.out.println("[2] done");
                }
            }
        };
        boolean autoAck = false;
        channel.basicConsume(QUEUE_NAME,autoAck,consumer);
    }
}
