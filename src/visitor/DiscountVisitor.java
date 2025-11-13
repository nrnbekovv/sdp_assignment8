package visitor;

import product.Book;
import product.Clothing;
import product.Electronics;

public class DiscountVisitor implements Visitor {

    @Override
    public void visit(Electronics electronics) {
        double discounted = electronics.getPrice() * 0.90;
        System.out.println("Electronics discount: " + electronics.getName() + " -> " + discounted);
    }

    @Override
    public void visit(Clothing clothing) {
        double discounted = clothing.getPrice() * 0.80;
        System.out.println("Clothing discount: " + clothing.getName() + " -> " + discounted);
    }

    @Override
    public void visit(Book book) {
        double discounted = book.getPrice() * 0.95;
        System.out.println("Book discount: " + book.getName() + " -> " + discounted);
    }
}
