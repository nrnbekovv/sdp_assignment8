package service;

import product.Product;
import product.Electronics;
import product.Clothing;
import product.Book;
import visitor.Visitor;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProductService {

    private final List<Product> products = new ArrayList<>();

    public void initializeProducts() {
        products.add(new Electronics("Laptop", 1200));
        products.add(new Clothing("Jacket", 150));
        products.add(new Book("Clean Code", 50));
    }

    public void addProduct(Scanner scanner) {
        while (true) {
            System.out.println("Select product type (or 0 to go back): 1 - Electronics, 2 - Clothing, 3 - Book");
            int type = scanner.nextInt();
            scanner.nextLine();

            if (type == 0) {
                System.out.println("Returning to main menu...");
                return;
            }

            System.out.print("Enter product name: ");
            String name = scanner.nextLine();

            System.out.print("Enter product price: ");
            double price = scanner.nextDouble();
            scanner.nextLine(); // consume newline

            switch (type) {
                case 1 -> products.add(new Electronics(name, price));
                case 2 -> products.add(new Clothing(name, price));
                case 3 -> products.add(new Book(name, price));
                default -> {
                    System.out.println("Invalid product type! Try again.");
                    continue;
                }
            }

            System.out.println("Product added successfully!");
            return;
        }
    }


    public void removeProduct(Scanner scanner) {
        if (products.isEmpty()) {
            System.out.println("No products to remove.");
            return;
        }

        while (true) {
            System.out.println("Current products (enter 0 to go back):");
            for (int i = 0; i < products.size(); i++) {
                System.out.println((i + 1) + " - " + products.get(i).getName() + " ($" + products.get(i).getPrice() + ")");
            }

            System.out.print("Enter the number of the product to remove: ");
            int index = scanner.nextInt();
            scanner.nextLine(); // consume newline

            if (index == 0) {
                System.out.println("Returning to main menu...");
                return;
            }

            if (index < 1 || index > products.size()) {
                System.out.println("Invalid product number! Try again.");
            } else {
                Product removed = products.remove(index - 1);
                System.out.println("Removed product: " + removed.getName());
                return;
            }
        }
    }


    public void processProducts(Visitor visitor, String header) {
        System.out.println("\n=== " + header + " ===");
        for (Product product : products) {
            product.accept(visitor);
        }
    }
}
