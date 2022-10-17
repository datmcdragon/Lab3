import task1.*;
import task3.service.Functions;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Product product1 = new Product("Bread", 20);
        Product product2 = new Product("Milk", 40);
        Product product3 = new Product("Sausage", 60);
        List<Product> products = new ArrayList<>();
        products.add(product1);
        products.add(product2);
        products.add(product3);
        List<Product> seller1Products = new ArrayList<>();
        List<Product> seller2Products = new ArrayList<>();
        List<Product> buyer1Products = new ArrayList<>();
        buyer1Products.add(product3);
        seller1Products.add(product1);
        seller2Products.add(product2);
        Buyer buyer1 = new Buyer("Bred", 1, buyer1Products);
        Seller seller1 = new Seller("Fred", 2, seller1Products);
        Seller seller2 = new Seller("Katy", 3, seller2Products);
        Shop.addProduct(product1);
        Shop.addProduct(product2);
        Shop.addProduct(product3);
        Shop.addBuyer(buyer1);
        Shop.addSeller(seller1);
        Shop.addSeller(seller2);
        //Getting all products
        for(Product p : Shop.getProducts()) {
            System.out.println(p);
        }
        System.out.println("--------------------------");
        //Selling products
        Shop.sell(buyer1, seller1, product1);
        //Getting all receipts
        List<Receipt> receipts = Shop.getReceipts();
        for(Receipt r : receipts) {
            System.out.println(r);
        }
        //Task3
        System.out.println("Stream API functions");
        Functions.sortProductsByPrice();
        Functions.averagePrice();
        LocalDateTime from = LocalDateTime.MIN;
        LocalDateTime to = LocalDateTime.MAX;
        Functions.totalBuyerSpent(buyer1, from, to);
        Functions.countProducts(buyer1);
        Functions.popularProduct();
        Functions.maxIncomeByDay();
    }
}