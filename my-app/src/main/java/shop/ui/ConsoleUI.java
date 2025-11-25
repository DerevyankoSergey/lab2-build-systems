package shop.ui;

import shop.model.*;
import shop.service.ShopService;

public class ConsoleUI {
    public static void main(String[] args) {
        ShopService shop = new ShopService();

        // === КАТЕГОРИИ ===
        Category electronics = new Category("Электроника");
        Category books = new Category("Книги");
        Category clothing = new Category("Одежда");
        Category food = new Category("Продукты");

        // === ТОВАРЫ ===
        Product p1 = new Product("Смартфон", 30000, electronics);
        Product p2 = new Product("Ноутбук", 75000, electronics);
        Product p3 = new Product("Книга 'Java'", 800, books);
        Product p4 = new Product("Книга 'Python'", 1200, books);
        Product p5 = new Product("Футболка", 1500, clothing);
        Product p6 = new Product("Куртка", 5000, clothing);
        Product p7 = new Product("Хлеб", 50, food);
        Product p8 = new Product("Молоко", 80, food);

        // Добавляем товары
        shop.addProduct(p1);
        shop.addProduct(p2);
        shop.addProduct(p3);
        shop.addProduct(p4);
        shop.addProduct(p5);
        shop.addProduct(p6);
        shop.addProduct(p7);
        shop.addProduct(p8);

        // === ПОКУПАТЕЛИ ===
        Customer c1 = new Customer("Алексей");
        Customer c2 = new Customer("Мария");
        Customer c3 = new Customer("Дмитрий");
        Customer c4 = new Customer("Ольга");
        Customer c5 = new Customer("Сергей");

        // Покупки
        c1.addPurchase(p1);
        c1.addPurchase(p2);
        c1.addPurchase(p3);

        c2.addPurchase(p4);
        c2.addPurchase(p5);

        c3.addPurchase(p6);
        c3.addPurchase(p8);

        c4.addPurchase(p7);

        c5.addPurchase(p1);
        c5.addPurchase(p5);
        c5.addPurchase(p6);

        // Добавляем покупателей
        shop.addCustomer(c1);
        shop.addCustomer(c2);
        shop.addCustomer(c3);
        shop.addCustomer(c4);
        shop.addCustomer(c5);

        // === ДЕМОНСТРАЦИЯ ПОИСКА ===
        System.out.println("=== ТОВАРЫ В КАТЕГОРИИ 'Электроника' ===");
        shop.findByCategory(electronics).forEach(System.out::println);

        System.out.println("\n=== ТОВАРЫ В КАТЕГОРИИ 'Книги' ===");
        shop.findByCategory(books).forEach(System.out::println);

        System.out.println("\n=== ТОВАРЫ В КАТЕГОРИИ 'Одежда' ===");
        shop.findByCategory(clothing).forEach(System.out::println);

        System.out.println("\n=== ТОВАРЫ В КАТЕГОРИИ 'Продукты' ===");
        shop.findByCategory(food).forEach(System.out::println);

        // === ДЕМОНСТРАЦИЯ ФИЛЬТРАЦИИ ===
        System.out.println("\n=== ПОКУПАТЕЛИ С ТРАТАМИ > 50000 руб. ===");
        shop.filterByMinSpent(50000).forEach(c ->
                System.out.println(c.getName() + " - " + c.getTotalSpent() + " руб."));

        System.out.println("\n=== ПОКУПАТЕЛИ С ТРАТАМИ > 10000 руб. ===");
        shop.filterByMinSpent(10000).forEach(c ->
                System.out.println(c.getName() + " - " + c.getTotalSpent() + " руб."));

        System.out.println("\n=== ПОКУПАТЕЛИ С ТРАТАМИ > 5000 руб. ===");
        shop.filterByMinSpent(5000).forEach(c ->
                System.out.println(c.getName() + " - " + c.getTotalSpent() + " руб."));
    }
}