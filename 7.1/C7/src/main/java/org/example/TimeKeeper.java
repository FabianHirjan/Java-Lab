package org.example;


public class TimeKeeper extends Thread {
    private final Game game;
    private final long timeLimit;
    private volatile boolean timeExceeded;

    public TimeKeeper(Game game, long timeLimit) {
        this.game = game;
        this.timeLimit = timeLimit;
        this.timeExceeded = false;
        setDaemon(true);
    }

    @Override
    public void run() {
        long startTime = System.currentTimeMillis();
        while (!timeExceeded && !game.isGameEnded()) {
            long elapsedTime = System.currentTimeMillis() - startTime;
            if (elapsedTime >= timeLimit) {
                timeExceeded = true;
                game.endGame();
                System.out.println("Time limit exceeded. Stopping the game...");
                System.out.println("Time elapsed: " + elapsedTime + " milliseconds");
                game.determineWinner();
                break;
            }
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void setTimeExceeded(boolean timeExceeded) {
        this.timeExceeded = timeExceeded;
    }

}