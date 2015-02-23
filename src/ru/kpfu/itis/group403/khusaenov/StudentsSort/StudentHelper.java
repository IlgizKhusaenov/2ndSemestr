package ru.kpfu.itis.group403.khusaenov.StudentsSort;

import java.util.Comparator;

public class StudentHelper {

    public static Comparator<Student> getGradeComparator() {

        return new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return ((Integer)o1.getGrade()).compareTo(o2.getGrade());
            }
        };
    }
    public static Comparator<Student> getYearComparator() {
        return new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return ((Integer)o1.getYear()).compareTo(o2.getYear());
            }
        };
    }

    public static Comparator<Student> getNameComparator() {
        return new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return o1.getName().compareTo(o2.getName());
            }
        };
    }
}
