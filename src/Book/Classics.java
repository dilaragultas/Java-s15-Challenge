package Book;

import Enums.Category;
import Human.Author;

import java.time.LocalDate;

public class Classics extends Book{
    public Classics(long bookId, Author author, String name, double price, int edition, LocalDate date_of_purchase, Category category) {
        super(bookId, author, name, price, edition, date_of_purchase, category);
    }
}
