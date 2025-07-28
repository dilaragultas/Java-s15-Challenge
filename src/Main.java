import Book.Book;
import Book.Classics;
import Book.Fantasy;
import Book.Thriller;
import Enums.Category;
import Enums.membershipType;
import Human.*;
import Library.Library;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Book book1 = new Classics(1, new Author("Ali Kalin"), "Lise", 23.9,3, LocalDate.of(2021,11,23), Category.CLASSICS );
        Book book2 = new Classics(3, new Author("Asli veli"), "Pot", 25,7, LocalDate.of(2021,1,3), Category.CLASSICS );
        Set<Book> books = new HashSet<>();
        books.add(book1);
        books.add(book2);
        Librarian librarian = new Librarian("kemal", "123456");
        Library library = new Library(books, librarian);

        system(librarian, library);
    }

    public static void system(Librarian librarian, Library library){

        Scanner scanner = new Scanner(System.in);

        while(true){
            System.out.println("1) Add new book");
            System.out.println("2) Delete book");
            System.out.println("3) Search book");
            System.out.println("4) Lend book");
            System.out.println("5) Return book");
            System.out.println("6) Update book info");
            System.out.println("0) Stop application");

            int input = scanner.nextInt();
            scanner.nextLine();
            switch(input){
                case 1:
                    System.out.println("Please enter book ID or Press 0 to return menu");
                    long kitapId = scanner.nextLong();
                    scanner.nextLine();
                    if(kitapId == 0) break;
                    System.out.println("Please enter author name or Press 0 to return menu ");
                    String yazarAdi = scanner.nextLine();
                    if(yazarAdi.equals("0")) break;
                    Author yazarObj = new Author(yazarAdi);
                    System.out.println("Please enter book's name or Press 0 to return menu");
                    String kitapAdi = scanner.nextLine();
                    if(kitapAdi.equals("0")) break;
                    System.out.println("Please enter price or Press 0 to return menu");
                    String kitapTutari = scanner.nextLine().replace(",", ".");
                    double doubleKitapTutari = Double.parseDouble(kitapTutari);
                    if(doubleKitapTutari == 0) break;
                    System.out.println("Please enter book's edition or Press 0 to return menu");
                    int kitapBasimi = scanner.nextInt();
                    scanner.nextLine();
                    if(kitapBasimi == 0) break;
                    LocalDate eklenmeTarihi = LocalDate.now();
                    System.out.println("Please enter book's category or Press 0 to return menu");
                        String categoryInfo = scanner.nextLine();
                        if(categoryInfo.equals("0")) break;
                        switch (categoryInfo.toLowerCase()){
                            case "classics":
                                Book bookClassic = new Classics(kitapId, yazarObj, kitapAdi, doubleKitapTutari, kitapBasimi, eklenmeTarihi, Category.CLASSICS);
                                library.newBook(bookClassic);
                                System.out.println("Book successfully created!");
                                break;
                            case "fantasy":
                                Book bookFantasy = new Fantasy(kitapId, yazarObj, kitapAdi, doubleKitapTutari, kitapBasimi, eklenmeTarihi, Category.FANTASY);
                                library.newBook(bookFantasy);
                                System.out.println("Book successfully created!");
                                break;
                            case "thriller":
                                Book bookThriller = new Thriller(kitapId, yazarObj, kitapAdi, doubleKitapTutari, kitapBasimi, eklenmeTarihi, Category.THRILLER);
                                library.newBook(bookThriller);
                                System.out.println("Book successfully created!");
                                break;
                            default:
                                System.out.println("Category is not match, please check and try again.");
                        }
                    break;
                case 2:
                    System.out.println("Please enter book's name that need to deleted or Press 0 to return menu");
                    String silinecekKitapAdi = scanner.nextLine();
                    if(silinecekKitapAdi.equals("0")) break;
                    library.deleteBook(library.getBooks(silinecekKitapAdi));
                    System.out.println("Successfully deleted.");
                    break;
                case 3:
                    System.out.println("1) Search with ID");
                    System.out.println("2) Search with book's name");
                    System.out.println("3) Search with author's name");
                    System.out.println("4) Search with category");
                    System.out.println("0) Press 0 to return menu");
                        int aramaTusu = scanner.nextInt();
                        scanner.nextLine();
                        if(aramaTusu == 0) break;
                        switch (aramaTusu){
                            case 1:
                                System.out.println("Add ID or Press 0 to return menu");
                                long aramaId = scanner.nextLong();
                                scanner.nextLine();
                                if(aramaId ==0) break;
                                System.out.println(library.getBooks(aramaId));
                                break;
                            case 2:
                                System.out.println("Add book's name or Press 0 to return menu ");
                                String aramaKitapAdi = scanner.nextLine();
                                if(aramaKitapAdi.equals("0")) break;
                                System.out.println(library.getBooks(aramaKitapAdi));
                                break;
                            case 3:
                                System.out.println("Add author's name or Press 0 to return menu");
                                String aramaYazarAdi = scanner.nextLine();
                                if(aramaYazarAdi.equals("0")) break;
                                System.out.println(library.getBooks(new Author(aramaYazarAdi)));
                                break;
                            case 4:
                                System.out.println("Please choose 1 for Classics books or Press 0 to return menu");
                                System.out.println("Please choose 2 for Fantasy books or Press 0 to return menu");
                                System.out.println("Please choose 3 for Thriller books or Press 0 to return menu");
                                int aramaKategori = scanner.nextInt();
                                scanner.nextLine();
                                if(aramaKategori == 0) break;
                                switch (aramaKategori){
                                    case 1:
                                        System.out.println(library.getBooks(Category.CLASSICS));
                                        break;
                                    case 2:
                                        System.out.println(library.getBooks(Category.FANTASY));
                                        break;
                                    case 3:
                                        System.out.println(library.getBooks(Category.THRILLER));
                                        break;
                                }
                                break;
                        }
                    break;
                case 4:
                    System.out.println("Add book's name that you want to lend or Press 0 to return menu");
                    String kiralananKitap = scanner.nextLine();
                    if(kiralananKitap.equals("0")) break;
                    System.out.println("Please add member's name or Press 0 to return menu");
                    String kiralayanUyeAdi = scanner.nextLine();
                    if(kiralayanUyeAdi.equals("0")) break;
                    System.out.println("Please add member's ID");
                    long kiralayanUyeIdsi = scanner.nextInt();
                    scanner.nextLine();
                    if(librarian.verifyMemberWithId(kiralayanUyeIdsi)){
                        if(librarian.canBarrowBook(librarian.getMemberRecordById(kiralayanUyeIdsi))){
                            library.lendBook(new Reader(kiralayanUyeAdi), library.getBooks(kiralananKitap));
                            librarian.issueBook(library.getBooks(kiralananKitap), librarian.getMemberRecordById(kiralayanUyeIdsi));
                        }
                    }
                        else{
                        System.out.println("Add address info or Press 0 to return menu");
                        String kiralayanAdres = scanner.nextLine();
                        if(kiralayanAdres.equals("0")) break;
                        System.out.println("Add phone number or Press 0 to return menu");
                        String kiralayanTelefon = scanner.nextLine();
                        if(kiralayanTelefon.equals("0")) break;
                        System.out.println("Add type or Press 0 to return menu");
                        String type = scanner.nextLine();
                        if(type.equals("0")) break;
                        switch (type.toLowerCase()){
                            case "student":
                                memberRecord newMemberStudent = new Student(kiralayanUyeIdsi, membershipType.STUDENT, kiralayanUyeAdi, kiralayanAdres, kiralayanTelefon);
                                librarian.addNewMember(newMemberStudent);
                                library.lendBook(new Reader(kiralayanUyeAdi), library.getBooks(kiralananKitap));
                                librarian.issueBook(library.getBooks(kiralananKitap), newMemberStudent);
                                break;
                            case "faculty":
                                memberRecord newMemberFaculty = new Student(kiralayanUyeIdsi, membershipType.FACULTY, kiralayanUyeAdi, kiralayanAdres, kiralayanTelefon);
                                librarian.addNewMember(newMemberFaculty);
                                library.lendBook(new Reader(kiralayanUyeAdi), library.getBooks(kiralananKitap));
                                librarian.issueBook(library.getBooks(kiralananKitap), newMemberFaculty);
                                break;
                        }
                    }
                break;
                case 5:
                    System.out.println("Please add book's name for return or Press 0 to return menu.");
                    String iadeEdilenKitap = scanner.nextLine();
                    if(iadeEdilenKitap.equals("0")) break;
                    System.out.println("Please add owner's name or Press 0 to return menu.");
                    String iadeEden = scanner.nextLine();
                    if(iadeEden.equals("0")) break;
                    library.takeBackBook(library.getReaderByName(iadeEden), library.getBooks(iadeEdilenKitap));
                    librarian.returnBook(library.getBooks(iadeEdilenKitap), librarian.getMemberRecordByName(iadeEden));
                    break;
                case 6:
                    System.out.println("Please add book name which should be updated or Press 0 to return menu.");
                    String updatedBook = scanner.nextLine();
                    if(updatedBook.equals("0")) break;
                    Book updatedBookObj = library.getBooks(updatedBook);
                    System.out.println("To update book id please choose 1");
                    System.out.println("To update author please choose 2");
                    System.out.println("To update book name please choose 3");
                    System.out.println("To update price please choose 4");
                    System.out.println("To update edition please choose 5");
                    System.out.println("Press 0 to return menu");
                    int updatedInput = scanner.nextInt();
                    scanner.nextLine();
                    switch (updatedInput){
                        case 1:
                            System.out.println("Please update id or Press 0 to return menu");
                            long newId = scanner.nextInt();
                            scanner.nextLine();
                            if(newId == 0) break;
                            updatedBookObj.setBookId(newId);
                            System.out.println("Successfully updated.");
                            break;
                        case 2:
                            System.out.println("Please update author's name or Press 0 to return menu");
                            String newAuthorName = scanner.nextLine();
                            if(newAuthorName.equals("0")) break;
                            updatedBookObj.setAuthor(new Author(newAuthorName));
                            System.out.println("Successfully updated.");
                            break;
                        case 3:
                            System.out.println("Please update book's name or Press 0 to return menu");
                            String newBookName = scanner.nextLine();
                            if(newBookName.equals("0")) break;
                            updatedBookObj.setName(newBookName);
                            System.out.println("Successfully updated.");
                            break;
                        case 4:
                            System.out.println("Please update price or Press 0 to return menu");
                            double newPrice = scanner.nextDouble();
                            scanner.nextLine();
                            if(newPrice == 0) break;
                            updatedBookObj.setPrice(newPrice);
                            System.out.println("Successfully updated.");
                            break;
                        case 5:
                            System.out.println("Please update edition or Press 0 to return menu");
                            int newEdition = scanner.nextInt();
                            scanner.nextLine();
                            if(newEdition == 0) break;
                            updatedBookObj.setEdition(newEdition);
                            System.out.println("Successfully updated.");
                            break;
                    }
                    break;
                case 0:
                    System.out.println("Process completed.");
                    return;
            }
        }



    }

}