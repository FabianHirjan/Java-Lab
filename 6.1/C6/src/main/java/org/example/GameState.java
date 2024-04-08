package org.example;
import java.io.Serializable;
import java.awt.Point;
import java.util.List;

public class GameState implements Serializable {
    private static final long serialVersionUID = 1L;

    private final List<Point> redStones;
    private final List<Point> blueStones;

    public GameState(List<Point> redStones, List<Point> blueStones) {
        this.redStones = redStones;
        this.blueStones = blueStones;
    }

    public List<Point> getRedStones() {
        return redStones;
    }

    public List<Point> getBlueStones() {
        return blueStones;
    }
}
