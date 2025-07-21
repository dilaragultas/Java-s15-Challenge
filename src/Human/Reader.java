package Human;

import Book.Book;

import java.util.List;

public class Reader extends Person {
    private List<Book> books;
    private List<Book> currentList;

    public Reader(String name, List<Book> books, List<Book> currentList) {
        super(name);
        this.books = books;
        this.currentList = currentList;
    }

    public void purchase_book(Book purchasedBook){
        books.add(purchasedBook);
        currentList.add(purchasedBook);
    }

    public void borrow_book(Book borrowedBook){
        books.add(borrowedBook);
        currentList.add(borrowedBook);
    }

    public void return_book(Book returnedBook){
        currentList.remove(returnedBook);
    }

    public void show_Book(){
        System.out.println(books);
    }

    @Override
    public String whoYouAre() {
        return super.whoYouAre();
    }
}
