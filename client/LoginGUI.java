package client;

import javax.swing.*;
import java.awt.*;

public class LoginGUI{

    JFrame frame=new JFrame("Login");

    JTextField name=new JTextField();

    JButton btn=new JButton("Login");

    public LoginGUI(){

        frame.setLayout(new GridLayout(3,1));

        frame.add(new JLabel("Enter Username"));

        frame.add(name);

        frame.add(btn);

        btn.addActionListener(e->login());

        frame.setSize(250,150);

        frame.setVisible(true);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    void login(){

        new ChatGUI(name.getText());

        frame.dispose();
    }

    public static void main(String[] args){

        new LoginGUI();
    }
}