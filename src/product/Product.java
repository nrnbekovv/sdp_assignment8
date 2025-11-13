package product;

import visitor.Visitor;

public interface Product {
    String getName();
    double getPrice();
    void accept(Visitor visitor);
}
