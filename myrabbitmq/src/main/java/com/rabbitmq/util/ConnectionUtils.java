package com.rabbitmq.util;

import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.impl.AMQImpl;

public class ConnectionUtils {
    /**
     * 获取连接
     * @return
     */
    public static Connection getConnection() throws Exception{
        //定义一个连接工厂
        ConnectionFactory factory = new ConnectionFactory();

        //设置服务器地址
        factory.setHost("127.0.0.1");

        //AMQP 5672
        factory.setVirtualHost("/test");

        //用户名
        factory.setUsername("wuqihui");
        factory.setPassword("wuqihui");

        return factory.newConnection();
    }
}
