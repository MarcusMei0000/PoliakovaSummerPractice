package org.project.group.services;

import org.junit.jupiter.api.Test;
import org.project.group.common.Student;

import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.project.group.services.TestData.*;


public class StudentServiceTests {

    private final StudentService studentService = new StudentServiceImpl();

    @Test
    public void getAdultStudentsLastNameSorted() {
        // given
        List<String> expectedLastNames = List.of("Belyaev", "Demchenko", "Polyhina", "Portnoy");

        // when
        List<String> actualExcellentStudents = studentService.getAdultStudentsLastNameSorted(ALL_STUDENTS);

        // then
        assertEquals(expectedLastNames, actualExcellentStudents);
    }


    @Test
    public void getExcellentStudentReturnsOnlyExcellentStudents() {
        // given
        Set<Student> expectedExcellentStudents = Set.of(STUDENT_MARIA, STUDENT_VLADIMIR);

        // when
        Set<Student> actualExcellentStudents = studentService.getExcellentStudents(ALL_STUDENTS);

        // then
        assertEquals(expectedExcellentStudents, actualExcellentStudents);
    }

    @Test
    public void getAverageMarkReturnsAverageMark() {
        // given
        double expectedAverageMark = 4.5;

        // when
        double actualAverageMark = studentService.getAverageMark(ALL_STUDENTS);

        // then
        assertEquals(expectedAverageMark, actualAverageMark, 0.1);
    }

    @Test
    public void findYoungestStudentReturnsYoungestStudent() {
        // given
        Student expectedStudent = STUDENT_ANTON;

        // when
        Student actualStudent = studentService.findYoungestStudent(ALL_STUDENTS);

        // then
        assertEquals(expectedStudent, actualStudent);
    }
}