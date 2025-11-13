package cli;

import service.ProductService;
import visitor.DiscountVisitor;
import visitor.PriceVisitor;
import visitor.Visitor;

import java.util.Scanner;

public class Terminal {

    private final ProductService productService;
    private final Visitor priceVisitor;
    private final Visitor discountVisitor;

    public Terminal(ProductService productService) {
        this.productService = productService;
        this.priceVisitor = new PriceVisitor();
        this.discountVisitor = new DiscountVisitor();
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        System.out.println("Welcome to the Product Manager!");

        while (running) {
            System.out.println("\nSelect an action:");
            System.out.println("1 - Add a product");
            System.out.println("2 - Remove a product");
            System.out.println("3 - Show prices with tax");
            System.out.println("4 - Show prices with discount");
            System.out.println("5 - Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> productService.addProduct(scanner);
                case 2 -> productService.removeProduct(scanner);
                case 3 -> productService.processProducts(priceVisitor, "Prices with Tax");
                case 4 -> productService.processProducts(discountVisitor, "Prices with Discount");
                case 5 -> {
                    System.out.println("Exiting...");
                    running = false;
                }
                default -> System.out.println("Invalid choice!");
            }
        }

        scanner.close();
    }
}
