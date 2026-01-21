package edu.brandeis.cosi103a.ip1;

import static org.junit.Assert.*;
import org.junit.Test;

public class AppTest {

    @Test
    public void buyingCardReducesSupply() {
        Supply supply = new Supply();
        Card card = supply.buyCard(8);

        assertNotNull(card);
        assertTrue(card.getCost() <= 8);
    }

    @Test
    public void cannotBuyUnaffordableCard() {
        Supply supply = new Supply();
        Card card = supply.buyCard(1);

        assertNotNull(card);
        assertEquals(0, card.getCost());
    }

    @Test
    public void frameworksGoneWhenEmpty() {
        Supply supply = new Supply();

        for (int i = 0; i < 8; i++) {
            supply.buyCard(100);
        }

        assertTrue(supply.frameworksGone());
    }

    @Test
    public void starterCardsComeFromSupply() {
        Supply supply = new Supply();
        Card bitcoin = supply.takeStarter("Bitcoin");

        assertNotNull(bitcoin);
        assertEquals("Bitcoin", bitcoin.getName());
    }
}