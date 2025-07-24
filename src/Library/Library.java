package Library;

import Book.Book;
import Human.Author;

import java.io.Reader;
import java.util.HashSet;
import java.util.Set;

public class Library {
    private Set<Book> books;
    private Set<Reader> readers;

    public Library(Set<Book> books) {
        this.books = books;
        this.readers = new HashSet<>();
    }

    public Book getBooks(Long bookId) {
        for(Book item: books){
            if(item.getBook_ID() == bookId){
                return item;
            }
        }
        return null;
    }

    public Book getBooks(String name) {
        for(Book item: books){
            if(item.getName().equals(name)){
                return item;
            }
        }
        return null;
    }

    public Set<Book> getBooks(Author author) {
        Set<Book> authorBook = new HashSet<>();
        for(Book item: books){
            if(item.getAuthor().equals(author)){
                authorBook.add(item);
            }

        }
        return authorBook;
    }


    public Set<Reader> getReaders() {
        return readers;
    }

    public void newBook(Book book){
        books.add(book);
    }

    public void lendBook(Book book){
        books.remove(book);
    }

    public void takeBackBook(Book book){
        books.add(book);
    }

    public void showBook(){
        System.out.println(books);
    }

    public void deleteBook(Book book){
        books.remove(book);
    }
}
