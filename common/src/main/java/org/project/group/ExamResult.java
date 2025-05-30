package org.project.group;

import java.time.LocalDate;
import java.util.Objects;

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
}
