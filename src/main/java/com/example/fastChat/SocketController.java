package com.example.fastChat;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

@Controller // handle the websocket request
public class SocketController {
    private final SimpMessagingTemplate messagingTemplate;

    @Autowired
    public SocketController(SimpMessagingTemplate messagingTemplate) {
        this.messagingTemplate = messagingTemplate;
    }

    @MessageMapping("/message")
    public void handleMessage(Message message) {
        System.out.println("Received message from user: " + message.getMessage());
        messagingTemplate.convertAndSend("/topic/message", message); //让服务器主动向客户端发消息
        System.out.println("Sent message to /topic/messages: " + message.getUser() + ": " + message.getMessage());
    }
}
