package client;

import java.awt.*;
import javax.swing.*;

public class ChatGUI {

    JFrame frame = new JFrame("Chat");

    JPanel chatPanel = new JPanel();

    JScrollPane scrollPane;

    JTextField messageField = new JTextField();

    DefaultListModel<String> users =
            new DefaultListModel<>();

    JList<String> userList =
            new JList<>(users);

    ChatClient client;

    String username;

    public ChatGUI(String username){

        this.username = username;

        client = new ChatClient(username,this);

        frame.setLayout(new BorderLayout());

        // chat area like whatsapp
        chatPanel.setLayout(new BoxLayout(chatPanel,BoxLayout.Y_AXIS));

        chatPanel.setBackground(Color.white);

        scrollPane =
                new JScrollPane(chatPanel);

        // users list
        userList.setBorder(
                BorderFactory.createTitledBorder("Online"));

        userList.setPreferredSize(new Dimension(120,0));

        // bottom input area
        JPanel bottom =
                new JPanel(new BorderLayout());

        JButton send =
                new JButton("Send");

        bottom.add(messageField,BorderLayout.CENTER);

        bottom.add(send,BorderLayout.EAST);

        // emoji panel
        JPanel emojiPanel =
                new JPanel();

        String[] emoji =
                {"😊","😂","😍","👍","❤️","🔥"};

        for(String e:emoji){

            JButton b = new JButton(e);

            b.setFocusPainted(false);

            b.addActionListener(x ->
                    messageField.setText(
                            messageField.getText()+e));

            emojiPanel.add(b);
        }

        frame.add(emojiPanel,BorderLayout.NORTH);

        frame.add(scrollPane,BorderLayout.CENTER);

        frame.add(new JScrollPane(userList),BorderLayout.EAST);

        frame.add(bottom,BorderLayout.SOUTH);

        send.addActionListener(e -> sendMessage());

        messageField.addActionListener(e -> sendMessage());

        frame.setSize(600,450);

        frame.setVisible(true);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    void sendMessage(){

        String msg = messageField.getText();

        if(msg.isEmpty()) return;

        addBubble("You: "+msg,true);

        client.sendMessage(msg);

        messageField.setText("");
    }

    void showMessage(String msg){

        addBubble(msg,false);
    }

    void addBubble(String text, boolean isMe){

        JPanel bubble =
                new JPanel(new BorderLayout());

        JTextArea label =
                new JTextArea(text);

        label.setLineWrap(true);

        label.setWrapStyleWord(true);

        label.setEditable(false);

        label.setFont(new Font("Segoe UI",Font.PLAIN,14));

        label.setBorder(
                BorderFactory.createEmptyBorder(5,10,5,10));

        if(isMe){

            bubble.setLayout(new FlowLayout(FlowLayout.RIGHT));

            label.setBackground(new Color(220,248,198));

        }
        else{

            bubble.setLayout(new FlowLayout(FlowLayout.LEFT));

            label.setBackground(new Color(240,240,240));
        }

        bubble.setBackground(Color.white);

        bubble.add(label);

        chatPanel.add(bubble);

        chatPanel.revalidate();

        JScrollBar vertical =
                scrollPane.getVerticalScrollBar();

        vertical.setValue(vertical.getMaximum());
    }

    void updateUsers(String list){

        users.clear();

        for(String u:list.split(",")){

            users.addElement(u);
        }
    }
}