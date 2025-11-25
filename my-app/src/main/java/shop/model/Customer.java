package shop.model;

import java.util.ArrayList;
import java.util.List;

public class Customer {
    private String name;
    private List<Product> purchases = new ArrayList<>();

    public Customer(String name) { this.name = name; }

    public void addPurchase(Product p) { purchases.add(p); }

    public double getTotalSpent() {
        return purchases.stream().mapToDouble(Product::getPrice).sum();
    }

    public String getName() { return name; }
    public List<Product> getPurchases() { return purchases; }
}
