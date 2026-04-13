package com.example.voting;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

/**
 * Main class for Voting Eligibility System
 * Processes multiple voter entries and validates their eligibility
 */
public class VotingEligibilitySystem {
    private List<Voter> voters;

    public VotingEligibilitySystem() {
        this.voters = new ArrayList<>();
    }

    /**
     * Add a voter to the system
     */
    public void addVoter(Voter voter) {
        voters.add(voter);
    }

    /**
     * Get input from user for one voter
     */
    public Voter getVoterInput(Scanner scanner, int voterNumber) {
        System.out.println("\n--- Voter " + voterNumber + " Details ---");

        System.out.print("Enter name: ");
        String name = scanner.nextLine().trim();

        System.out.print("Enter age: ");
        int age = 0;
        try {
            age = Integer.parseInt(scanner.nextLine().trim());
        } catch (NumberFormatException e) {
            System.out.println("Invalid age format. Setting age to 0.");
        }

        System.out.print("Enter citizenship (e.g., Indian): ");
        String citizenship = scanner.nextLine().trim();

        System.out.print("Enter voter ID: ");
        String voterId = scanner.nextLine().trim();

        System.out.print("Is voter ID valid? (yes/no): ");
        String idValidInput = scanner.nextLine().trim().toLowerCase();
        boolean validId = idValidInput.equals("yes") || idValidInput.equals("y");

        return new Voter(name, age, citizenship, voterId, validId);
    }

    /**
     * Display eligibility results for all voters
     */
    public void displayResults() {
        System.out.println("\n========================================");
        System.out.println("VOTING ELIGIBILITY RESULTS");
        System.out.println("========================================");

        if (voters.isEmpty()) {
            System.out.println("No voter records found.");
            return;
        }

        for (int i = 0; i < voters.size(); i++) {
            System.out.println("\n" + voters.get(i).getEligibilityMessage());
            if (i < voters.size() - 1) {
                System.out.println("----------------------------------------");
            }
        }

        System.out.println("\n========================================");
    }

    /**
     * Main method - Entry point of the program
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        VotingEligibilitySystem system = new VotingEligibilitySystem();

        System.out.println("========================================");
        System.out.println("VOTING ELIGIBILITY SYSTEM");
        System.out.println("========================================");

        boolean addMore = true;
        int voterCount = 0;

        while (addMore) {
            voterCount++;
            Voter voter = system.getVoterInput(scanner, voterCount);
            system.addVoter(voter);

            System.out.print("\nDo you want to add another voter? (yes/no): ");
            String response = scanner.nextLine().trim().toLowerCase();
            addMore = response.equals("yes") || addMore.equals("y");
        }

        system.displayResults();
        scanner.close();
    }
}