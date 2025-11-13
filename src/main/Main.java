package main;

import service.ProductService;
import cli.Terminal;

public class Main {
    public static void main(String[] args) {
        ProductService productService = new ProductService();
        productService.initializeProducts();

        Terminal terminal = new Terminal(productService);
        terminal.start();
    }
}
