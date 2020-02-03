package com.accenture.trainee.tutorials.booklibrary.javalibrary;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class StudentList implements Serializable {

    private List<Student> studentsList;

    public StudentList() {
        studentsList = new ArrayList<>();
    }

    public void registerStudent(Student student) {
        studentsList.add(student);
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
}
