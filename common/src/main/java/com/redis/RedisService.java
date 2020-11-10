package com.redis;

public interface RedisService {

    boolean setList(String key, Object value);

    Object getListByKey(String key);

    void sendMsg(String key,Object msg);



}
