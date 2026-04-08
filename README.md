# Java Chat Application using Socket Programming

## Project Overview
This project is a real-time chat application developed using Java Socket Programming with a WhatsApp-style graphical user interface. The system follows a client-server architecture that allows multiple users to communicate simultaneously over a network.

The application demonstrates networking concepts, GUI development, multithreading, and database connectivity using JDBC. It provides a simple and user-friendly interface for sending and receiving messages instantly.

---

## Features
- Real-time messaging between multiple users
- WhatsApp-style chat user interface
- Online users list display
- Emoji support in messages
- Client-server architecture
- Database connectivity using JDBC
- Multiple clients can connect simultaneously
- Simple and easy-to-use GUI

---

## Technologies Used
- Java
- Java Swing (GUI)
- Socket Programming
- MySQL Database
- JDBC (Java Database Connectivity)
- Multithreading
- VS Code / IntelliJ IDE

---

## System Architecture
This application follows a Client-Server Architecture.

Client sends message → Server receives message → Server broadcasts message → Other clients receive message.

The server handles multiple users at the same time using multithreading.

---

## Project Structure

Chatapp
│
├── client
│ ├── ChatClient.java
│ ├── ChatGUI.java
│ ├── LoginGUI.java
│
├── server
│ ├── ChatServer.java
│ ├── ClientHandler.java
│
├── database
│ ├── DBConnection.java
│
└── README.md


---

## How to Run the Project

### Step 1 Compile the project
Open terminal in project folder and run:


javac database/.java
javac server/.java
javac client/*.java


---

### Step 2 Start Server
Run the server first:


java server.ChatServer


Server will start and wait for users to connect.

---

### Step 3 Run Client
Open two separate terminals and run:


java client.LoginGUI


Enter different usernames for each user.

Example:
User 1 → Rajesh  
User 2 → Bhumika  

Now both users can chat in real-time.

---

## Output
- Users can send and receive messages instantly.
- Messages appear in chat bubble format similar to WhatsApp.
- Online users list is displayed on the right side.
- Multiple users can chat at the same time.

---

## Database Used
MySQL database is used in the project.

Database connection is implemented using JDBC.

Example:
Database Name: chatapp

Purpose of database:
- Store user related information
- Manage data for chat application

---

## Modules of the Project

### Login Module
Allows users to enter username and join the chat.

### Client Module
Handles sending and receiving messages from the server.

### Server Module
Manages multiple clients and forwards messages.

### GUI Module
Displays chat interface using Java Swing.

### Database Module
Handles database connection using JDBC.

---

## Applications
- Instant messaging systems
- Online communication platforms
- Customer support chat systems
- Team collaboration tools
- Social networking chat features

---

## Advantages
- Real-time communication
- Supports multiple users
- Simple user interface
- Easy to understand implementation
- Demonstrates networking concepts

---

## Future Enhancements
- Private chat option
- Group chat feature
- File sharing (images, documents)
- Profile picture support
- Message timestamps
- Dark theme UI
- Message encryption

---

## Author
R Rajesh
MCA Student

---

## Conclusion
This project demonstrates how real-time communication applications work using Java Socket Programming. It provides hands-on experience with networking, GUI development, multithreading, and database connectivity. The project forms a strong foundation for developing real-world chat applications similar to WhatsApp or Telegram.
