package com.redis.impl;

import com.alibaba.fastjson.JSON;
import com.redis.DelayingQueueService;
import com.redis.dto.Message;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class DelayingQueueServiceImpl implements DelayingQueueService{
    @Resource
    private StringRedisTemplate stringRedisTemplate;
    @Override
    public boolean push(Message msg) {
        Boolean add = stringRedisTemplate.opsForZSet().add(msg.getChannel(), JSON.toJSONString(msg), msg.getDelayTime());
        return add;
    }

    @Override
    public boolean remove(Message msg) {
        Long removeSize = stringRedisTemplate.opsForZSet().remove(msg.getChannel(), JSON.toJSONString(msg));
        return removeSize>0?true:false;
    }

    @Override
    public List<Message> pull(String channel) {
        Set<String> strings = stringRedisTemplate.opsForZSet().rangeByScore(channel, 0, System.currentTimeMillis());
        if (strings == null) {
            return null;
        }
        List<Message> msgList = strings.stream().map(msg -> {
            Message message = null;
            try {
                message = JSON.parseObject(msg, Message.class);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return message;
        }).collect(Collectors.toList());
        return msgList;
    }


}
