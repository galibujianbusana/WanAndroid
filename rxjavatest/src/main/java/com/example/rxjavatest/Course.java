package com.example.rxjavatest;

public class Course {
    String courseName;
    String courseId;

    public Course(String courseName, String courseId) {
        this.courseName = courseName;
        this.courseId = courseId;
    }

    @Override
    public String toString() {
        return "Course{" +
                "courseName='" + courseName + '\'' +
                ", courseId='" + courseId + '\'' +
                '}';
    }
}
