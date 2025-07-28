import Book.Book;
import Book.Classics;
import Book.Fantasy;
import Book.Thriller;
import Enums.Category;
import Human.Author;
import Human.Librarian;
import Human.Reader;
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
            System.out.println("1) Kitap ekleme");
            System.out.println("2) Kitap silme");
            System.out.println("3) Kitap arama");
            System.out.println("4) Kitap kiralama");
            System.out.println("5) Kitap iade etme");
            System.out.println("6) Kitap bilgisi guncelleme");
            System.out.println("0) Islemleri sonlandir");

            int input = scanner.nextInt();
            scanner.nextLine();
            switch(input){
                case 1:
                    System.out.println("Kitabin idsini giriniz.");
                    long kitapId = scanner.nextLong();
                    scanner.nextLine();
                    System.out.println("Kitabin yazarini giriniz.");
                    String yazarAdi = scanner.nextLine();
                    Author yazarObj = new Author(yazarAdi);
                    System.out.println("Kitabin adini giriniz.");
                    String kitapAdi = scanner.nextLine();
                    System.out.println("Kitabin tutarini giriniz.");
                    double kitapTutari = scanner.nextDouble();
                    scanner.nextLine();
                    System.out.println("Kitabin kacinci basim oldugunu giriniz.");
                    int kitapBasimi = scanner.nextInt();
                    scanner.nextLine();
                    LocalDate eklenmeTarihi = LocalDate.now();
                    System.out.println("Kitabin kategorisini giriniz.");
                        String categoryInfo = scanner.nextLine();
                        switch (categoryInfo.toLowerCase()){
                            case "classics":
                                Book bookClassic = new Classics(kitapId, yazarObj, kitapAdi, kitapTutari, kitapBasimi, eklenmeTarihi, Category.CLASSICS);
                                library.newBook(bookClassic);
                                System.out.println("Kitap eklendi.");
                                break;
                            case "fantasy":
                                Book bookFantasy = new Fantasy(kitapId, yazarObj, kitapAdi, kitapTutari, kitapBasimi, eklenmeTarihi, Category.FANTASY);
                                library.newBook(bookFantasy);
                                System.out.println("Kitap eklendi.");
                                break;
                            case "thriller":
                                Book bookThriller = new Thriller(kitapId, yazarObj, kitapAdi, kitapTutari, kitapBasimi, eklenmeTarihi, Category.THRILLER);
                                library.newBook(bookThriller);
                                System.out.println("Kitap eklendi.");
                                break;
                        }
                    break;
                case 2:
                    System.out.println("Silmek istediginiz kitabin adini giriniz.");
                    String silinecekKitapAdi = scanner.nextLine();
                    library.deleteBook(library.getBooks(silinecekKitapAdi));
                    System.out.println("Kitap silindi.");
                    break;
                case 3:
                    System.out.println("1) id ile ara");
                    System.out.println("2) kitap adi ile ara");
                    System.out.println("3) yazar adi ile ara");
                    System.out.println("4) kategori ile ara");
                        int aramaTusu = scanner.nextInt();
                        scanner.nextLine();
                        switch (aramaTusu){
                            case 1:
                                System.out.println("id giriniz.");
                                long aramaId = scanner.nextLong();
                                scanner.nextLine();
                                System.out.println(library.getBooks(aramaId));
                                break;
                            case 2:
                                System.out.println("kitap adini giriniz.");
                                String aramaKitapAdi = scanner.nextLine();
                                System.out.println(library.getBooks(aramaKitapAdi));
                                break;
                            case 3:
                                System.out.println("yazar adini giriniz.");
                                String aramaYazarAdi = scanner.nextLine();
                                System.out.println(library.getBooks(new Author(aramaYazarAdi)));
                                break;
                            case 4:
                                System.out.println("1) Klasik turundeki kitaplar");
                                System.out.println("2) Fantastik turundeki kitaplar");
                                System.out.println("3) Korku turundeki kitaplar");
                                int aramaKategori = scanner.nextInt();
                                scanner.nextLine();
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

                case 4:
                    System.out.println("Kiralamak istediginiz kitabin adini giriniz.");
                    String kiralananKitap = scanner.nextLine();
                    System.out.println("Uyenin adini giriniz.");
                    String kiralayanUye = scanner.nextLine();
                    library.lendBook(new Reader(kiralayanUye), library.getBooks(kiralananKitap));
                    
            }
        }



    }

}