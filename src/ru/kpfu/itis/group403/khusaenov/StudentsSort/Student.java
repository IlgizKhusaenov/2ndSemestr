package ru.kpfu.itis.group403.khusaenov.StudentsSort;

public class Student {
    private int grade;
    private int year;
    private String name;

    public Student(int grade, int year, String name) {
        this.grade = grade;
        this.year = year;
        this.name = name;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student [grade=" + grade + ", year=" + year + ", name=" + name + "]";
    }
}
