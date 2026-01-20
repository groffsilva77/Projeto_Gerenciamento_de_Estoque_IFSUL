package com.estoque;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class App {
    private static Scanner scanner = new Scanner(System.in).useLocale(java.util.Locale.US);
    private static StockManager manager = new StockManager();

    public static void main(String[] args) {
        int option;
        while (true) {
            System.out.println("\n--- Welcome to your system ---");
            System.out.println("1. Add Product\n2. Delete Product\n3. Sell Product\n4. Display Estorage\n5. Exit");
            System.out.print("Choose an option: ");
            option = scanner.nextInt();
            scanner.nextLine();

            if (option == 5) {
                System.out.println("Exiting system. Until next time!");
                break;
            }
            switch (option) {
                case 1 -> handleAdd();
                case 2 -> handleDelete();
                case 3 -> handleSell();
                case 4 -> manager.printInventory();
            }
        }
        scanner.close();
    }

    private static void handleAdd() {
        System.out.print("Code: ");
        String id = scanner.nextLine();
        System.out.print("Name: ");
        String name = scanner.nextLine();
        System.out.print("Quantity: ");
        int qty = scanner.nextInt();
        System.out.print("Price: ");
        double price = scanner.nextDouble();
        scanner.nextLine();

        Product p = new Product(id, name, qty, price);
        if (manager.addProduct(p)) {
            System.out.println("Success!");
        } else {
            System.out.println("Error: Product ID already exists");
        }
    }

    private static void handleDelete() {
        System.out.print("Product code to delete: ");
        String id = scanner.nextLine();
        if (manager.deleteProduct(id)) {
            System.out.println("Deleted.");
        } else {
            System.out.println("Error: Product ID not found.");
        }
    }

    private static void handleSell() {
        System.out.print("Product ID to sell: ");
        String id = scanner.nextLine();
        System.out.print("Amount to sell: ");
        int amount = scanner.nextInt();
        scanner.nextLine();

        Product p = manager.findProduct(id);
        if (p != null) {
            if (p.sell(amount)) {
                System.out.println("Sold!");
            } else {
                System.out.println("Failed: Check your quantity.");
            }
        } else {
            System.out.println("Product not found.");
        }
    }
}