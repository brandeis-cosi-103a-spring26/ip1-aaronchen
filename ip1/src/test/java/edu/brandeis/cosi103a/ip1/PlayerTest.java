package edu.brandeis.cosi103a.ip1;

import static org.junit.Assert.*;
import org.junit.Test;

public class PlayerTest {

    @Test
    public void playerDrawsFiveCards() {
        Player player = new Player();
        for (int i = 0; i < 10; i++) {
            player.addToDrawPile(new CryptoCard("Bitcoin", 0, 1));
        }

        player.shuffleDrawPile();
        player.drawHand(5);

        assertEquals(5, player.getHand().size());
    }

    @Test
    public void cryptoCardsGenerateCoins() {
        Player player = new Player();
        player.getHand().add(new CryptoCard("Bitcoin", 0, 1));
        player.getHand().add(new CryptoCard("Ethereum", 3, 2));
        player.getHand().add(new AutomationCard("Method", 2, 1));

        int coins = player.playCryptoCards();
        assertEquals(3, coins);
    }

    @Test
    public void cleanupDiscardsHandAndDrawsNewHand() {
        Player player = new Player();
        for (int i = 0; i < 10; i++) {
            player.addToDrawPile(new CryptoCard("Bitcoin", 0, 1));
        }

        player.drawHand(5);
        player.cleanup();

        assertEquals(5, player.getHand().size());
    }

    @Test
    public void totalAPCountsAllZones() {
        Player player = new Player();
        player.addToDrawPile(new AutomationCard("Method", 2, 1));
        player.addToDrawPile(new AutomationCard("Module", 5, 3));
        player.gainCard(new AutomationCard("Framework", 8, 6));

        assertEquals(10, player.totalAP());
    }
}
