package com.accenture.trainee.tutorials.booklibrary.javalibrary;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static com.accenture.trainee.tutorials.booklibrary.javalibrary.Main.lib;

public class Library implements Serializable {

    private List<Book> collection;

    public Library() {
        collection = new ArrayList<>();
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

        for (int i = 0; i < collection.size(); i++) {
            // vezmi knihu na tomto indexe a skontroluj jej serial number
            Book b = collection.get(i);
            if (b.serialNumber != searchingSerNum) {
                System.out.println("\n" + "Nenasiel som knihu so zadanym cislom. ");

            } else {
                System.out.println("\n Nasiel som knihu s rovnakym seriovym cislom: " + searchingSerNum
                        + "\n Title: " + b.title
                        + "\n Author: " + b.author);
            }
        }
    }


    public void searchingAuthor(String lookingAuthor) {
        for (int i = 0; i < collection.size(); i++) {
            // vezmi knihu na tomto indexe a skontroluj jej autora

            Book b = collection.get(i);
            if (b.author.equals(lookingAuthor)) {
                System.out.println("\n Nasiel som knihu od daneho autora: " + lookingAuthor
                        + "\n Title: " + b.title
                        + "\n Quantity: " + Book.quantity
                        + "\n Serial number: " + b.serialNumber);
            } else
                System.out.println("\n" + "Nenasiel som knihu so zadanym autorom. ");

        }
    }
}
