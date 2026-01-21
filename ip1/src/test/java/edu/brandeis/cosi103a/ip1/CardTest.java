package edu.brandeis.cosi103a.ip1;

import static org.junit.Assert.*;
import org.junit.Test;

public class CardTest {

    @Test
    public void testCryptoCard() {
        CryptoCard c = new CryptoCard("Bitcoin", 5, 3);
        assertTrue(c.getName().equals("Bitcoin"));
        assertTrue(c.getCost() == 5);
        assertTrue(c.getCoinValue() == 3);
    }

    @Test
    public void testAutomationCard() {
        AutomationCard a = new AutomationCard("Method", 2, 1);
        assertTrue(a.getName().equals("Method"));
        assertTrue(a.getCost() == 2);
        assertTrue(a.getApValue() == 1);
    }
}