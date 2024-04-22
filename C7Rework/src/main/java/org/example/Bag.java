package org.example;

import java.util.LinkedList;
import java.util.List;

public class Bag {
    private final List<Token> tokens;

    public Bag() {
        this.tokens = new LinkedList<>();
    }

    public synchronized void addToken(Token token) {
        tokens.add(token);
        notifyAll();
    }

    public synchronized Token removeToken() throws InterruptedException {
        while (tokens.isEmpty()) {
            wait();
        }
        return tokens.remove(0);
    }
}
