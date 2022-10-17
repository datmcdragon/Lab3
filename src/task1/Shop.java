package task1;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Shop {
    public static List<Buyer> buyers = new ArrayList<>();
    public static List<Seller> sellers = new ArrayList<>();
   public static List<Product> products = new ArrayList<>();
    public static  List<Receipt> receipts = new ArrayList<>();

    public static void sell(Buyer buyer, Seller seller, Product product) {
        if(seller.getProducts().contains(product)) {
            List<Product> products = seller.getProducts();
            products.remove(product);
            seller.setProducts(products);
            products = buyer.getProducts();
            products.add(product);
            buyer.setProducts(products);
            Receipt receipt = new Receipt(buyer, seller, product, LocalDateTime.now());
            receipts.add(receipt);
            updateInfo(buyer, seller);
        }
    }

    public static void updateInfo(Buyer buyer, Seller seller) {
        boolean isFoundedBuyer = false;
        for(int i = 0; i < buyers.size(); i++) {
            if(buyers.get(i).getId()==buyer.getId()) {
                isFoundedBuyer = true;
                buyers.remove(i);
                buyers.add(buyer);
                break;
            }
        }
        boolean isFoundedSeller = false;
        for(int i = 0; i < sellers.size(); i++) {
            if(sellers.get(i).getId()==seller.getId()) {
                isFoundedSeller = true;
                sellers.remove(i);
                sellers.add(seller);
                break;
            }
        }
        if(!isFoundedBuyer) buyers.add(buyer);
        if(!isFoundedSeller) sellers.add(seller);
    }

    public static void addBuyer(Buyer buyer) {
        buyers.add(buyer);
    }
    public static void addSeller(Seller seller) {
        sellers.add(seller);
    }
    public static void addProduct(Product product) {
        products.add(product);
    }
    public static void addReceipt(Receipt receipt) {
        receipts.add(receipt);
    }

    public static List<Buyer> getBuyers() {
        return buyers;
    }

    public static List<Seller> getSellers() {
        return sellers;
    }

    public static List<Product> getProducts() {
        return products;
    }

    public static List<Receipt> getReceipts() {
        return receipts;
    }

    public static void setProducts(List<Product> products) {
        Shop.products = products;
    }
}
