package edu.brandeis.cosi103a.ip1;

public class CryptoCard extends Card {
    private int coinValue;

    public CryptoCard(String name, int cost, int coinValue) {
        this.name = name;
        this.cost = cost;
        this.coinValue = coinValue;
    }

    public int getCoinValue() {
        return coinValue;
    }
}
