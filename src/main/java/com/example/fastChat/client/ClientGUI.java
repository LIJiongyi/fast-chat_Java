package com.example.fastChat.client;

import com.example.fastChat.Message;

import java.util.concurrent.ExecutionException;

public class ClientGUI {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        MyStompClient myStompClient = new MyStompClient("Kelly");
        myStompClient.sendMessage(new Message("Kelly", "Hello World!"));

    }
}
