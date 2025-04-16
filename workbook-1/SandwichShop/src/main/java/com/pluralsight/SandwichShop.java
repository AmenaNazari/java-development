package com.pluralsight;

import java.util.Scanner;

public class SandwichShop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Choose sandwich size:");
        System.out.println("1: Regular ($5.45)");
        System.out.println("2: Large ($8.95)");
        System.out.print("Enter 1 or 2: ");
        int size = scanner.nextInt();

        double basePrice;
        if (size == 1) {
            basePrice = 5.45;
        } else if (size == 2) {
            basePrice = 8.95;
        } else {
            System.out.println("Invalid selection.");
            return;
        }

        System.out.print("Do you want it loaded (double)? (yes/no): ");
        String loaded = scanner.next();
        if (loaded.equalsIgnoreCase("yes")) {
            basePrice *= 2;
        }

        System.out.print("Enter your age: ");
        int age = scanner.nextInt();

        double discount = 0.0;
        if (age <= 17) {
            discount = 0.10;
        } else if (age >= 65) {
            discount = 0.20;
        }

        double finalPrice = basePrice - (basePrice * discount);
        System.out.printf("Your total is: $%.2f\n", finalPrice);
    }
}
