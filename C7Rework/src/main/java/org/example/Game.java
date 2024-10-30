// Game.java
package org.example;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private final List<Player> players;
    private final List<Thread> playerThreads;
    private final Bag bag;
    private final int n;

    public Game(int n, int playersCount) {
        this.n = n;
        this.bag = new Bag();
        this.players = new ArrayList<>();
        this.playerThreads = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            bag.addToken(new Token(i, (i % n) + 1));
        }

        for (int i = 0; i < playersCount; i++) {
            players.add(new Player("Player " + (i + 1), bag));
        }
    }

    public void start() {
        players.forEach(player -> {
            Thread thread = new Thread(player);
            playerThreads.add(thread);
            thread.start();
        });
    }

    public void stop() {
        bag.endGame();
        for (Thread thread : playerThreads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }

    public Player determineWinner() {
        Player winner = null;
        int maxScore = 0;

        for (Player player : players) {
            int score = player.getMaxSequenceLength();
            if (score > maxScore) {
                maxScore = score;
                winner = player;
            }
        }

        return winner;
    }
}