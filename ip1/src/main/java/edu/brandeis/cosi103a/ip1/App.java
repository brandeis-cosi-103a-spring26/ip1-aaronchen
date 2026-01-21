package edu.brandeis.cosi103a.ip1;

import java.util.*;

public class App {
    public static void main( String[] args ) {
        Supply supply = new Supply();
        Player p1 = new Player();
        Player p2 = new Player();

        // Starter decks
        for (int i = 0; i < 7; i++) {
            p1.addToDrawPile(supply.takeStarter("Bitcoin"));
            p2.addToDrawPile(supply.takeStarter("Bitcoin"));
        }
        for (int i = 0; i < 3; i++) {
            p1.addToDrawPile(supply.takeStarter("Method"));
            p2.addToDrawPile(supply.takeStarter("Method"));
        }

        p1.shuffleDrawPile();
        p2.shuffleDrawPile();
        p1.drawHand(5);
        p2.drawHand(5);

        Player current = new Random().nextBoolean() ? p1 : p2;

        while (!supply.frameworksGone()) {
            int coins = current.playCryptoCards();
            Card bought = supply.buyCard(coins);
            if (bought != null) {
                current.gainCard(bought);
            }
            current.cleanup();
            current = (current == p1) ? p2 : p1;
        }

        int p1Score = p1.totalAP();
        int p2Score = p2.totalAP();

        System.out.println("Game Over!");
        System.out.println("Player 1 AP: " + p1Score);
        System.out.println("Player 2 AP: " + p2Score);
        System.out.println(p1Score > p2Score ? "Player 1 Wins!" :
                           p2Score > p1Score ? "Player 2 Wins!" :
                           "It's a Tie!");
    }
}
