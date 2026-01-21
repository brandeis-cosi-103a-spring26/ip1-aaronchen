package edu.brandeis.cosi103a.ip1;

public class AutomationCard extends Card {
    private int apValue;

    public AutomationCard(String name, int cost, int apValue) {
        this.name = name;
        this.cost = cost;
        this.apValue = apValue;
    }

    public int getApValue() {
        return apValue;
    }
}
