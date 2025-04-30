package ru.vsu;

import org.w3c.dom.ls.LSOutput;
import ru.vsu.entity.ExamResult;
import ru.vsu.entity.Student;
import ru.vsu.entity.Subject;
import ru.vsu.implementation.StudentService;

import java.time.LocalDate;
import java.util.HashSet;
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

        Set<ExamResult> examResultsPolina = Set.of(
                new ExamResult(LocalDate.of(2022, 1, 10), 5, Subject.PROGRAMMING),
                new ExamResult(LocalDate.of(2022, 1, 15), 4, Subject.LINEAR_ALGEBRA),
                new ExamResult(LocalDate.of(2022, 1, 20), 3, Subject.HISTORY),
                new ExamResult(LocalDate.of(2022, 1, 30), 5, Subject.FUNCTIONAL_ANALYSIS)
        );

        Set<ExamResult> examResultsKonstantin = Set.of(
                new ExamResult(LocalDate.of(2022, 1, 10), 5, Subject.PROGRAMMING),
                new ExamResult(LocalDate.of(2022, 1, 15), 5, Subject.LINEAR_ALGEBRA),
                new ExamResult(LocalDate.of(2022, 1, 20), 5, Subject.HISTORY),
                new ExamResult(LocalDate.of(2022, 1, 30), 5, Subject.FUNCTIONAL_ANALYSIS)
        );

        Set<ExamResult> examResultsDenis = Set.of(
                new ExamResult(LocalDate.of(2022, 1, 10), 5, Subject.PROGRAMMING),
                new ExamResult(LocalDate.of(2022, 1, 15), 4, Subject.LINEAR_ALGEBRA),
                new ExamResult(LocalDate.of(2022, 1, 20), 5, Subject.HISTORY),
                new ExamResult(LocalDate.of(2022, 1, 30), 5, Subject.FUNCTIONAL_ANALYSIS)
        );

        Set<ExamResult> examResultsIlia = Set.of(
                new ExamResult(LocalDate.of(2022, 1, 10), 3, Subject.PROGRAMMING),
                new ExamResult(LocalDate.of(2022, 1, 15), 4, Subject.LINEAR_ALGEBRA),
                new ExamResult(LocalDate.of(2022, 1, 20), 3, Subject.HISTORY),
                new ExamResult(LocalDate.of(2022, 1, 30), 4, Subject.FUNCTIONAL_ANALYSIS)
        );


        List<Student> studentGroup = List.of(
                new Student("Polina", "Poliakova", 17, 1, 14, examResultsPolina),
                new Student("Konstantin", "Zverev", 20, 2, 3, examResultsKonstantin),
                new Student("Denis", "Skibin", 18, 2, 11, examResultsDenis),
                new Student("Ilia", "Kluyev", 17, 1, 14, examResultsIlia)
        );

        List<String> adultStudents = studentService.getAdultStudentsLastNameSorted(studentGroup);
        System.out.println(adultStudents);

        System.out.println(studentService.findYoungestStudent(studentGroup));

        Set<Student> excellentStudents =  studentService.getExcellentStudents(studentGroup);
        System.out.println(excellentStudents);

        System.out.println(studentService.getAverageMark(studentGroup));
    }
}
