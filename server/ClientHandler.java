package server;

import java.net.*;
import java.io.*;
import java.sql.*;

import database.DBConnection;

public class ClientHandler implements Runnable{

    Socket socket;

    BufferedReader reader;

    PrintWriter writer;

    String username;

    public ClientHandler(Socket socket){

        this.socket=socket;
    }

    public String getUsername(){

        return username;
    }

    public void run(){

        try{

            reader=new BufferedReader(
            new InputStreamReader(socket.getInputStream()));

            writer=new PrintWriter(
            socket.getOutputStream(),true);

            username=reader.readLine();

            saveUser(username);

            ChatServer.usernames.add(username);

            ChatServer.broadcast(username+" joined 😊",this);

            ChatServer.updateUsers();

            String msg;

            while((msg=reader.readLine())!=null){

                saveMessage(username,msg);

                ChatServer.broadcast(username+": "+msg,this);
            }

        }
        catch(Exception e){

            System.out.println(username+" disconnected");
        }
        finally{

            ChatServer.removeClient(this);

            ChatServer.broadcast(username+" left",this);
        }
    }

    void sendMessage(String msg){

        writer.println(msg);
    }

    void saveUser(String username){

        try{

            Connection con=DBConnection.getConnection();

            String sql=
            "INSERT IGNORE INTO users(username) VALUES(?)";

            PreparedStatement ps=
            con.prepareStatement(sql);

            ps.setString(1,username);

            ps.executeUpdate();

        }
        catch(Exception e){

            e.printStackTrace();
        }
    }

    void saveMessage(String user,String msg){

        try{

            Connection con=DBConnection.getConnection();

            String sql=
            "INSERT INTO messages(username,message) VALUES(?,?)";

            PreparedStatement ps=
            con.prepareStatement(sql);

            ps.setString(1,user);

            ps.setString(2,msg);

            ps.executeUpdate();

        }
        catch(Exception e){

            e.printStackTrace();
        }
    }
}