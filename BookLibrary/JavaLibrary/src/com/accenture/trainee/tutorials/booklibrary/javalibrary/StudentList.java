package com.accenture.trainee.tutorials.booklibrary.javalibrary;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class StudentList implements Serializable {
    private static final long serialVersionUID = 465779912393580266L;
    List<Student> studentsList;

    public StudentList() {
        studentsList = new ArrayList<>();
    }

    @Override
    public String toString() {
        String total = "\n";
        for (int i = 0; studentsList.size() > i; i++) {
            Student s = studentsList.get(i);
            total = total + s.toString();
        }
        return total;

    }

    public void registerStudent(Student student) {
        studentsList.add(student);
    }

    public boolean registerCheck(int studentID) {
        int flag = 0;
        boolean isRegistered = false;

        for (int i = 0; i < studentsList.size(); i++) {
            Student s = studentsList.get(i);
            if (s.regNumber == studentID) {
                flag++;
                s.isRegistered = true;
                if (s.isRegistered) isRegistered = true;
                else isRegistered = false;
            }
        }
        if (flag == 0) {
            System.out.println("\n Student with ID " + studentID + " is not registered");
        }
        return isRegistered;
    }

    public void hasBorrowed(int studentID, String borrowingTitle) {
        for (int i = 0; studentsList.size() > i; i++) {
            Student s = studentsList.get(i);
            if (s.regNumber == studentID) {
                s.hasBorrowedBook = true;
                s.titleOfBorrowedBook = borrowingTitle;
            }
        }
    }

    public boolean checkReturn(int studentID, String returnTitle) {
        //dala som typ funkcie boolean nech mi vracia pre moju celkovu funkciu v main false alebo true
        // podla toho ci ma student dany titul pozicany
        boolean check = false;
        int flag =0;

        for (int i = 0; i < studentsList.size(); i++) {
            Student s = studentsList.get(i);
            if (s.regNumber == studentID && s.titleOfBorrowedBook.equals(returnTitle)) {
                check = true;
                s.hasBorrowedBook = false;
                s.titleOfBorrowedBook = null;
                System.out.println("Student has returned book successfully");
                flag++;
            }
            if (flag ==0){
                System.out.println("Student cant returned the book");
            }
        }
        return check;
    }


}

