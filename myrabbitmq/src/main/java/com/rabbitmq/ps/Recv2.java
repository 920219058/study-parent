package com.rabbitmq.ps;

import com.rabbitmq.client.*;
import com.rabbitmq.util.ConnectionUtils;

import java.io.IOException;

public class Recv2 {
    private static final String  QUEUE_NAME = "test_queue_fanout_2";
    private static final String EXCHANGE_NAME = "test_exchange_fanout";
    public static void main(String[] args) throws Exception{
        Connection connection = ConnectionUtils.getConnection();
        Channel channel = connection.createChannel();
        //声明队列
        channel.queueDeclare(QUEUE_NAME,false,false,false,null);
        // 绑定队列到交换机 转发器
        channel.queueBind(QUEUE_NAME,EXCHANGE_NAME,"");

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
                //super.handleDelivery(consumerTag, envelope, properties, body);
            }
        };
        boolean autoAck = true;
        channel.basicConsume(QUEUE_NAME,autoAck,consumer);
    }
}
