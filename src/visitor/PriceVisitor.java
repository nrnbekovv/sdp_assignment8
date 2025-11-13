package visitor;

import product.Book;
import product.Clothing;
import product.Electronics;

public class PriceVisitor implements Visitor {

    @Override
    public void visit(Electronics electronics) {
        double total = electronics.getPrice() * 1.15;
        System.out.println("Electronics: " + electronics.getName() + " | Price with tax: " + total);
    }

    @Override
    public void visit(Clothing clothing) {
        double total = clothing.getPrice() * 1.10;
        System.out.println("Clothing: " + clothing.getName() + " | Price with tax: " + total);
    }

    @Override
    public void visit(Book book) {
        double total = book.getPrice();
        System.out.println("Book: " + book.getName() + " | Price with tax: " + total);
    }
}
