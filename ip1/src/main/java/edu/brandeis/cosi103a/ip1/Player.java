package edu.brandeis.cosi103a.ip1;

import java.util.*;

public class Player {
    private List<Card> drawPile = new ArrayList<>();
    private List<Card> discardPile = new ArrayList<>();
    private List<Card> hand = new ArrayList<>();

    public Player() {}

    public void shuffleDrawPile() {
        Collections.shuffle(drawPile);
    }

    public void drawHand(int count) {   //Take cards from draw pile to hand. If draw pile is empty, shuffle discard into draw pile.
        while (hand.size() < count) {
            if (drawPile.isEmpty()) {
                drawPile.addAll(discardPile);
                discardPile.clear();
                shuffleDrawPile();
            }
            if (drawPile.isEmpty()) break;
            hand.add(drawPile.remove(0));
        }
    }

    public int playCryptoCards() {      //Return total coin value of all CryptoCards in hand.
        int coins = 0;
        for (Card c : hand) {
            if (c instanceof CryptoCard) {
                coins += ((CryptoCard) c).getCoinValue();
            }
        }
        return coins;
    }

    public void cleanup() {     //Move all cards from hand to discard pile, then draw new hand of 5 cards.
        discardPile.addAll(hand);
        hand.clear();
        drawHand(5);
    }

    public void gainCard(Card card) {   //Add a card to the discard pile.
        discardPile.add(card);
    }

    public int totalAP() {      //Return total AP value of all AutomationCards in draw pile, discard pile, and hand.
        int total = 0;
        for (Card c : drawPile) {
            if (c instanceof AutomationCard) {
                total += ((AutomationCard) c).getApValue();
            }
        }
        for (Card c : discardPile) {
            if (c instanceof AutomationCard) {
                total += ((AutomationCard) c).getApValue();
            }
        }
        for (Card c : hand) {
            if (c instanceof AutomationCard) {
                total += ((AutomationCard) c).getApValue();
            }
        }
        return total;
    }

    public void addToDrawPile(Card card) {   //Add a card to the draw pile (used for starting deck).
        drawPile.add(card);
    }

    public List<Card> getHand() {       //Return current hand.
        return hand;
    }
}
