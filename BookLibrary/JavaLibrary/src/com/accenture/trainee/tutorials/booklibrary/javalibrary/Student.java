package com.accenture.trainee.tutorials.booklibrary.javalibrary;

import java.io.Serializable;

public class Student implements Serializable {
    String studentName;
    int regNumber;
    String titleOfBorrowedBook;
    boolean hasBorrowedBook;


    // constructor
    public Student(String studentName, int regNumber) {
        this.studentName = studentName;
        this.regNumber = regNumber;
    }

    //constructor with parameters
    public Student(String studentName, int regNumber, String titleOfBorrowedBook, boolean hasBorrowedBook) {
        this.studentName = studentName;
        this.regNumber = regNumber;
        this.titleOfBorrowedBook = titleOfBorrowedBook;
        this.hasBorrowedBook = hasBorrowedBook;
    }

    @Override
    public String toString() {
            return "\nStudent Name: " + studentName
                    +"\nStudent ID: " + regNumber
                    + "\nDoes he borrow any book? : " + hasBorrowedBook
                    + "\n What book does he has : " + titleOfBorrowedBook   + "\n ";
        }
    }






