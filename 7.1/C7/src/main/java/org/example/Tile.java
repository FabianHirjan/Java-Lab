package org.example;

public class Tile {
        private final int num1;
        private final int num2;

        public Tile(int num1, int num2) {
            this.num1 = num1;
            this.num2 = num2;
        }

        @Override
        public String toString() {
            return "(" + num1 + "," + num2 + ")";
        }
}
