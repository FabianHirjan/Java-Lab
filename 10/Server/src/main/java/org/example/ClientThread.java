package org.example;

import java.io.*;
import java.net.Socket;

class ClientThread extends Thread {
    public static String processRequest (String request) {
        String response = "";
        if(request.equals("stop")) {
            response = "Server stopped";
        }
        else {
            response = "Server received the request: " + request;
        }
        return response;
    }
    private Socket socket = null ;
    public ClientThread (Socket socket) { this.socket = socket ; }
    public static void sendtoClient (DataOutputStream out, String message) throws IOException {
        out.writeUTF(message);
        out.flush();
        System.out.println("Server sent: " + message);
    }

    public static String receiveFromClient (DataInputStream in) throws IOException {
        String message = in.readUTF();
        System.out.println("Server received: " + message);
        return message;
    }

    public void run () {
        try {
            while(true) {
                DataInputStream in = new DataInputStream(socket.getInputStream());
                String request = receiveFromClient(in);
                String response = processRequest(request);
                DataOutputStream out = new DataOutputStream(socket.getOutputStream());
                sendtoClient(out, response);
                if(request.equals("stop")) {
                    break;
                }
            }
        } catch (IOException e) {
            System.err.println("Communication error... " + e);
        }
    }
}