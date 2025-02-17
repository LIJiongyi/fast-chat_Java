package com.example.fastChat.client;

import javax.swing.*;

public class App {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                ClientGUI clientGUI = new ClientGUI("Kelly");
                clientGUI.setVisible(true); //让窗口显示我们的配置

            }
        });
    }
}
