package org.example.mq.rocketmq.async;

import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendCallback;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.common.RemotingHelper;

import java.util.concurrent.CountDownLatch;

/**
 * @author qiqiang
 * @date 2020-10-30 2:08 下午
 */
public class AsyncProducer {
    public static void main(String[] args) throws Exception {
        // 实例化消息生产者Producer
        DefaultMQProducer producer = new DefaultMQProducer("sync-producer-group");
        // 设置NameServer的地址
        producer.setNamesrvAddr("localhost:9876");
        // 启动Producer实例
        producer.start();
        int count = 100;
        CountDownLatch countDownLatch = new CountDownLatch(100);
        for (int i = 0; i < count; i++) {
            // 创建消息，并指定Topic，Tag和消息体
            Message msg = new Message("TopicTest",
                    "TagA",
                    ("Hello RocketMQ " + i).getBytes(RemotingHelper.DEFAULT_CHARSET)
            );
            // 发送消息到一个Broker
            producer.send(msg, new SendCallback() {
                @Override
                public void onSuccess(SendResult sendResult) {
                    System.out.printf("%s%n", sendResult);
                    countDownLatch.countDown();
                }

                @Override
                public void onException(Throwable throwable) {
                    System.err.printf("%s%n", throwable.getMessage());
                }
            });
        }
        countDownLatch.await();
        // 如果不再发送消息，关闭Producer实例。
        producer.shutdown();
    }
}