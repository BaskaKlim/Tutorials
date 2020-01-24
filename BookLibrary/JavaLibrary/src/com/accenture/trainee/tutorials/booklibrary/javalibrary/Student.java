package com.accenture.trainee.tutorials.booklibrary.javalibrary;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Student implements Serializable {
    String studentName;
    int regNumber;
    String titleOfBorrowedBook;
    boolean hasBorrowedBook;

    public Student() {
        studentName = null;
        regNumber = 0;
        titleOfBorrowedBook = null;
        hasBorrowedBook = false;
    }

    public Student(String studentName, int regNumber, String titleOfBorrowedBook, boolean hasBorrowedBook) {
        this.studentName = studentName;
        this.regNumber = regNumber;
        this.titleOfBorrowedBook = titleOfBorrowedBook;
        this.hasBorrowedBook = hasBorrowedBook;
    }

    @Override
    public String toString() {
        return "\nStudent Name: " + studentName
                + "\nDoes he borrow any book? : " + hasBorrowedBook
                + "\nBorrowed Book: " + titleOfBorrowedBook;
    }


    //TODO: method borrowBook

    public void borrowBook(Book book) {


    }
}