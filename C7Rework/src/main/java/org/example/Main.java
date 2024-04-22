package org.example;

public class Main {
    public static void main(String[] args) {
        Game game = new Game(5, 3); // 5 tokens, 3 players
        game.start();

        TimeKeeper timeKeeper = new TimeKeeper(game, 30000); // 30 seconds time limit
        Thread timeKeeperThread = new Thread(timeKeeper);
        timeKeeperThread.setDaemon(true);
        timeKeeperThread.start();

        try {
            game.stop();
            Player winner = game.determineWinner();
            System.out.println("The winner is " + winner.getName() + " with a score of " + winner.getMaxSequenceLength());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}