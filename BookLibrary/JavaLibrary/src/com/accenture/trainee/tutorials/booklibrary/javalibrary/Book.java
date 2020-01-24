package com.accenture.trainee.tutorials.booklibrary.javalibrary;

import java.io.Serializable;

public class Book implements Serializable {
    String title;
    String author;
    static int quantity;
    int serialNumber;

    //default constructor

    public Book() {
        title = null;
        author = null;
        quantity = 0;
        serialNumber = 0;
    }

    //constructor with parameters
    public Book(String title, String author, int quantity, int serialNumber) {
        this.title = title;
        this.author = author;
        this.quantity = quantity;
        this.serialNumber = serialNumber;
    }

    @Override
    public String toString() {
        return "\nBook Title: " + title
                + "\nBook Author: " + author
                + "\nQuantity: " + quantity
                + "\nSerialNumber: " + serialNumber;
    }

}


