package client;

import java.net.*;
import java.io.*;

public class ChatClient{

    Socket socket;

    PrintWriter writer;

    BufferedReader reader;

    ChatGUI gui;

    public ChatClient(String username,ChatGUI gui){

        this.gui=gui;

        try{

            socket=new Socket("localhost",5000);

            writer=new PrintWriter(
            socket.getOutputStream(),true);

            reader=new BufferedReader(
            new InputStreamReader(socket.getInputStream()));

            writer.println(username);

            new Thread(this::readMessages).start();

        }
        catch(Exception e){

            e.printStackTrace();
        }
    }

    void sendMessage(String msg){

        writer.println(msg);
    }

    void readMessages(){

        try{

            String msg;

            while((msg=reader.readLine())!=null){

                if(msg.startsWith("USERS")){

                    gui.updateUsers(msg.substring(6));
                }
                else{

                    gui.showMessage(msg);
                }
            }

        }
        catch(Exception e){}
    }
}