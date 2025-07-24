package Book;


import Enums.Status;
import Human.Author;

import java.time.LocalDate;

public abstract class Book {
   private long book_ID;
   private Author author;
   private String name;
   private double price;
   private Status status;
   private int edition;
   private LocalDate date_of_purchase;

    public Book(long book_ID, Author author, String name, double price, Status status, int edition, LocalDate date_of_purchase) {
        this.book_ID = book_ID;
        this.author = author;
        this.name = name;
        this.price = price;
        this.status = status;
        this.edition = edition;
        this.date_of_purchase = date_of_purchase;
    }

    public long getBook_ID() {
        return book_ID;
    }

    public void setBook_ID(long book_ID) {
        this.book_ID = book_ID;
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

    public void update_status(Status status) {
        this.status = status;
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

    public void display(){

    }
}
