package org.example;

import java.util.ArrayList;
import java.util.List;

public class Player implements Runnable {
    private final String name;
    private final Bag bag;
    private final List<Token> sequence;
    private int maxSequenceLength;

    public Player(String name, Bag bag) {
        this.name = name;
        this.bag = bag;
        this.sequence = new ArrayList<>();
        this.maxSequenceLength = 0;
    }

    @Override
    public void run() {
        try {
            while (true) {
                long startTime = System.currentTimeMillis();
                Token token = bag.removeToken();
                if (token == null) break; // stop when the bag is empty
                long extractionTime = System.currentTimeMillis() - startTime;
                addTokenToSequence(token);
                System.out.println(name + " extracted a token: (" + token.first + ", " + token.second + ") in " + extractionTime + " ms");
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    private void addTokenToSequence(Token token) {
        sequence.add(token);
        maxSequenceLength = Math.max(maxSequenceLength, sequence.size());
    }

    public int getMaxSequenceLength() {
        return maxSequenceLength;
    }

    public String getName() {
        return name;
    }
}