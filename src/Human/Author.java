package Human;

import Book.Book;

import java.util.List;

public class Author extends Person{
    private List<Book> books;

    public Author(String name, List<Book> books) {
        super(name);
        this.books = books;
    }

    public void new_Book(Book newBook){
        books.add(newBook);
    }

    public void show_Book(){
        System.out.println(books);
    }

    @Override
    public String whoYouAre() {
        return super.whoYouAre();
    }
}
