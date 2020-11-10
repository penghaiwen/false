package com.redis;

import com.redis.dto.Message;

import java.util.List;

public interface DelayingQueueService {

    boolean push(Message msg);

    boolean remove(Message msg);

    List<Message> pull(String channel);
}
