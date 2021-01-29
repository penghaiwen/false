
package com.socket.controller;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.socket.configuration.WebSocketAutoConfig;
import com.socket.pojo.RequestMessage;
import com.socket.pojo.ResponseMessage;
import com.sys.vo.UserInfoVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * ********************
 *
 * @author yangke
 * @version 1.0
 * @created 2019年6月6日 下午3:26:39
 * **********************
 */
@RestController
@RequestMapping("/msg")
@Api(tags = "消息")
public class WebSocketController {

    @Autowired
    private SimpMessagingTemplate messagingTemplate;// 使用模板发送

    @MessageMapping(WebSocketAutoConfig.FORE_TO_SERVER_PATH)
    @SendTo(WebSocketAutoConfig.PRODUCER_PATH) // SendTo 发送至 Broker 下的指定订阅路径
    public void say(RequestMessage clientMessage) throws InterruptedException, JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();

        ResponseMessage responseMessage = new ResponseMessage("string", "收到的消息为:" + clientMessage.getContent());

        messagingTemplate.convertAndSend(WebSocketAutoConfig.PRODUCER_PATH, objectMapper.writeValueAsString(responseMessage));
    }

    @PostMapping("send")
    @ApiOperation(value = "发送消息",notes = "老默" )
    public void send(String msg) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        ResponseMessage responseMessage = new ResponseMessage("string", "收到的消息为:" + msg);
        messagingTemplate.convertAndSend(WebSocketAutoConfig.PRODUCER_PATH, objectMapper.writeValueAsString(responseMessage));
    }


    @PostMapping("send/user")
    @ApiOperation(value = "发送消息",notes = "老默" )
    public void sendUser(String msg,String userId) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        ResponseMessage responseMessage = new ResponseMessage("string", "消息为:" + msg);
        messagingTemplate.convertAndSend(WebSocketAutoConfig.P2P_PUSH_BASE_PATH+"/"+userId+"/msg", objectMapper.writeValueAsString(responseMessage));
    }
}