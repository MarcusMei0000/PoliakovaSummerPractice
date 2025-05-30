package org.project.group;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.project.group.TestData.*;


class StudentServiceTests {

    private final StudentService studentService = new StudentServiceImpl();

    @Test
    void getAdultStudentsLastNameSorted() {
        // given
        List<String> expectedLastNames = List.of("Belyaev", "Demchenko", "Polyhina", "Portnoy");

        // when
        List<String> actualExcellentStudents = studentService.getAdultStudentsLastNameSorted(ALL_STUDENTS);

        // then
        assertEquals(expectedLastNames, actualExcellentStudents);
    }


    @Test
    void getExcellentStudentReturnsOnlyExcellentStudents() {
        // given
        Set<Student> expectedExcellentStudents = Set.of(STUDENT_MARIA, STUDENT_VLADIMIR);

        // when
        Set<Student> actualExcellentStudents = studentService.getExcellentStudents(ALL_STUDENTS);

        // then
        assertEquals(expectedExcellentStudents, actualExcellentStudents);
    }

    @Test
    void getAverageMarkReturnsAverageMark() {
        // given
        double expectedAverageMark = 4.5;

        // when
        double actualAverageMark = studentService.getAverageMark(ALL_STUDENTS);

        // then
        assertEquals(expectedAverageMark, actualAverageMark, 0.1);
    }

    @Test
    void findYoungestStudentReturnsYoungestStudent() {
        // given

        // when
        Student actualStudent = studentService.findYoungestStudent(ALL_STUDENTS);

        // then
        assertEquals(STUDENT_ANTON, actualStudent);
    }
}