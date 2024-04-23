package org.example;

import java.util.LinkedList;
import java.util.List;

public class Bag {
    private final List<Token> tokens;
    private boolean gameEnded = false;

    public Bag() {
        this.tokens = new LinkedList<>();
    }

    public synchronized void addToken(Token token) {
        tokens.add(token);
        notifyAll();
    }

    public synchronized Token removeToken() throws InterruptedException {
        while (tokens.isEmpty() && !gameEnded) {
            wait();
        }
        return tokens.isEmpty() ? null : tokens.remove(0);
    }

    public synchronized void endGame() {
        gameEnded = true;
        notifyAll();
    }
}
