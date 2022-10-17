package task1;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Buyer {
    private String name;
    private int id;
    private List<Product> products = new ArrayList<>();

    public Buyer() {
    }

    public Buyer(String name, int id, List<Product> products) {
        this.name = name;
        this.id = id;
        this.products = products;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    @Override
    public String toString() {
        String result = "Buyer with " +
                "name = '" + name + '\'' +
                ", id=" + id +
                ", products=";
        for(int i = 0; i < products.size(); i++) {
            result += products.get(i).getName() + " ";
        }
     return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Buyer buyer = (Buyer) o;
        return id == buyer.id && name.equals(buyer.name) && products.equals(buyer.products);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, id, products);
    }
}
