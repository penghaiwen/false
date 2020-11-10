package com.redis;

import com.alibaba.fastjson.JSONObject;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.listener.PatternTopic;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.data.redis.listener.adapter.MessageListenerAdapter;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class RedisMessageListener implements MessageListener {
    @Resource
    private RedisTemplate<String, JSONObject> redisTemplate;

    /**
     *功能描述 重写
     * @author 老默
     * @date 2020/5/21
     * @time 14:33
     * @param message
     * @param bytes
     * @return void
     */
    @Override
    public void onMessage(Message message, byte[] bytes) {
         String channel = redisTemplate.getStringSerializer().deserialize(message.getChannel());
         Object msgVal = redisTemplate.getKeySerializer().deserialize(message.getBody());
         System.out.println("key--"+channel);
         System.out.println("msg--"+msgVal);
    }


    /**
     *功能描述 创建工厂连接
     * @author 老默
     * @date 2020/5/21
     * @time 14:31
     * @param connectionFactory
     * @param listenerAdapter
     * @return org.springframework.data.redis.listener.RedisMessageListenerContainer
     */
    @Bean
    RedisMessageListenerContainer container(RedisConnectionFactory connectionFactory,
                                            MessageListenerAdapter listenerAdapter) {
        RedisMessageListenerContainer container = new RedisMessageListenerContainer();
        container.setConnectionFactory(connectionFactory);
        // 测试
        container.addMessageListener(listenerAdapter, new PatternTopic("TEST"));
        return container;
    }

    /**
     *功能描述 绑定消息监听者和接收监听的方法
     * @author 老默
     * @date 2020/5/21
     * @time 14:32
     * @param receiver
     * @return org.springframework.data.redis.listener.adapter.MessageListenerAdapter
     */
    @Bean
    MessageListenerAdapter listenerAdapter(RedisMessageListener receiver) {
        return new MessageListenerAdapter(receiver);
    }
}
