package com.accenture.trainee.tutorials.booklibrary.javalibrary;

import java.io.Serializable;

public class Book implements Serializable {
    private static final long serialVersionUID = 3838086913977271710L; // na opravenie java.io.InvalidClassException: local class incompatible:


    String title;
    String author;
    int quantity;
    int serialNumber;
    boolean isBorrowed;
    int borrowedPieces;


    //default constructor

    public Book() {
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
                + "\nSerialNumber: " + serialNumber
                + "\nBorrowed: " + isBorrowed
                +"\nBorrowed pieces: "+ borrowedPieces +"\n";
    }


}


