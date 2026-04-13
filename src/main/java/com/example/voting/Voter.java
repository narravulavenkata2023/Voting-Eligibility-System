package com.example.voting;

/**
 * Voter class to store voter details and validate eligibility
 */
public class Voter {
    private String name;
    private int age;
    private String citizenship;
    private String voterId;
    private boolean validId;

    /**
     * Constructor to initialize voter details
     */
    public Voter(String name, int age, String citizenship, String voterId, boolean validId) {
        this.name = name;
        this.age = age;
        this.citizenship = citizenship;
        this.voterId = voterId;
        this.validId = validId;
    }

    // Getters
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getCitizenship() {
        return citizenship;
    }

    public String getVoterId() {
        return voterId;
    }

    public boolean isValidId() {
        return validId;
    }

    /**
     * Check if voter is eligible to vote
     * Conditions:
     * 1. Age must be at least 18 years
     * 2. Must be a citizen of the country
     * 3. Must possess a valid voter ID
     */
    public boolean isEligible() {
        return age >= 18 && citizenship.equalsIgnoreCase("Indian") && validId;
    }

    /**
     * Get eligibility message with reason if ineligible
     */
    public String getEligibilityMessage() {
        StringBuilder message = new StringBuilder();
        message.append("Name: ").append(name).append("\n");
        message.append("Voter ID: ").append(voterId).append("\n");

        if (isEligible()) {
            message.append("Status: ELIGIBLE TO VOTE");
        } else {
            message.append("Status: NOT ELIGIBLE TO VOTE\n");
            message.append("Reasons:\n");

            if (age < 18) {
                message.append("  - Age requirement not met (Age must be at least 18 years)\n");
            }

            if (!citizenship.equalsIgnoreCase("Indian")) {
                message.append("  - Not a citizen of the country\n");
            }

            if (!validId) {
                message.append("  - Voter ID is not valid\n");
            }
        }

        return message.toString();
    }
}