package com.weiwei.mqTest;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.jms.*;

/**
 * Created by weiwei on 2017/5/15.
 */
public class Receiver {
    private static final Logger LOGGER = LoggerFactory.getLogger(Receiver.class);

    public static void main(String[] args) {
        // ConnectionFactory ：连接工厂，JMS 用它创建连接
        ConnectionFactory connectionFactory;
        // Connection ：JMS 客户端到JMS Provider 的连接
        Connection connection = null;
        // Session： 一个发送或接收消息的线程
        Session session;
        // Destination ：消息的目的地;消息发送给谁.
        Destination destination;
        // 消费者，消息接收者
        MessageConsumer consumer;
        connectionFactory = new ActiveMQConnectionFactory(
                ActiveMQConnection.DEFAULT_USER,
                ActiveMQConnection.DEFAULT_PASSWORD, "tcp://localhost:61616");
        try {
            // 构造从工厂得到连接对象
            connection = connectionFactory.createConnection();
            // 启动
            connection.start();
            // 获取操作连接
            session = connection.createSession(false,
                    Session.CLIENT_ACKNOWLEDGE);
            // 获取session注意参数值是一个服务器的queue，须在在ActiveMq的console配置
            destination = session.createQueue("queue-0001");
            consumer = session.createConsumer(destination);
//            while (true) {
//                TextMessage message = (TextMessage) consumer.receive(30000);
//                if (null != message) {
//                    System.out.println("收到消息: " + message.getText());
//                } else {
//                    break;
//                }
//            }
            for (int i = 0; i < 5; i++) {
                TextMessage message = (TextMessage) consumer.receive(300000);
                if (i % 2 == 0) {
                    message.acknowledge();
                }
                if (null != message) {
                    LOGGER.info("收到消息: " + message.getText());
                } else {
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (null != connection)
                    connection.close();
            } catch (Throwable ignore) {

            }
        }
    }
}
