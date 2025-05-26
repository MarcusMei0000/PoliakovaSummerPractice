package org.project.group.common;

import java.time.LocalDate;
import java.util.Objects;
import java.util.Set;

public class ExamResult {

    private final LocalDate examDate;
    private final int mark;
    private final Subject subject;

    public ExamResult(LocalDate examDate, Integer mark, Subject subject) {
        this.examDate = examDate;
        this.mark = mark;
        this.subject = subject;
    }

    public LocalDate getExamDate() {
        return examDate;
    }

    public Integer getMark() {
        return mark;
    }

    public Subject getSubject() {
        return subject;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ExamResult that = (ExamResult) o;
        return Objects.equals(examDate, that.examDate)
                && Objects.equals(mark, that.mark)
                && subject == that.subject;
    }

    @Override
    public int hashCode() {
        return Objects.hash(examDate, mark, subject);
    }

    @Override
    public String toString() {
        return "ExamResult{" +
                "examDate=" + examDate +
                ", mark=" + mark +
                ", subject=" + subject +
                '}';
    }

    public static class Student {

        private final String firstName;
        private final String lastName;
        private final int age;
        private final int year;
        private final int group;
        private final Set<ExamResult> examResults;


        public Student(String firstName, String lastName, int age, int year, int group, Set<ExamResult> examResults) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.age = age;
            this.year = year;
            this.group = group;
            this.examResults = examResults;
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

        public Set<ExamResult> getExamResults() {
            return examResults;
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
                    && Objects.equals(group, student.group)
                    && Objects.equals(examResults, student.examResults);
        }

        @Override
        public int hashCode() {
            return Objects.hash(firstName, lastName, age, year, group, examResults);
        }

        @Override
        public String toString() {
            return "Student{" +
                    "firstName='" + firstName + '\'' +
                    ", lastName='" + lastName + '\'' +
                    ", age=" + age +
                    ", course=" + year +
                    ", group=" + group +
                    ", examResults=" + examResults +
                    '}';
        }
    }
}
