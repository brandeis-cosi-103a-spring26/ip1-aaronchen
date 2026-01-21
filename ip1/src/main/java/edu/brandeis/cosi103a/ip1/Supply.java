package edu.brandeis.cosi103a.ip1;

import java.util.*;

public class Supply {
    private Map<Card, Integer> piles = new HashMap<>();

    public Supply() {
        piles.put(new AutomationCard("Method", 2, 1), 14);
        piles.put(new AutomationCard("Module", 5, 3), 8);
        piles.put(new AutomationCard("Framework", 8, 6), 8);

        piles.put(new CryptoCard("Bitcoin", 0, 1), 60);
        piles.put(new CryptoCard("Ethereum", 3, 2), 40);
        piles.put(new CryptoCard("Dogecoin", 6, 3), 30);
    }

    public Card buyCard(int coins) {
        Card best = null;

        for (Card c : piles.keySet()) {
            if (piles.get(c) > 0 && c.getCost() <= coins) {
                if (best == null || c.getCost() > best.getCost()) {
                    best = c;
                }
            }
        }

        if (best != null) {
            piles.put(best, piles.get(best) - 1);
        }
        return best;
    }

    public boolean frameworksGone() {
        for (Card c : piles.keySet()) {
            if (c.getName().equals("Framework")) {
                return piles.get(c) == 0;
            }
        }
        return false;
    }

    public Card takeStarter(String name) {
        for (Card c : piles.keySet()) {
            if (c.getName().equals(name) && piles.get(c) > 0) {
                piles.put(c, piles.get(c) - 1);
                return c;
            }
        }
        return null;
    }
}
