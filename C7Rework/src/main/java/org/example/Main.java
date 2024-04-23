
package org.example;

public class Main {
    public static void main(String[] args) {
        Game game = new Game(6, 3);
        game.start();

        TimeKeeper timeKeeper = new TimeKeeper(game, 10000);
        Thread timeKeeperThread = new Thread(timeKeeper);
        timeKeeperThread.setDaemon(true);
        timeKeeperThread.start();

        try {
            timeKeeperThread.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        Player winner = game.determineWinner();
        if (winner != null) {
            System.out.println("The winner is " + winner.getName() + " with a score of " + winner.getMaxSequenceLength());
        } else {
            System.out.println("No winner could be determined.");
        }
    }
}