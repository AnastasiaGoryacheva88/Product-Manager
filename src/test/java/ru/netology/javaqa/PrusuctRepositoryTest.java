package ru.netology.javaqa;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PrusuctRepositoryTest {
    Product item1 = new Book(1, "Java для Чайников", 4_500, "Барри Бред");
    Product item2 = new Smartphone(2, "XR", 85_500, "Apple");
    Product item3 = new Book(3, "Гарри Поттер", 600, "Джуан Роулинг");
    Product item4 = new Smartphone(4, "Samsung Galaxy9", 72_000, "Samsung");
    Product item5 = new Book(5, "Невыносимая лекгость бытия", 1_000, "Милан Кундера");
    Product item6 = new Book(6, "К черту все, берись и делай", 750, "Ричард Брэнсон");


    @Test
    public void shouldAddItems() {
        ProductRepository repo = new ProductRepository();
        repo.save(item1);
        repo.save(item2);
        repo.save(item3);
        repo.save(item4);
        repo.save(item5);
        repo.save(item6);

        Product[] expected = {item1, item2, item3, item4, item5, item6};
        Product[] actual = repo.getItems();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldRemoveById() {
        ProductRepository repo = new ProductRepository();
        repo.save(item1);
        repo.save(item2);
        repo.save(item3);
        repo.save(item4);
        repo.save(item5);
        repo.save(item6);

        repo.removeById(item3.getId());
        repo.removeById(item6.getId());

        Product[] expected = {item1, item2, item4, item5};
        Product[] actual = repo.getItems();

        Assertions.assertArrayEquals(expected, actual);
    }


}
