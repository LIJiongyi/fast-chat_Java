package com.example.fastChat.client;

import javax.swing.*;
import java.util.concurrent.ExecutionException;

public class App {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                String username = JOptionPane.showInputDialog(null, "Enter your username (Max: 16 Characters):",
                        "FastChat", JOptionPane.QUESTION_MESSAGE);

                if(username == null || username.isEmpty() || username.length() > 16) {
                    JOptionPane.showMessageDialog(null,
                            "Invalid username",
                            "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                ClientGUI clientGUI = null;
                try {
                    clientGUI = new ClientGUI(username);
                } catch (ExecutionException e) {
                    throw new RuntimeException(e);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                clientGUI.setVisible(true); //让窗口显示我们的配置

            }
        });
    }
}
