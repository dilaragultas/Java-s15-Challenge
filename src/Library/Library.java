package Library;

import Book.Book;
import Enums.Category;
import Enums.Status;
import Human.Author;
import Human.Librarian;
import Human.Reader;


import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Library {
    private Set<Book> books;
    private Set<Reader> readers;
    private Map<Reader, Set<Book>> readersOfBook;
    private Librarian librarian;

    public Library(Set<Book> books, Librarian librarian) {
        this.books = books;
        this.readers = new HashSet<>();
        this.readersOfBook = new HashMap<>();
        this.librarian = librarian;
    }

    public Book getBooks(Long bookId) {
        for(Book item: books){
            if(item.getBookId() == bookId){
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

    public Set<Book> getBooks(Category category){
        Set<Book> categoryBook = new HashSet<>();
        for(Book item: books){
            if(item.getCategory().equals(category)){
                categoryBook.add(item);
            }
        }
        return categoryBook;
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

    public void lendBook(Reader reader, Book book){
        if(book.getStatus().equals(Status.UNAVAILABLE)){
            System.out.println("This book has already taken by another member");
        } else if(book.getStatus().equals(Status.AVAILABLE)){
            readersOfBook.putIfAbsent(reader, new HashSet<>());
            readersOfBook.get(reader).add(book);
            if (!readers.contains(reader)) {
                readers.add(reader);
            }
        }
    }

    public void takeBackBook(Reader reader, Book book){
        readers.remove(reader);
        readersOfBook.get(reader).remove(book);
    }

    public void showBook(){
        System.out.println(books);
    }

    public void deleteBook(Book book){
        books.remove(book);
    }

    @Override
    public String toString() {
        return "Library{" +
                "books=" + books +
                ", readers=" + readers +
                ", readersOfBook=" + readersOfBook +
                ", librarian=" + librarian +
                '}';
    }
}
