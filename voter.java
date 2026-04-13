package com.voting;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of voters: ");
        int n = sc.nextInt();
        sc.nextLine(); 

        for (int i = 0; i < n; i++) {
            System.out.println("\nVoter " + (i+1) + " Details:");
            System.out.print("Name: "); String name = sc.nextLine();
            System.out.print("Age: "); int age = sc.nextInt(); sc.nextLine();
            System.out.print("Citizenship: "); String citizen = sc.nextLine();
            System.out.print("Is ID Valid (true/false): "); boolean valid = sc.nextBoolean(); sc.nextLine();
            
            new Voter(name, age, citizen, valid).validate();
        }
        sc.close();
    }
}
