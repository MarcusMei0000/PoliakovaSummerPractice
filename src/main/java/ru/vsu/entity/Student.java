package ru.vsu.entity;

import java.util.Objects;
import java.util.Set;

public class Student {

    private final String firstName;
    private final String lastName;
    private final int age;
    private final int year;
    private final int group;


    public Student(String firstName, String lastName, int age, int year, int group) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.year = year;
        this.group = group;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    public int getYear() {
        return year;
    }

    public int getGroup() {
        return group;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Student student = (Student) o;
        return Objects.equals(firstName, student.firstName)
                && Objects.equals(lastName, student.lastName)
                && Objects.equals(age, student.age)
                && Objects.equals(year, student.year)
                && Objects.equals(group, student.group);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, age, year, group);
    }

    @Override
    public String toString() {
        return "Student{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", course=" + year +
                ", group=" + group +
                '}';
    }
}
