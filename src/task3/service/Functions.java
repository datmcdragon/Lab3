package task3.service;

import task1.Buyer;
import task1.Product;
import task1.Receipt;
import task1.Shop;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Functions {
    public static void sortProductsByPrice() {
        List<Product> products = Shop.getProducts();
        Shop.setProducts(products.stream().sorted(((o1, o2) -> o1.getPrice()-o2.getPrice())).collect(Collectors.toList()));
        System.out.println("Products sorted by price");
    }
    public static void averagePrice() {
        double average = Shop.getProducts().stream().collect(Collectors.averagingDouble(Product::getPrice));
        System.out.println("Average Price of all products = " + average);
    }
    public static void totalBuyerSpent(Buyer buyer, LocalDateTime from, LocalDateTime to) {
        int sum = Shop.getReceipts().stream().filter(e -> e.getBuyer().equals(buyer) && ((e.getTimeOfDeal().isBefore(to) || e.getTimeOfDeal().isAfter(from)))).collect(Collectors.summingInt(Receipt::getSum));
        System.out.println("Sum of all products of Buyer " + buyer + " = " + sum);
    }
    public static void countProducts(Buyer buyer) {
        Map<Product, Long> count = buyer.getProducts().stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        for (Map.Entry<Product, Long> entry : count.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue().toString() + " pcs");
        }
    }
    public static void popularProduct() {
        Map<Product, Long> count = Shop.getProducts().stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        Product popularProduct = Collections.max(count.entrySet(), Map.Entry.comparingByValue()).getKey();
        System.out.println("The most popular product: " + popularProduct);
    }
    public static void maxIncomeByDay() {
        Map<LocalDateTime, List<Receipt>>  incomesByDay = Shop.getReceipts().stream().collect(Collectors.groupingBy(Receipt::getTimeOfDeal));
        Optional<Integer> maxIncome = incomesByDay.values()
                .stream()
                .flatMap(listOfAccounts -> listOfAccounts.stream().map(Receipt::getSum))
                .max(Integer::compareTo);
        System.out.println("The best income was: " + maxIncome);
    }
}
