package ru.netology.javaqa;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ProductManagerTest {
    ProductRepository repo = new ProductRepository();
    ProductManager manager = new ProductManager(repo);

    Product item1 = new Book(1, "Java для Чайников", 4_500, "Барри Бред");
    Product item2 = new Smartphone(2, "XR", 85_500, "Apple");
    Product item3 = new Book(3, "Гарри Поттер", 600, "Джуан Роулинг");
    Product item4 = new Smartphone(4, "Samsung Galaxy9", 72_000, "Samsung");
    Product item5 = new Book(5, "Невыносимая лекгость бытия", 1_000, "Милан Кундера");
    Product item6 = new Book(6, "К черту все, берись и делай", 750, "Ричард Брэнсон");
    Product item7 = new Book(7, "Гарри Поттер 5", 700, "Джуан Роулинг");

    @Test
    public void shouldSearchSomeItemsByText() {
        manager.add(item1);
        manager.add(item2);
        manager.add(item3);
        manager.add(item4);
        manager.add(item5);
        manager.add(item6);
        manager.add(item7);

        Product[] expected = {item4};
        Product[] actual = manager.searchBy("Samsung Galaxy9");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchItemsByText() {
        manager.add(item1);
        manager.add(item2);
        manager.add(item3);
        manager.add(item4);
        manager.add(item5);
        manager.add(item6);
        manager.add(item7);
        Product[] expected = {item2};
        Product[] actual = manager.searchBy("XR");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void searchItemsByTextIfNoAdd() {
        manager.add(item1);
        manager.add(item2);
        manager.add(item3);
        manager.add(item4);
        manager.add(item5);
        manager.add(item6);
        manager.add(item7);
        Product[] expected = {};
        Product[] actual = manager.searchBy("Мыло");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void searchItemsByTextIfOneAdd() {
        manager.add(item6);

        Product[] expected = {item6};
        Product[] actual = manager.searchBy("К черту все, берись и делай");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void searchItemsByTextIfSeveralOneNameAdd() {
        manager.add(item1);
        manager.add(item2);
        manager.add(item3);
        manager.add(item4);
        manager.add(item5);
        manager.add(item6);
        manager.add(item7);
        Product[] expected = {item3, item7};
        Product[] actual = manager.searchBy("Гарри");

    }


}