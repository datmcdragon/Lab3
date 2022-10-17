package task1;

import java.time.LocalDateTime;

public class Receipt {
    private Buyer buyer;
    private Seller seller;
    private Product product;
    private int sum;
    private LocalDateTime timeOfDeal;

    public Receipt() {
    }

    public Receipt(Buyer buyer, Seller seller, Product product, LocalDateTime timeOfDeal) {
        this.buyer = buyer;
        this.seller = seller;
        this.product = product;
        this.sum = product.getPrice();
        this.timeOfDeal = timeOfDeal;
    }

    public Buyer getBuyer() {
        return buyer;
    }

    public void setBuyer(Buyer buyer) {
        this.buyer = buyer;
    }

    public Seller getSeller() {
        return seller;
    }

    public void setSeller(Seller seller) {
        this.seller = seller;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public LocalDateTime getTimeOfDeal() {
        return timeOfDeal;
    }

    public void setTimeOfDeal(LocalDateTime timeOfDeal) {
        this.timeOfDeal = timeOfDeal;
    }

    public int getSum() {
        return sum;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }

    @Override
    public String toString() {
        return "Receipt with " +
                "buyer=" + buyer +
                ", seller=" + seller +
                ", product=" + product +
                ", sum =" + product.getPrice() +
                ", timeOfDeal=" + timeOfDeal +
                '}';
    }
}
