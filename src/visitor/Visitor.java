package visitor;

import product.Book;
import product.Clothing;
import product.Electronics;

public interface Visitor {
    void visit(Electronics electronics);
    void visit(Clothing clothing);
    void visit(Book book);
}
