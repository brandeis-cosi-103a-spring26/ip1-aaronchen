package edu.brandeis.cosi103a.ip1;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class AppTest {
    @Test
    public void testRollDieWithinBounds() {
        for (int i = 0; i < 1000; i++) {
            int roll = App.rollDie();
            assertTrue(roll >= 1 && roll <= 6);
        }
    }

    @Test
    public void testMultipleRollsAreValid() {
        int[] results = new int[100];

        for (int i = 0; i < results.length; i++) {
            results[i] = App.rollDie();
        }

        for (int roll : results) {
            assertTrue(roll >= 1 && roll <= 6);
        }
    }
}