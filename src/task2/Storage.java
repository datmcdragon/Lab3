package task2;

import task1.Product;
import task2.exceptions.InvalidPriceException;

import java.util.ArrayList;
import java.util.List;

public class Storage {
    private List<Product> products = new ArrayList<>();

    public List<Product> getProducts() {
        return products;
    }

    public void addProduct(Product product) {
        try {
            validate(product);
            products.add(product);
        } catch (InvalidPriceException e) {
            throw new RuntimeException(e);
        }
    }

    public void validate(Product product) throws InvalidPriceException {
        if(product.getPrice()<0) throw new InvalidPriceException();
    }
}
