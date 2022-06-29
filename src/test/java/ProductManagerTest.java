import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ProductManagerTest {
    Repository repo = new Repository();
    ProductManager manager = new ProductManager(repo);
    Product book = new Book(1, "one", 300, "One");
    Product book1 = new Book(2, "two", 400, "Two");
    Product smartphone = new Smartphone(3, "luck", 20000, "Luck1");


    @Test
    public void shouldAdd() {
        manager.add(book);
        manager.add(book1);
        manager.add(smartphone);

        Product[] actual = repo.findAll();
        Product[] expected = {book, book1, smartphone};
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldBook() {
        manager.add(book);
        manager.add(book1);
        manager.add(smartphone);

        Product[] actual = manager.searchBy("one");
        Product[] expected = {book};
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSmartphone() {
        manager.add(book);
        manager.add(book1);
        manager.add(smartphone);

        Product[] actual = manager.searchBy("luck");
        Product[] expected = {smartphone};
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFind0() {
        manager.add(book);
        manager.add(book1);
        manager.add(smartphone);

        Product[] actual = manager.searchBy("Two1");
        Product[] expected = {};
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFind() {


        Product[] actual = manager.searchBy("two");
        Product[] expected = {};
        Assertions.assertArrayEquals(expected, actual);
    }
}