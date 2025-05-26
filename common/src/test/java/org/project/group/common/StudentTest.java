package org.project.group.common;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
class StudentTest {

    // Test data
    private final String firstName = "John";
    private final String lastName = "Doe";
    private final int age = 20;
    private final int year = 2;
    private final int group = 101;

    // Create a mock ExamResult instead of a real one
    private final ExamResult examResult = Mockito.mock(ExamResult.class);
    private final Set<ExamResult> examResults = Set.of(examResult);

    @Test
    void constructor_ShouldInitializeAllFields() {
        Student student = new Student(firstName, lastName, age, year, group, examResults);

        assertAll(
                () -> assertEquals(firstName, student.getFirstName()),
                () -> assertEquals(lastName, student.getLastName()),
                () -> assertEquals(age, student.getAge()),
                () -> assertEquals(year, student.getYear()),
                () -> assertEquals(group, student.getGroup()),
                () -> assertEquals(examResults, student.getExamResults())
        );
    }

    @Test
    void getFirstName_ShouldReturnCorrectValue() {
        Student student = new Student(firstName, lastName, age, year, group, examResults);
        assertEquals(firstName, student.getFirstName());
    }

    @Test
    void getLastName_ShouldReturnCorrectValue() {
        Student student = new Student(firstName, lastName, age, year, group, examResults);
        assertEquals(lastName, student.getLastName());
    }

    @Test
    void getAge_ShouldReturnCorrectValue() {
        Student student = new Student(firstName, lastName, age, year, group, examResults);
        assertEquals(age, student.getAge());
    }

    @Test
    void getYear_ShouldReturnCorrectValue() {
        Student student = new Student(firstName, lastName, age, year, group, examResults);
        assertEquals(year, student.getYear());
    }

    @Test
    void getGroup_ShouldReturnCorrectValue() {
        Student student = new Student(firstName, lastName, age, year, group, examResults);
        assertEquals(group, student.getGroup());
    }

    @Test
    void getExamResults_ShouldReturnCorrectValue() {
        Student student = new Student(firstName, lastName, age, year, group, examResults);
        assertEquals(examResults, student.getExamResults());
    }

    @Test
    void equals_ShouldReturnTrueForSameObject() {
        Student student = new Student(firstName, lastName, age, year, group, examResults);
        assertTrue(student.equals(student));
    }

    @Test
    void equals_ShouldReturnTrueForEqualObjects() {
        Student student1 = new Student(firstName, lastName, age, year, group, examResults);
        Student student2 = new Student(firstName, lastName, age, year, group, examResults);
        assertTrue(student1.equals(student2));
    }

    @Test
    void equals_ShouldReturnFalseForNull() {
        Student student = new Student(firstName, lastName, age, year, group, examResults);
        assertFalse(student.equals(null));
    }

    @Test
    void equals_ShouldReturnFalseForDifferentClass() {
        Student student = new Student(firstName, lastName, age, year, group, examResults);
        assertFalse(student.equals("Not a Student"));
    }

    @Test
    void equals_ShouldReturnFalseForDifferentFirstName() {
        Student student1 = new Student(firstName, lastName, age, year, group, examResults);
        Student student2 = new Student("Jane", lastName, age, year, group, examResults);
        assertFalse(student1.equals(student2));
    }

    @Test
    void equals_ShouldReturnFalseForDifferentLastName() {
        Student student1 = new Student(firstName, lastName, age, year, group, examResults);
        Student student2 = new Student(firstName, "Smith", age, year, group, examResults);
        assertFalse(student1.equals(student2));
    }

    @Test
    void equals_ShouldReturnFalseForDifferentAge() {
        Student student1 = new Student(firstName, lastName, age, year, group, examResults);
        Student student2 = new Student(firstName, lastName, 21, year, group, examResults);
        assertFalse(student1.equals(student2));
    }

    @Test
    void equals_ShouldReturnFalseForDifferentYear() {
        Student student1 = new Student(firstName, lastName, age, year, group, examResults);
        Student student2 = new Student(firstName, lastName, age, 3, group, examResults);
        assertFalse(student1.equals(student2));
    }

    @Test
    void equals_ShouldReturnFalseForDifferentGroup() {
        Student student1 = new Student(firstName, lastName, age, year, group, examResults);
        Student student2 = new Student(firstName, lastName, age, year, 102, examResults);
        assertFalse(student1.equals(student2));
    }

    @Test
    void equals_ShouldReturnFalseForDifferentExamResults() {
        Student student1 = new Student(firstName, lastName, age, year, group, examResults);
        Set<ExamResult> differentResults = Set.of(new ExamResult(LocalDate.now(), 90, Subject.FUNCTIONAL_ANALYSIS));
        Student student2 = new Student(firstName, lastName, age, year, group, differentResults);
        assertFalse(student1.equals(student2));
    }

    @Test
    void hashCode_ShouldBeEqualForEqualObjects() {
        Student student1 = new Student(firstName, lastName, age, year, group, examResults);
        Student student2 = new Student(firstName, lastName, age, year, group, examResults);
        assertEquals(student1.hashCode(), student2.hashCode());
    }

    @Test
    void hashCode_ShouldBeDifferentForDifferentObjects() {
        Student student1 = new Student(firstName, lastName, age, year, group, examResults);
        Student student2 = new Student("Jane", lastName, age, year, group, examResults);
        assertNotEquals(student1.hashCode(), student2.hashCode());
    }

    @Test
    void toString_ShouldContainAllFields() {
        Student student = new Student(firstName, lastName, age, year, group, examResults);
        String result = student.toString();

        assertAll(
                () -> assertTrue(result.contains("firstName='" + firstName + "'")),
                () -> assertTrue(result.contains("lastName='" + lastName + "'")),
                () -> assertTrue(result.contains("age=" + age)),
                () -> assertTrue(result.contains("course=" + year)),
                () -> assertTrue(result.contains("group=" + group)),
                () -> assertTrue(result.contains("examResults="))
        );
    }

    @Test
    void toString_ShouldHandleEmptyExamResults() {
        Student student = new Student(firstName, lastName, age, year, group, Set.of());
        String result = student.toString();
        assertTrue(result.contains("examResults=[]"));
    }

    @Test
    void toString_ShouldHandleNullExamResults() {
        Student student = new Student(firstName, lastName, age, year, group, null);
        String result = student.toString();
        assertTrue(result.contains("examResults=null"));
    }

}