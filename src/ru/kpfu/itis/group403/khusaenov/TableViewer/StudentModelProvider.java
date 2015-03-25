package ru.kpfu.itis.group403.khusaenov.TableViewer;

import java.util.Comparator;

public class StudentModelProvider implements ModelProvider<Student> {
    Student[] students;

    public StudentModelProvider(Student[] students) {
        this.students = students;
    }

    @Override
    public Student[] getModel() {
        return students;
    }

    @Override
    public Comparator<Student> getComporator() {
        return Student.StudentHelper.getNameComparator();
    }
}
