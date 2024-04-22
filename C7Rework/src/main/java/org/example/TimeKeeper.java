package org.example;

public class TimeKeeper implements Runnable {
    private final Game game;
    private final long startTime;
    private final long timeLimit;

    public TimeKeeper(Game game, long timeLimit) {
        this.game = game;
        this.startTime = System.currentTimeMillis();
        this.timeLimit = timeLimit;
    }

    @Override
    public void run() {
        while (true) {
            long runningTime = System.currentTimeMillis() - startTime;
            System.out.println("Running time: " + runningTime + " ms");

            if (runningTime > timeLimit) {
                System.out.println("Time limit exceeded. Stopping the game.");
                try {
                    game.stop();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
                break;
            }

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}