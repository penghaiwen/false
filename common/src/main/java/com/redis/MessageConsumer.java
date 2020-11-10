package com.redis;

import com.alibaba.fastjson.JSON;
import com.redis.dto.Message;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.List;

@Component
@Slf4j
public class MessageConsumer {
    @Resource
    private  DelayingQueueService delayingQueueService;

    /**
     * 定时消费队列中的数据
     * zset会对score进行排序 让最早消费的数据位于最前
     * 拿最前的数据跟当前时间比较 时间到了则消费
     */
    @Scheduled(cron = "*/5 * * * * *")
    public void consumer()  {
        List<Message> msgList = delayingQueueService.pull("TEST");
        if (null != msgList) {
            long current = System.currentTimeMillis();
            msgList.stream().forEach(msg -> {
                log.info("消息，{}",JSON.toJSONString(msg));
                // 已超时的消息拿出来消费
                if (current >= msg.getDelayTime()) {
                    try {
                        log.info("消费消息：{}:消息创建时间：{},消费时间：{}", JSON.toJSONString(msg), msg.getCreateTime(), LocalDateTime.now());
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    //移除消息
                    delayingQueueService.remove(msg);
                }
            });
        }
    }
}
