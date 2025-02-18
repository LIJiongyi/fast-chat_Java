package com.example.fastChat.client;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class ClientGUI extends JFrame {
    private JPanel connectedUsersPanel, messagePanel;

    public ClientGUI(String username){
        super("User " + username);
        setSize(1218, 685);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e){ //确认用户是否退出
                int userOption = JOptionPane.showConfirmDialog(ClientGUI.this, "Do you really want to leave?",
                        "Exit", JOptionPane.YES_NO_OPTION);
                if(userOption == JOptionPane.YES_OPTION){
                    ClientGUI.this.dispose(); //关闭窗口
                }
            }
        });

        getContentPane().setBackground(Utilities.PRIMARY_COLOR); //也可以选择其他颜色,在utilities里面
        addGuiComponents();
    }

    private void addGuiComponents(){
        addConnectedUserComponents();
        addChatComponents();
    }

    private void addConnectedUserComponents(){
        connectedUsersPanel = new JPanel();
        connectedUsersPanel.setLayout(new BoxLayout(connectedUsersPanel, BoxLayout.Y_AXIS));
        connectedUsersPanel.setBackground(Utilities.SECONDARY_COLOR);
        connectedUsersPanel.setPreferredSize(new Dimension(200, getHeight()));

        JLabel connectedUsersLabel = new JLabel("Connected Users"); //identify what left side is gonna be
        connectedUsersLabel.setFont(new Font("Inter", Font.BOLD, 18));
        connectedUsersLabel.setForeground(Utilities.TEXT_COLOR);
        connectedUsersPanel.add(connectedUsersLabel);

        add(connectedUsersPanel, BorderLayout.WEST);
    }


    private void addChatComponents(){
        JPanel chatPanel = new JPanel();
        chatPanel.setLayout(new BorderLayout());
        chatPanel.setBackground(Utilities.PRIMARY_COLOR);

        messagePanel = new JPanel();
        messagePanel.setLayout(new BoxLayout(messagePanel, BoxLayout.Y_AXIS));
        messagePanel.setBackground(Utilities.SECONDARY_COLOR);
        chatPanel.add(messagePanel, BorderLayout.CENTER);

        messagePanel.add(new JLabel("Kelly"));

        add(chatPanel, BorderLayout.CENTER);


    }

}
