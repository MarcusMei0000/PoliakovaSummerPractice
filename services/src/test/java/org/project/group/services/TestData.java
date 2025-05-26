package org.project.group.services;

import org.project.group.common.ExamResult;
import org.project.group.common.Student;
import org.project.group.common.Subject;

import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Set;

import static java.util.Set.of;

public class TestData {

    public static final LocalDate MATHEMATICAL_ANALYSIS_EXAM_DATE_TIME = LocalDate.parse("2021-12-03T10:15:30.00", DateTimeFormatter.ISO_LOCAL_DATE_TIME);
    public static final LocalDate PROGRAMMING_EXAM_DATE_TIME = LocalDate.parse("2021-12-04T10:15:30.00", DateTimeFormatter.ISO_LOCAL_DATE_TIME);
    public static final LocalDate LINEAR_ALGEBRA_EXAM_DATE_TIME = LocalDate.parse("2021-12-05T10:15:30.00", DateTimeFormatter.ISO_LOCAL_DATE_TIME);
    public static final LocalDate HISTORY_EXAM_DATE_TIME = LocalDate.parse("2021-12-06T10:15:30.00", DateTimeFormatter.ISO_LOCAL_DATE_TIME);
    public static final LocalDate FUNCTIONAL_ANALYSIS_EXAM_DATE_TIME = LocalDate.parse("2021-12-07T10:15:30.00", DateTimeFormatter.ISO_LOCAL_DATE_TIME);

    public static final Student STUDENT_MIKE = new Student("Mike", "Portnoy", 18, 1, 3, of(
            new ExamResult(MATHEMATICAL_ANALYSIS_EXAM_DATE_TIME, 5, Subject.MATHEMATICAL_ANALYSIS),
            new ExamResult(PROGRAMMING_EXAM_DATE_TIME, 4, Subject.PROGRAMMING),
            new ExamResult(HISTORY_EXAM_DATE_TIME, 5, Subject.PROGRAMMING)
    ));

    public static final Student STUDENT_ANN = new Student("Anna", "Polyhina", 19, 1, 3, of(
            new ExamResult(MATHEMATICAL_ANALYSIS_EXAM_DATE_TIME, 3, Subject.MATHEMATICAL_ANALYSIS),
            new ExamResult(PROGRAMMING_EXAM_DATE_TIME, 3, Subject.PROGRAMMING),
            new ExamResult(HISTORY_EXAM_DATE_TIME, 4, Subject.PROGRAMMING)
    ));

    public static final Student STUDENT_VLADIMIR = new Student("Vladimir", "Belyaev", 23, 4, 91, of(
            new ExamResult(MATHEMATICAL_ANALYSIS_EXAM_DATE_TIME, 5, Subject.MATHEMATICAL_ANALYSIS),
            new ExamResult(PROGRAMMING_EXAM_DATE_TIME, 5, Subject.PROGRAMMING),
            new ExamResult(HISTORY_EXAM_DATE_TIME, 5, Subject.HISTORY),
            new ExamResult(LINEAR_ALGEBRA_EXAM_DATE_TIME, 5, Subject.LINEAR_ALGEBRA),
            new ExamResult(FUNCTIONAL_ANALYSIS_EXAM_DATE_TIME, 5, Subject.LINEAR_ALGEBRA)
    ));

    public static final Student STUDENT_MARIA = new Student("Maria", "Demchenko", 22, 4, 91, of(
            new ExamResult(MATHEMATICAL_ANALYSIS_EXAM_DATE_TIME, 5, Subject.MATHEMATICAL_ANALYSIS),
            new ExamResult(PROGRAMMING_EXAM_DATE_TIME, 5, Subject.PROGRAMMING),
            new ExamResult(HISTORY_EXAM_DATE_TIME, 5, Subject.HISTORY),
            new ExamResult(LINEAR_ALGEBRA_EXAM_DATE_TIME, 5, Subject.LINEAR_ALGEBRA),
            new ExamResult(FUNCTIONAL_ANALYSIS_EXAM_DATE_TIME, 5, Subject.LINEAR_ALGEBRA)
    ));

    public static final Student STUDENT_ANTON = new Student("Anton", "Obanin", 17, 1, 4, of(
            new ExamResult(MATHEMATICAL_ANALYSIS_EXAM_DATE_TIME, 3, Subject.MATHEMATICAL_ANALYSIS)
    ));

    public static final Set<Student> ALL_STUDENTS = Set.of(STUDENT_MIKE, STUDENT_ANN, STUDENT_VLADIMIR, STUDENT_MARIA, STUDENT_ANTON);
}
