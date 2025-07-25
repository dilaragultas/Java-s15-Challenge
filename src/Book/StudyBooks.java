package Book;

import Enums.Status;
import Human.Author;

import java.time.LocalDate;

public class StudyBooks extends Book{
    public StudyBooks(long bookId, Author author, String name, double price, Status status, int edition, LocalDate date_of_purchase) {
        super(bookId, author, name, price, status, edition, date_of_purchase);
    }
}
