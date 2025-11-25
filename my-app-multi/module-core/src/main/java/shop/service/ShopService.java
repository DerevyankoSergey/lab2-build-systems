package shop.service;

import shop.model.*;
import java.util.ArrayList;
import java.util.List;

public class ShopService {
    private List<Product> products = new ArrayList<>();
    private List<Customer> customers = new ArrayList<>();

    public void addProduct(Product p) { products.add(p); }
    public void addCustomer(Customer c) { customers.add(c); }

    public List<Product> findByCategory(Category cat) {
        return products.stream()
                .filter(p -> p.getCategory().equals(cat))
                .toList();
    }

    public List<Customer> filterByMinSpent(double min) {
        return customers.stream()
                .filter(c -> c.getTotalSpent() >= min)
                .toList();
    }
}
