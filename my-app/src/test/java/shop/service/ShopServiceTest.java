package shop.service;

import org.junit.Test;
import shop.model.*;

import java.util.List;

import static org.junit.Assert.*;

public class ShopServiceTest {

    @Test
    public void testFindByCategory() {
        ShopService shop = new ShopService();
        Category books = new Category("Книги");
        Product p1 = new Product("Java", 500, books);
        Product p2 = new Product("Python", 700, books);
        shop.addProduct(p1);
        shop.addProduct(p2);

        List<Product> result = shop.findByCategory(books);
        assertEquals(2, result.size());
    }

    @Test
    public void testFilterByMinSpent() {
        ShopService shop = new ShopService();
        Category electronics = new Category("Электроника");
        Product phone = new Product("Телефон", 20000, electronics);
        Product tv = new Product("Телевизор", 30000, electronics);

        Customer c1 = new Customer("Иван");
        c1.addPurchase(phone);
        c1.addPurchase(tv);
        shop.addCustomer(c1);

        List<Customer> result = shop.filterByMinSpent(40000);
        assertEquals(1, result.size());
        assertEquals("Иван", result.get(0).getName());
    }
}
