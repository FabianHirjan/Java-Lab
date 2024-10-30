package org.example;

import java.net.Socket;
import java.util.concurrent.LinkedBlockingQueue;

class GameLobby {
    private LinkedBlockingQueue<Socket> players = new LinkedBlockingQueue<>(2);

    public boolean addPlayer(Socket player) throws InterruptedException {
        return players.offer(player);
    }

    public boolean isFull() {
        return players.size() == 2;
    }

    public Socket[] getPlayers() throws InterruptedException {
        return players.toArray(new Socket[2]);
    }
}
