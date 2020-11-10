package com.redis.impl;

import com.redis.RedisService;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class RedisServiceImpl implements RedisService {
    @Resource
    private RedisTemplate<String,Object> redisTemplate;



    @Override
    public boolean setList(String key, Object value) {
        Long push = redisTemplate.opsForList().rightPush(key, value);
        System.out.println("保存数组--"+push);
        return false;
    }

    @Override
    public Object getListByKey(String key) {

        return redisTemplate.opsForList().range(key,0,-1);
    }

    @Override
    public void sendMsg(String key, Object msg) {
        redisTemplate.convertAndSend(key,msg);
    }


}
