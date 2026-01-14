package edu.brandeis.cosi103a.ip1;

import java.util.Random;
import java.util.Scanner;

public class App {

    private static final int TURNS_PER_PLAYER = 10;
    private static final int MAX_REROLLS = 2;

    private static Scanner scanner = new Scanner(System.in);
    private static Random random = new Random();

    public static void main(String[] args) {
        startGame();
        scanner.close();
    }

    // Controls overall game flow
    private static void startGame() {
        int[] scores = {0, 0};

        System.out.println("=== Welcome to the Dice Game ===");

        for (int turn = 1; turn <= TURNS_PER_PLAYER; turn++) {
            System.out.println("\n--- Turn " + turn + " ---");
            playTurn(0, scores);
            playTurn(1, scores);
        }

        displayResults(scores);
    }

    // Handles a single player's turn
    private static void playTurn(int playerIndex, int[] scores) {
        System.out.println("\nPlayer " + (playerIndex + 1) + "'s turn");

        int roll = rollDie();
        int rerollsUsed = 0;

        while (rerollsUsed < MAX_REROLLS) {
            System.out.println("You rolled: " + roll);
            System.out.print("Re-roll? (y/n): ");

            String choice = scanner.nextLine().trim().toLowerCase();
            if (!choice.equals("y")) {
                break;
            }

            roll = rollDie();
            rerollsUsed++;
        }

        System.out.println("Final roll: " + roll);
        scores[playerIndex] += roll;
        System.out.println("Player " + (playerIndex + 1) + " total score: " + scores[playerIndex]);
    }

    // Rolls a 6-sided die
    static int rollDie() {
        return random.nextInt(1, 7);
    }

    // Displays final scores and winner
    private static void displayResults(int[] scores) {
        System.out.println("\n=== Game Over ===");
        System.out.println("Player 1 Score: " + scores[0]);
        System.out.println("Player 2 Score: " + scores[1]);

        if (scores[0] > scores[1]) {
            System.out.println("Player 1 wins!");
        } else if (scores[1] > scores[0]) {
            System.out.println("Player 2 wins!");
        } else {
            System.out.println("It's a tie!");
        }
    }
}