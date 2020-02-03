package com.accenture.trainee.tutorials.booklibrary.javalibrary;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


public class Library implements Serializable {

    private List<Book> collection;
    private List<Book> borrowedBooks;

    public Library() {
        collection = new ArrayList<>();
        borrowedBooks = new ArrayList<>();
    }


    public void addBook(Book book) {
        collection.add(book);
    }


    @Override

    public String toString() {
        //inicializujem si string na uvodny stav
        String total = "\n";
        //cyklus na prejdenie kazdej knihy v liste, pouzijeme array.SIZE()
        for (int i = 0; i < collection.size(); i++) {
            // vezmi kniku na i-tom indexe a prirad jej hodnotu do objektu knihy Book b;
            Book b = collection.get(i);
            // zmen vysledny list na list + string konverziu objektu Book b
            total = total + b.toString();
        }
        return total;
    }

    public void searchingSerNum(int searchingSerNum) {
        int flag = 0; // pocitadlo najdenych knih, ak mi po for loope ostane 0, ziadna z knih sa v poli nenachadza
        for (int i = 0; i < collection.size(); i++) {
            // vezmi knihu na tomto indexe a skontroluj jej serial number
            Book b = collection.get(i);
            if (b.serialNumber == searchingSerNum) {
                System.out.println("\n Nasiel som knihu s rovnakym seriovym cislom: " + searchingSerNum
                        + "\n Title: " + b.title
                        + "\n Author: " + b.author);
                flag++;
            }
        }
        if (flag == 0) {
            System.out.println("Nenasiel som knihu s " + searchingSerNum + " seriovym cislom.");
        }
    }

    public void searchingAuthor(String lookingAuthor) {
        int flag = 0; // pocitadlo najdenych knih, ak mi po for loope ostane 0, ziadna z knih sa v poli nenachadza
        for (int i = 0; i < collection.size(); i++) {
            // vezmi knihu na tomto indexe a skontroluj jej autora

            Book b = collection.get(i);
            if (b.author.equals(lookingAuthor)) {
                System.out.println("\n Nasiel som knihu od daneho autora: " + lookingAuthor
                        + "\n Title: " + b.title
                        + "\n Quantity: " + b.quantity
                        + "\n Serial number: " + b.serialNumber);
                flag++;
            }
        }
        if (flag == 0) {
            System.out.println("\n" + "Nenasiel som knihu od autora  " + lookingAuthor);
        }
    }

    public void searchingTitle(String lookingTitle, int newQuantity) {

        int flag = 0; // pocitadlo najdenych knih, ak mi po for loope ostane 0, ziadna z knih sa v poli nenachadza
        for (int i = 0; i < collection.size(); i++) {
            // vezmi knihu na tomto indexe a skontroluj jej autora

            Book b = collection.get(i);
            if (b.title.equals(lookingTitle)) {
                System.out.println("\n Nasiel som knihu: " + lookingTitle
                        + "\n Quantity: " + b.quantity
                        + "\n Author: " + b.author);
                flag++;

                b.quantity = newQuantity;
                System.out.println("\nUpdated quantity is: " + b.quantity);
            }
        }
        if (flag == 0) {
            System.out.println("\n" + "Nenasiel som knihu: " + lookingTitle);
        }
    }


    public void borrowBook(String borrowingTitle) {
        int flag = 0;

        for (int i = 0; i < collection.size(); i++) {
            // vezmi knihu na tomto indexe a skontroluj jej title
            Book b = collection.get(i);

            if (b.title.equals(borrowingTitle)) {
                System.out.println("\n Nasiel som knihu: " + borrowingTitle
                        + "\n Quantity: " + b.quantity
                        + "\n Author: " + b.author);

                Book borrowedBook = new Book();
                borrowedBook.title = b.title;
                borrowedBook.author = b.author;
                borrowedBook.serialNumber = b.serialNumber;
                borrowedBook.quantity = 0;
                borrowedBook.isBorrowed = false;

                if (b.quantity >= 1) {
                    b.quantity--;

                    borrowedBook.isBorrowed = true;
                    borrowedBook.quantity++;
                    borrowedBooks.add(borrowedBook);

                    System.out.println("\n Book " + borrowingTitle + " has been successfully borrowed.  Title is still  available for booking in: " + b.quantity + " pieces"
                            + "\n Currently Borrowed:  " + borrowedBook.quantity + " pieces");
                    flag++;
                }
                if (b.quantity == 0) {
                    System.out.println("\n Book is not available, all pieces are borrowed.");
                    flag++;
                }
            }
        }
        if (flag == 0) {
            System.out.println("\n" + "There is no book with the title " + borrowingTitle + " in library. ");

        }
    }
}


