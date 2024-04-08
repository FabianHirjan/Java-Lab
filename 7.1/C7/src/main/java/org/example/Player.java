package org.example;

import java.util.List;

public class Player implements Runnable {

    private boolean running = true;
    private String name;
    private Bag gameBag;

    public Player(String name) {
        this.name = name;
        this.running = true; // Adaugă această linie
    }


    public void setGame(Bag gameBag) {
        this.gameBag = gameBag;
    }

    @Override
    public void run() {
        while (running) {
            List<Tile> myTiles = gameBag.extractTiles(7);

            if (!myTiles.isEmpty()) {
                System.out.println(name + " picked tiles: " + myTiles);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } else {
                System.out.println(name + " couldn't pick tiles. Bag is empty.");
                stop();
            }
        }
    }


    public void start() {
        running = true;
        new Thread(this).start();
    }


    public void stop() {
        running = false;
    }
}
