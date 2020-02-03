package com.accenture.trainee.tutorials.booklibrary.javalibrary;

import java.io.*;
import java.util.Scanner;


public class Main {

    public static String fileName = null;
    public static Scanner scanner = new Scanner(System.in);
    public static Boolean running = true;

    public static Library lib = new Library();
    public static StudentList students = new StudentList();

    public static void main(String[] args) {

        while (running) {
            System.out.println("\nEnter 1 for Adding a Book to Library.."
                    + "\nEnter 2for Update Book Quantity."
                    + "\nEnter 3 for Search a Book with its Serial number."
                    + "\nEnter 4 for Search Books With Author Name."
                    + "\nEnter 5 for Show all Books and their related Information."
                    + "\nEnter 6 for Registering a Student."
                    + "\nEnter 7 for Show All Registered Students"
                    + "\nEnter 8 for Student can Check Out Book From Library"
                    + "\nEnter 9 for Student can Check In Book to Library"
                    + "\nEnter 10 for To see the Books which a Student has Checked Out"
                    + "\nEnter 0 for Loading the library"
                    + "\nEnter 99 for Saving and quit");
            // nacitanie volby od uzivatela
            int answer = scanner.nextInt();
            switch (answer) {
                case 0:
                    //TODO: Loading the library
                    System.out.println("Enter the file name to load");
                    // nacitanie toho file name co zada uzivatel
                    fileName = scanner.next();
                    loadScript(fileName);
                    break;

                case 1:
                    //TODO 1:Adding a Book to Library.
                    addBook();
                    break;

                case 2:
                    // TODO 2: Update Book Quantity.
                    updateQuantity();
                    break;

                case 3:
                    //TODO 3: Search a Book with its Serial number.
                    searchingSerNum();
                    break;
                case 4:
                    //TODO 4: Search Books With Author Name.
                    searchingAuthor();
                    break;

                case 5:
                    //TODO 5: Show all Books and their related Information.
                    showMyCollection();
                    break;
                case 6:
                    //TODO 6: Registering a Student.
                    registeringStudent();
                    break;
                case 7:
                    //TODO 7: Show All Registered Students.
                    showAllStudents();
                    break;
                case 8:
                    // TODO 8: Student can Check Out Book From Library (if registered).
                    //  Student can not Check Out max than 3 Books.
                    //  You can only borrow a Book If it is Available in Library
                    borrowBook();
                    break;
                case 9:
                    //TODO 9: Student can Check In Book to Library.
                    break;
                case 10:
                    //TODO 10: You can also see the Books which a Student has Checked Out(only while checking in)
                    break;
                case 99:
                    //TODO: Saving and quit
                    saveAndQuit();
                    break;
            }
        }
        System.exit(0);
    }

    private static void showAllStudents() {
        System.out.println(students.toString());
    }

    //methods

    private static void addBook() {
        String title;
        String author;
        int quantity;
        int serialNumber;

        System.out.println("\nEnter the title: ");
        title = scanner.next();

        System.out.println("\nEnter the author: ");
        author = scanner.next();

        System.out.println("\nEnter the quantity: ");
        quantity = scanner.nextInt();

        System.out.println("\nEnter the serial number: ");
        serialNumber = scanner.nextInt();

        Book b = new Book(title, author, quantity, serialNumber);
        //pridaj knihu do library
        lib.addBook(b);
    }

    private static void updateQuantity() {
        int newQuantity;
        String lookingTitle;
        System.out.println("\nEnter the title of book you would like to update: ");
        lookingTitle = scanner.next();
        System.out.println("\nEnter the new quantity: ");
        newQuantity = scanner.nextInt();

        lib.searchingTitle(lookingTitle, newQuantity);

    }

    private static void showMyCollection() {
        System.out.println(lib.toString());

    }

    private static void searchingSerNum() {
        int lookingNumber;
        System.out.println("\n Write serial number of book you are looking for: ");
        lookingNumber = scanner.nextInt();
        lib.searchingSerNum(lookingNumber);
    }

    private static void searchingAuthor() {
        String lookingAuthor;
        System.out.println("\n Write Author of book you are looking for: ");
        lookingAuthor = scanner.next();
        lib.searchingAuthor(lookingAuthor);
    }

    private static void registeringStudent() {
        String studentName;
        int regNumber;

        System.out.println("\nEnter the Student Name: ");
        studentName = scanner.next();

        System.out.println("\nEnter the Student Registration Number: ");
        regNumber = scanner.nextInt();

        Student s = new Student(studentName, regNumber);
        // pridaj studenta do zoznamu studentov
        students.registerStudent(s);
        System.out.println("\nStudent was registered successfully");


    }


    private static void borrowBook() {
        String borrowingTitle;
        System.out.println("\nEnter the title of book you are looking for: ");
        borrowingTitle = scanner.next();
        lib.borrowBook(borrowingTitle);
    }


    private static void saveAndQuit() {
        System.out.println("Enter the file name to load: ");
        fileName = scanner.next();
        running = false;
        FileOutputStream fos = null;
        ObjectOutputStream out = null;

        try {
            // inicializovanie
            fos = new FileOutputStream(fileName + " .ser");
            out = new ObjectOutputStream(fos);
            out.writeObject(lib); // take serializabe object
            out.writeObject(students);
            fos.close();
            out.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private static void loadScript(String name) {
        FileInputStream fis = null;
        ObjectInputStream in = null;

        File file = new File(name + " .ser");
        if (file.exists()) {
            try {
                fis = new FileInputStream(file);
                in = new ObjectInputStream(fis);
                lib = (Library) in.readObject();
                students = (StudentList) in.readObject();
                fis.close();
                in.close();

                // AUTO GENERATED CATCH BLOCK
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("\nThe file does not exist!");
        }
    }
}

