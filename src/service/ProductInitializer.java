package service;

import product.*;
import java.util.List;

public class ProductInitializer {
    public static List<Product> initializeProducts() {
        return List.of(
                new Electronics("Laptop", 1200),
                new Clothing("Jacket", 150),
                new Book("Clean Code", 50)
        );
    }
}
