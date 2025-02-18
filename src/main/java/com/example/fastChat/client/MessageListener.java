package com.example.fastChat.client;

import java.util.ArrayList;

import com.example.fastChat.Message;

public interface MessageListener {
    void onMessageRecieve(Message message);
    void onActiveUserUpdated(ArrayList<String> users);
}
