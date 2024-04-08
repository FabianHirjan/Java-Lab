package org.example;

import java.util.ArrayList;
import java.util.List;

public class Game {

    private final Bag bag = new Bag();
    private final List<Player> players = new ArrayList<>();

    public void addPlayer(String playerName) {
        Player player = new Player(playerName);
        players.add(player);
        player.setGame(this.bag);
    }


    public void play() {
        for (Player player : players) {
            player.start();
        }
    }



    public static void main(String args[]) {
        Game game = new Game();

        game.addPlayer("Player 1");
        game.addPlayer("Player 2");
        game.addPlayer("Player 3");
        game.play();
    }
}
