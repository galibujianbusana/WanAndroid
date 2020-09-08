package com.example.rxjavatest;

import java.util.ArrayList;
import java.util.List;

public class Student {
    List<Course> courses = new ArrayList<>();
    String name;

    public Student(List<Course> courses, String name) {
        this.courses = courses;
        this.name = name;
    }
}
