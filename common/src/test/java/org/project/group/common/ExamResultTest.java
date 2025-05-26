package org.project.group.common;

import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
import static org.junit.jupiter.api.Assertions.*;

class ExamResultTest {

    // Test data
    private final LocalDate testDate1 = LocalDate.of(2023, 6, 15);
    private final LocalDate testDate2 = LocalDate.of(2023, 6, 20);
    private final Subject testSubject1 = Subject.MATHEMATICAL_ANALYSIS;
    private final Subject testSubject2 = Subject.FUNCTIONAL_ANALYSIS;
    private final int testMark1 = 85;
    private final int testMark2 = 90;

    @Test
    void examResultConstructorAndGetters() {
        ExamResult result = new ExamResult(testDate1, testMark1, testSubject1);

        assertEquals(testDate1, result.getExamDate());
        assertEquals(testMark1, result.getMark());
        assertEquals(testSubject1, result.getSubject());
    }

    @Test
    void examResultEquals_SameObject() {
        ExamResult result = new ExamResult(testDate1, testMark1, testSubject1);
        assertTrue(result.equals(result));
    }

    @Test
    void examResultEquals_NullObject() {
        ExamResult result = new ExamResult(testDate1, testMark1, testSubject1);
        assertFalse(result.equals(null));
    }

    @Test
    void examResultEquals_DifferentClass() {
        ExamResult result = new ExamResult(testDate1, testMark1, testSubject1);
        assertFalse(result.equals("Not an ExamResult"));
    }

    @Test
    void examResultEquals_EqualObjects() {
        ExamResult result1 = new ExamResult(testDate1, testMark1, testSubject1);
        ExamResult result2 = new ExamResult(testDate1, testMark1, testSubject1);
        assertTrue(result1.equals(result2));
    }

    @Test
    void examResultEquals_DifferentDates() {
        ExamResult result1 = new ExamResult(testDate1, testMark1, testSubject1);
        ExamResult result2 = new ExamResult(testDate2, testMark1, testSubject1);
        assertFalse(result1.equals(result2));
    }

    @Test
    void examResultEquals_DifferentMarks() {
        ExamResult result1 = new ExamResult(testDate1, testMark1, testSubject1);
        ExamResult result2 = new ExamResult(testDate1, testMark2, testSubject1);
        assertFalse(result1.equals(result2));
    }

    @Test
    void examResultEquals_DifferentSubjects() {
        ExamResult result1 = new ExamResult(testDate1, testMark1, testSubject1);
        ExamResult result2 = new ExamResult(testDate1, testMark1, testSubject2);
        assertFalse(result1.equals(result2));
    }

    @Test
    void examResultHashCode_EqualObjects() {
        ExamResult result1 = new ExamResult(testDate1, testMark1, testSubject1);
        ExamResult result2 = new ExamResult(testDate1, testMark1, testSubject1);
        assertEquals(result1.hashCode(), result2.hashCode());
    }

    // Student tests
    @Test
    void studentConstructorAndGetters() {
        Set<ExamResult> examResults = new HashSet<>();
        examResults.add(new ExamResult(testDate1, testMark1, testSubject1));

        Student student = new Student(
                "John", "Doe", 20, 2, 101, examResults);

        assertEquals("John", student.getFirstName());
        assertEquals("Doe", student.getLastName());
        assertEquals(20, student.getAge());
        assertEquals(2, student.getYear());
        assertEquals(101, student.getGroup());
        assertEquals(examResults, student.getExamResults());
    }

    @Test
    void studentEquals_SameObject() {
        Student student = createTestStudent();
        assertTrue(student.equals(student));
    }

    @Test
    void studentEquals_NullObject() {
        Student student = createTestStudent();
        assertFalse(student.equals(null));
    }

    @Test
    void studentEquals_DifferentClass() {
        Student student = createTestStudent();
        assertFalse(student.equals("Not a Student"));
    }

    @Test
    void studentEquals_EqualObjects() {
        Student student1 = createTestStudent();
        Student student2 = createTestStudent();
        assertTrue(student1.equals(student2));
    }

    @Test
    void studentEquals_DifferentFirstNames() {
        Student student1 = createTestStudent();
        Student student2 = new Student(
                "Jane", "Doe", 20, 2, 101, student1.getExamResults());
        assertFalse(student1.equals(student2));
    }

    @Test
    void studentEquals_DifferentLastNames() {
        Student student1 = createTestStudent();
        Student student2 = new Student(
                "John", "Smith", 20, 2, 101, student1.getExamResults());
        assertFalse(student1.equals(student2));
    }

    @Test
    void studentEquals_DifferentAges() {
        Student student1 = createTestStudent();
        Student student2 = new Student(
                "John", "Doe", 21, 2, 101, student1.getExamResults());
        assertFalse(student1.equals(student2));
    }

    @Test
    void studentEquals_DifferentYears() {
        Student student1 = createTestStudent();
        Student student2 = new Student(
                "John", "Doe", 20, 3, 101, student1.getExamResults());
        assertFalse(student1.equals(student2));
    }

    @Test
    void studentEquals_DifferentGroups() {
        Student student1 = createTestStudent();
        Student student2 = new Student(
                "John", "Doe", 20, 2, 102, student1.getExamResults());
        assertFalse(student1.equals(student2));
    }

    @Test
    void studentEquals_DifferentExamResults() {
        Student student1 = createTestStudent();
        Set<ExamResult> differentResults = new HashSet<>();
        differentResults.add(new ExamResult(testDate2, testMark2, testSubject2));

        Student student2 = new Student(
                "John", "Doe", 20, 2, 101, differentResults);
        assertFalse(student1.equals(student2));
    }

    @Test
    void studentHashCode_EqualObjects() {
        Student student1 = createTestStudent();
        Student student2 = createTestStudent();
        assertEquals(student1.hashCode(), student2.hashCode());
    }


    private Student createTestStudent() {
        Set<ExamResult> examResults = new HashSet<>();
        examResults.add(new ExamResult(testDate1, testMark1, testSubject1));
        return new Student("John", "Doe", 20, 2, 101, examResults);
    }
}