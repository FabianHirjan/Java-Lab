package org.example;

import java.util.*;

public class Player implements Runnable {
    private String name;
    private Game game;
    private boolean running;

    private int score = 0;
    private List<Tile> tiles = new ArrayList<Tile>();

    public Player(String name) {
        this.name = name;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public int getScore() {
        return score;
    }

    public List<Tile> getTiles() {
        return tiles;
    }

    public void run() {
        running = true;
        while (running) {
            synchronized (game) {
                try {
                    game.waitForTurn(this);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                List<Tile> extractedTiles = game.getBag().extractTiles(1);
                if (extractedTiles.isEmpty()) {
                    running = false;
                    break;
                }
                Tile extractedTile = extractedTiles.get(0);
                tiles.add(extractedTile);
                System.out.println(name + " extracted " + extractedTile + " from the bag");

                if (extractedTile.getValue1() == extractedTile.getValue2()) {
                    System.out.println(name + " extracted a double tile!");
                    score += 1;
                }
                game.playerFinished(this);
            }

            try {
                Thread.sleep(30);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }




    public String getName() {
        return name;
    }
}