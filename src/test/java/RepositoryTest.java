import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class RepositoryTest {
    Repository repo = new Repository();
    Product book = new Book(1, "one", 300, "One");
    Product book1 = new Book(2, "two", 400, "Two");
    Product smartphone = new Smartphone(3, "luck", 20000, "Luck1");


    @Test
    public void shouldAdd() {
        repo.add(book);
        repo.add(book1);
        repo.add(smartphone);
        Product[] actual = repo.findAll();
        Product[] expected = {book, book1, smartphone};
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldRemove() {
        repo.add(book);
        repo.add(book1);
        repo.add(smartphone);

        Product[] actual = repo.removeById(1);
        Product[] expected = {book1, smartphone};
        Assertions.assertArrayEquals(expected, actual);
    }
}