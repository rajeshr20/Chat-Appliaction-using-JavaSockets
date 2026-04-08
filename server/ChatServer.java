package server;

import java.net.*;
import java.util.*;

public class ChatServer {

    static Set<ClientHandler> clients=new HashSet<>();

    static Set<String> usernames=new HashSet<>();

    public static void main(String[] args){

        System.out.println("Server started");

        try(ServerSocket serverSocket=new ServerSocket(5000)){

            while(true){

                Socket socket=serverSocket.accept();

                ClientHandler client=new ClientHandler(socket);

                clients.add(client);

                new Thread(client).start();
            }

        }
        catch(Exception e){

            e.printStackTrace();
        }
    }

    static void broadcast(String msg,ClientHandler exclude){

        for(ClientHandler c:clients){

            if(c!=exclude){

                c.sendMessage(msg);
            }
        }
    }

    static void updateUsers(){

        String userList="USERS "+String.join(",",usernames);

        for(ClientHandler c:clients){

            c.sendMessage(userList);
        }
    }

    static void removeClient(ClientHandler client){

        clients.remove(client);

        usernames.remove(client.getUsername());

        updateUsers();
    }
}