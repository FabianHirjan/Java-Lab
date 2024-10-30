package org.example;

public class Tile {
    private int value1;
    private int value2;

    public Tile(int value1, int value2) {
        this.value1 = value1;
        this.value2 = value2;
    }

    public int getValue1() {
        return value1;
    }

    public int getValue2() {
        return value2;
    }

    public boolean equals(Tile other) {
        return this.value1 == other.value1 && this.value2 == other.value2;
    }

    public String toString() {
        return "(" + value1 + ", " + value2 + ")";
    }
}