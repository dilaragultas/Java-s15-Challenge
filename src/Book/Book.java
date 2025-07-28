package Book;


import Enums.Category;
import Enums.Status;
import Human.Author;

import java.time.LocalDate;

public abstract class Book {
   private long bookId;
   private Author author;
   private String name;
   private double price;
   private Status status;
   private int edition;
   private LocalDate date_of_purchase;
   private Category category;

    public Book(long bookId, Author author, String name, double price, int edition, LocalDate date_of_purchase, Category category) {
        this.bookId = bookId;
        this.author = author;
        this.name = name;
        this.price = price;
        this.edition = edition;
        this.date_of_purchase = date_of_purchase;
        this.status = Status.AVAILABLE;
        this.category = category;
    }

    public long getBookId() {
        return bookId;
    }

    public void setBookId(long bookId) {
        this.bookId = bookId;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Status getStatus() {
        return status;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public void update_status() {

        if(status == Status.AVAILABLE){
            status = Status.UNAVAILABLE;
        } else if (status == Status.UNAVAILABLE){
            status = Status.AVAILABLE;
        }
    }

    public int getEdition() {
        return edition;
    }

    public void setEdition(int edition) {
        this.edition = edition;
    }

    public LocalDate getDate_of_purchase() {
        return date_of_purchase;
    }

    public void setDate_of_purchase(LocalDate date_of_purchase) {
        this.date_of_purchase = date_of_purchase;
    }

    public void change_owner(){

    }

    public void get_owner(){

    }

    @Override
    public String toString() {
        return "Book{" +
                "bookId=" + bookId +
                ", author=" + author +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", status=" + status +
                ", edition=" + edition +
                ", date_of_purchase=" + date_of_purchase +
                ", category=" + category +
                '}';
    }
}
