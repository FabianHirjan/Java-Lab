package org.example;

import java.io.*;
import java.net.Socket;

public class Client {
    public static void sendToServer(DataOutputStream out, String message) throws IOException {
        out.writeUTF(message);
        out.flush();
        System.out.println("Client sent: " + message);
    }

    public static String receiveFromServer(DataInputStream in) throws IOException {
        String message = in.readUTF();
        System.out.println("Client received: " + message);
        return message;
    }

    public static void main(String[] args) {
        String serverAddress = "127.0.0.1";
        int PORT = 8100;
        try (
                Socket socket = new Socket(serverAddress, PORT);
                DataOutputStream out = new DataOutputStream(socket.getOutputStream());
                DataInputStream in = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
                BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in))
        ) {
            while (true) {
                String serverMessage = receiveFromServer(in);
                if (serverMessage.startsWith("Game started!")) {
                    System.out.println(serverMessage);
                    break;
                }
            }

            while (true) {
                System.out.println("Type your move, or 'stop' to quit:");
                String userInput = keyboard.readLine();
                sendToServer(out, userInput);

                String response = receiveFromServer(in);
                System.out.println("Response from server: " + response);

                if (userInput.equals("stop")) {
                    break;
                }
            }
        } catch (IOException e) {
            System.err.println("An error occurred: " + e.getMessage());
        }
    }
}
