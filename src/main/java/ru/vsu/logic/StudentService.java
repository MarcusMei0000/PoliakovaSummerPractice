package ru.vsu.logic;

import ru.vsu.entity.Student;

import java.util.Collection;
import java.util.List;
import java.util.Set;

public interface StudentService {

    /**
     * Возвращает упорядоченные фамилии совершеннолетних студентов
     */
    List<String> getAdultStudentsLastNameSorted(Collection<Student> students);

    /**
     * Возвращает самого молодого студента
     */
    Student findYoungestStudent(Collection<Student> students);

}
