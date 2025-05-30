package org.project.group;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class MainTests {
    private final StudentService studentService = new StudentServiceImpl();

    // Test data setup (same as in Main class)
    private final Set<ExamResult> examResultsPolina = Set.of(
            new ExamResult(LocalDate.of(2022, 1, 10), 5, Subject.PROGRAMMING),
            new ExamResult(LocalDate.of(2022, 1, 15), 4, Subject.LINEAR_ALGEBRA),
            new ExamResult(LocalDate.of(2022, 1, 20), 3, Subject.HISTORY),
            new ExamResult(LocalDate.of(2022, 1, 30), 5, Subject.FUNCTIONAL_ANALYSIS)
    );

    private final Set<ExamResult> examResultsKonstantin = Set.of(
            new ExamResult(LocalDate.of(2022, 1, 10), 5, Subject.PROGRAMMING),
            new ExamResult(LocalDate.of(2022, 1, 15), 5, Subject.LINEAR_ALGEBRA),
            new ExamResult(LocalDate.of(2022, 1, 20), 5, Subject.HISTORY),
            new ExamResult(LocalDate.of(2022, 1, 30), 5, Subject.FUNCTIONAL_ANALYSIS)
    );

    private final Set<ExamResult> examResultsDenis = Set.of(
            new ExamResult(LocalDate.of(2022, 1, 10), 5, Subject.PROGRAMMING),
            new ExamResult(LocalDate.of(2022, 1, 15), 4, Subject.LINEAR_ALGEBRA),
            new ExamResult(LocalDate.of(2022, 1, 20), 5, Subject.HISTORY),
            new ExamResult(LocalDate.of(2022, 1, 30), 5, Subject.FUNCTIONAL_ANALYSIS)
    );

    private final Set<ExamResult> examResultsIlia = Set.of(
            new ExamResult(LocalDate.of(2022, 1, 10), 3, Subject.PROGRAMMING),
            new ExamResult(LocalDate.of(2022, 1, 15), 4, Subject.LINEAR_ALGEBRA),
            new ExamResult(LocalDate.of(2022, 1, 20), 3, Subject.HISTORY),
            new ExamResult(LocalDate.of(2022, 1, 30), 4, Subject.FUNCTIONAL_ANALYSIS)
    );

    private final List<Student> studentGroup = List.of(
            new Student("Polina", "Poliakova", 17, 1, 14, examResultsPolina),
            new Student("Konstantin", "Zverev", 20, 2, 3, examResultsKonstantin),
            new Student("Denis", "Skibin", 18, 2, 11, examResultsDenis),
            new Student("Ilia", "Kluyev", 17, 1, 14, examResultsIlia)
    );

    @Test
    void testGetAdultStudentsLastNameSorted() {
        List<String> adults = studentService.getAdultStudentsLastNameSorted(studentGroup);

        assertEquals(2, adults.size());
        assertEquals("Skibin", adults.get(0)); // Should be first due to alphabetical order
        assertEquals("Zverev", adults.get(1));
        assertFalse(adults.contains("Poliakova")); // Not adult
        assertFalse(adults.contains("Kluyev")); // Not adult
    }

    @Test
    void testFindYoungestStudent() {
        Student youngest = studentService.findYoungestStudent(studentGroup);

        assertNotNull(youngest);
        // Both Polina and Ilia are 17, but we should check implementation
        assertTrue(youngest.getFirstName().equals("Polina") ||
                youngest.getFirstName().equals("Ilia"));
        assertEquals(17, youngest.getAge());
    }

    @Test
    void testGetAverageMark() {
        double average = studentService.getAverageMark(studentGroup);

        // Calculate expected average manually:
        // Polina: (5+4+3+5)/4 = 4.25
        // Konstantin: (5+5+5+5)/4 = 5.0
        // Denis: (5+4+5+5)/4 = 4.75
        // Ilia: (3+4+3+4)/4 = 3.5
        // Total average: (4.25 + 5.0 + 4.75 + 3.5)/4 ≈ 4.375

        assertEquals(4.375, average, 0.001);
    }

    @Test
    void testEmptyStudentList() {
        List<Student> emptyList = List.of();

        assertTrue(studentService.getAdultStudentsLastNameSorted(emptyList).isEmpty());
        assertNull(studentService.findYoungestStudent(emptyList));
        assertTrue(studentService.getExcellentStudents(emptyList).isEmpty());
        assertEquals(0.0, studentService.getAverageMark(emptyList));
    }
}