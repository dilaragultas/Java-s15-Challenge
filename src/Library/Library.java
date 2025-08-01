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

    public Reader getReaderByBook(Book book){
        for(Map.Entry<Reader, Set<Book>> item: readersOfBook.entrySet()){
            if(item.getValue().contains(book)){
                return item.getKey();
            }
        }
        return null;
    }

    public Reader getReaderByName(String name){
        for(Reader item: readers){
            if(item.getName().equals(name)){
                return item;
            }
        }
        return null;
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

        for (Book book : books) {
            System.out.println("ID: " + book.getBookId());
            System.out.println("Name: " + book.getName());
            System.out.println("Author: " + book.getAuthor().getName());
            System.out.println("Price: $" + book.getPrice());
            System.out.println("Edition: " + book.getEdition());
            System.out.println("Category: " + book.getCategory());
        }
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
