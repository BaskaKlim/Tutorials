package com.accenture.trainee.tutorials.booklibrary.javalibrary;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


public class Library extends StudentList implements Serializable {
    private static final long serialVersionUID = -5492124493279067671L;

    private List<Book> collection;
    private List<Book> borrowedBooks;

    public Library() {
        collection = new ArrayList<>();
        borrowedBooks = new ArrayList<>();
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


    public void addBook(Book book) {
        collection.add(book);
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
            Book borrowedBook = new Book(b.title, b.author, 0, b.serialNumber);
            borrowedBook.isBorrowed = false;

            if (b.title.equals(borrowingTitle)) {
                System.out.println("\n Nasiel som knihu: " + borrowingTitle
                        + "\n Quantity: " + b.quantity
                        + "\n Author: " + b.author);

                if (b.quantity >= 1) {
                    b.quantity--;
                    b.borrowedPieces++;
                    b.isBorrowed = true;

                    borrowedBook.quantity++;
                    borrowedBook.isBorrowed = true;

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

    public void bookReturn(String returnTitle) {
        int flag = 0;

        for (int j = 0; j < borrowedBooks.size(); j++) {
            Book bb = borrowedBooks.get(j);
            Book b = collection.get(j);

            if (bb.title.equals(returnTitle)) {
                bb.quantity--;
                bb.isBorrowed = false;
                if (b.title.equals(returnTitle)) {
                    b.quantity++;
                    b.isBorrowed = false;
                    b.borrowedPieces--;

                    flag++;

                }
            }

            System.out.println("\n The title " + returnTitle + " was successfully returned to library.");
        }
        if (flag == 0) {
            System.out.println("\n You cant return the book, the title" + returnTitle + " is not borrowed.");
        }
    }
}




