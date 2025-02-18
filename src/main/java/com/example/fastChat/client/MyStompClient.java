package com.example.fastChat.client;

import com.example.fastChat.Message;
import org.springframework.messaging.converter.MappingJackson2MessageConverter;
import org.springframework.messaging.simp.stomp.StompSession;
import org.springframework.messaging.simp.stomp.StompSessionHandler;
import org.springframework.web.socket.client.standard.StandardWebSocketClient;
import org.springframework.web.socket.messaging.WebSocketStompClient;
import org.springframework.web.socket.sockjs.client.Transport;
import org.springframework.web.socket.sockjs.client.WebSocketTransport;
import org.springframework.web.socket.sockjs.client.SockJsClient;

import  java.util.List;
import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

public class MyStompClient { // Stomp的意思是简单文本定向消息,是一种协议
    private StompSession session;
    private String username; // store the username of the client

    public MyStompClient(MessageListener messageListener, String username) throws ExecutionException, InterruptedException {
        this.username = username;

        List<Transport> transports = new ArrayList<>();
        transports.add(new WebSocketTransport(new StandardWebSocketClient()));

        SockJsClient sockJsClient = new SockJsClient(transports);
        WebSocketStompClient stompClient = new WebSocketStompClient(sockJsClient);
        stompClient.setMessageConverter(new MappingJackson2MessageConverter());

        StompSessionHandler sessionHandler = new MyStompSessionHandler(messageListener, username);
        String url = "ws://localhost:8080/ws";  // ws stands for Websocket

        session = stompClient.connectAsync(url, sessionHandler).get(); //异步连接到websocket服务器. session是StompSession实例
    }

    public void sendMessage(Message message) { //这个方法对应controller class里的handlemessage方法
        try {
            session.send("/app/message", message);
            System.out.println("Message sent: " + message.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void disconnectUser(String username) {
        session.send("/app/disconnect", username);
        System.out.println("Disconnect user: " + username);
    }
}
