package org.example;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

class GameThread extends Thread {
    private Socket player1;
    private Socket player2;

    public GameThread(Socket[] players) {
        this.player1 = players[0];
        this.player2 = players[1];
    }

    @Override
    public void run() {
        try (
                DataInputStream in1 = new DataInputStream(player1.getInputStream());
                DataOutputStream out1 = new DataOutputStream(player1.getOutputStream());
                DataInputStream in2 = new DataInputStream(player2.getInputStream());
                DataOutputStream out2 = new DataOutputStream(player2.getOutputStream())
        ) {
            out1.writeUTF("Game started! You are Player 1.");
            out2.writeUTF("Game started! You are Player 2.");

            while (true) {
                String move1 = in1.readUTF();
                out2.writeUTF("Player 1 move: " + move1);

                String move2 = in2.readUTF();
                out1.writeUTF("Player 2 move: " + move2);

                // Add game logic and win condition checks here
                if (move1.equals("stop") || move2.equals("stop")) {
                    break;
                }
            }
        } catch (IOException e) {
            System.err.println("Game communication error... " + e);
        }
    }
}
