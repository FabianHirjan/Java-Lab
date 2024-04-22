package org.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Bag {
    private final List<Tile> tiles;

    public Bag() {
        tiles = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            int num1 = (int) (Math.random() * 10) + 1;
            tiles.add(new Tile(num1));
        }
        Collections.shuffle(tiles);
    }

    public synchronized List<Tile> extractTiles(int howMany) {
        List<Tile> extracted = new ArrayList<>();
        for (int i = 0; i < howMany; i++) {
            if (tiles.isEmpty()) {
                break;
            }
            extracted.add(tiles.remove(0));
        }
        return extracted;
    }

    public boolean isEmpty() {
        return tiles.isEmpty();
    }
}
