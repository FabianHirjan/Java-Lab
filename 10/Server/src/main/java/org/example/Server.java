package org.example;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class Server {
    public static final int PORT = 8100;
    private List<GameLobby> lobbies = new ArrayList<>();

    public Server() throws IOException {
        ServerSocket serverSocket = new ServerSocket(PORT);
        try {
            while (true) {
                System.out.println("Waiting for a client...");
                Socket socket = serverSocket.accept();
                System.out.printf("Client connected: %s:%d%n",
                        socket.getInetAddress(), socket.getPort());

                GameLobby lobby = findOrCreateLobby();
                synchronized (lobby) {
                    if (lobby.addPlayer(socket)) {
                        if (lobby.isFull()) {
                            Socket[] players = lobby.getPlayers();
                            startGame(players);
                        }
                    }
                }
            }
        } catch (IOException | InterruptedException e) {
            System.err.println("Ooops... " + e);
        } finally {
            serverSocket.close();
        }
    }

    private GameLobby findOrCreateLobby() {
        for (GameLobby lobby : lobbies) {
            if (!lobby.isFull()) {
                return lobby;
            }
        }
        GameLobby newLobby = new GameLobby();
        lobbies.add(newLobby);
        return newLobby;
    }

    private void startGame(Socket[] players) {
        new GameThread(players).start();
    }

    public static void main(String[] args) throws IOException {
        new Server();
    }
}
