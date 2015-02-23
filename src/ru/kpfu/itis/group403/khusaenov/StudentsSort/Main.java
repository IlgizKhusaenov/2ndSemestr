package ru.kpfu.itis.group403.khusaenov.StudentsSort;

import java.util.Arrays;

public class Main {

    private static void printStudents(Student[] students) {

        for (Student student : students) {

            System.out.println(student);

        }

    }

    public static void main(String[] args) {

        String nameArray[] = {"Harry Potter", "John Watson", "Jack Sparrow", "Marlyn Manson", "Freddy Krueger", "Jason Voorhees", "Marat Mirzaevich"};

        int gradeArray[] = {1, 2, 3, 4, 5, 4, 4, 3, 5, 5, 2, 3, 4, 4};
        int yearArray[] = {1996, 1987, 1856, 1678, 1899, 1456, 1999, 1764};
        Student students[] = new Student[nameArray.length];
        for (int i = 0; i < nameArray.length; i++) {
            students[i] = new Student(gradeArray[i], yearArray[i], nameArray[i]);
        }

        System.out.println("By name");
        Arrays.sort(students, StudentHelper.getNameComparator());
        printStudents(students);

        System.out.println("By grade");
        Arrays.sort(students, StudentHelper.getGradeComparator());
        printStudents(students);

        System.out.println("By year:");
        Arrays.sort(students, StudentHelper.getYearComparator());
        printStudents(students);

    }

}

