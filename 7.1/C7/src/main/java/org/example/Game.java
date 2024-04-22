package org.example;


import java.util.ArrayList;
import java.util.List;

public class Game {
    private final Bag bag = new Bag(30);
    private final List<Player> players = new ArrayList<>();
    private int currentPlayerIndex = 0;
    private boolean gameEnded = false;
    private int activePlayers = 0;

    public synchronized void addPlayer(Player player) {
        players.add(player);
        player.setGame(this);
    }

    public synchronized void playerFinished(Player player) {
        activePlayers--;
        if (bag.isEmpty()) {
            gameEnded = true;
            determineWinner();
        } else {
            notifyNextPlayer();
        }
    }

    public synchronized void waitForTurn(Player player) throws InterruptedException {
        while (!isPlayerTurn(player) || gameEnded) {
            wait();
        }
    }

    public synchronized void notifyNextPlayer() {
        currentPlayerIndex = (currentPlayerIndex + 1) % players.size();
        notifyAll();
    }

    public synchronized boolean isPlayerTurn(Player player) {
        return players.indexOf(player) == currentPlayerIndex && !gameEnded;
    }

    public void start(long timeLimit) {
        for (Player player : players) {
            new Thread(player).start();
            activePlayers++;
        }
        TimeKeeper timeKeeper = new TimeKeeper(this, timeLimit);
        timeKeeper.start();
        synchronized (this) {
            notifyNextPlayer();
        }
    }

    public synchronized boolean isGameEnded() {
        return gameEnded;
    }

    public synchronized void endGame() {
        gameEnded = true;
        notifyAll();
    }

    void determineWinner() {
        List<Player> winners = new ArrayList<>();
        int maxScore = Integer.MIN_VALUE;

        for (Player player : players) {
            int playerScore = player.getScore();
            if (playerScore > maxScore) {
                maxScore = playerScore;
                winners.clear();
                winners.add(player);
            } else if (playerScore == maxScore) {
                winners.add(player);
            }
        }

        for (Player player : players) {
            System.out.println(player.getName() + " score: " + player.getScore() + " | number of tiles chosen: " + player.getTiles().size());
        }

        if (!winners.isEmpty()) {
            System.out.print("Winner(s): ");
            for (int i = 0; i < winners.size(); i++) {
                Player winner = winners.get(i);
                System.out.print(winner.getName());
                if (i < winners.size() - 1) {
                    System.out.print(", ");
                }
            }
            System.out.println(" with a score of " + maxScore);
        } else {
            System.out.println("No winner.");
        }
    }


    public Bag getBag() {
        return bag;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public static void main(String[] args) {
        Game game = new Game();
        game.addPlayer(new Player("Player 1"));
        game.addPlayer(new Player("Player 2"));
        game.addPlayer(new Player("Player 3"));
        game.start(2000);
    }
}