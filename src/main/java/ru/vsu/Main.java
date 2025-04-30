package ru.vsu;

import org.w3c.dom.ls.LSOutput;
import ru.vsu.entity.Student;
import ru.vsu.implementation.StudentService;

import java.util.List;
import java.util.Set;

/*
* Полякова Полина Геннадиевна 1к 14г учебная (технологическая) практика
*
* Спроектировать архитектуру классов, состоящую из вложенных классов, абстрактного класса и его реализации.
* Продемонстрировать работу методов:
* - Найти всех совершеннолетних студентов
* - Найти всех студентов-отличников
* - Найти средний балл студентов
* - Найти младшего студента
*/
public class Main {

    public static void main(String[] args) {
        StudentService studentService = new StudentService();
        List<Student> studentGroup = List.of(
                new Student("Polina", "Poliakova", 17, 1, 14),
                new Student("Konstantin", "Zverev", 20, 2, 3),
                new Student("Denis", "Skibin", 18, 2, 11),
                new Student("Ilia", "kluyev", 17, 1, 14));
        List<String> adultStudents = studentService.getAdultStudentsLastNameSorted(studentGroup);

        System.out.println(adultStudents);

        System.out.println(studentService.findYoungestStudent(studentGroup));
    }
}
