package com.javarush.task.task29.task2909.human;

import java.util.ArrayList;
import java.util.List;

public class University {
    private String name;
    private int age;
    private List<Student> students = new ArrayList<>();

    public University(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Student getStudentWithAverageGrade(double averageGrade) {
        for (Student student : students) {
            if (student.getAverageGrade() == averageGrade)
                return student;
        }
        return null;
    }

    public Student getStudentWithMaxAverageGrade() {
        if (students.size() > 0) {
            Student studentWithMaxAverageGrade = students.get(0);
            double maxAverageGrade = studentWithMaxAverageGrade.getAverageGrade();

            for (Student student : students) {
                if (student.getAverageGrade() > maxAverageGrade) {
                    studentWithMaxAverageGrade = student;
                    maxAverageGrade = student.getAverageGrade();
                }
            }
            return studentWithMaxAverageGrade;
        }
        return null;
    }

    public Student getStudentWithMinAverageGrade() {
        if (students.size() > 0) {
            Student studentWithMinAverageGrade = students.get(0);
            double maxAverageGrade = studentWithMinAverageGrade.getAverageGrade();

            for (Student student : students) {
                if (student.getAverageGrade() < maxAverageGrade) {
                    studentWithMinAverageGrade = student;
                    maxAverageGrade = student.getAverageGrade();
                }
            }
            return studentWithMinAverageGrade;
        }
        return null;
    }

    /*
    public Student getStudentWithMaxAverageGrade() {
        Student goodBoi = Collections.max(students, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return (int) (o1.getAverageGrade() - o2.getAverageGrade());
            }
        });

        return goodBoi;
    }

    public Student getStudentWithMinAverageGrade() {   // ??????????????
        Student badBoi = Collections.min(students, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return Double.compare(o1.getAverageGrade(), o2.getAverageGrade());
            }
    });
        return badBoi;
    }

    public Student getStudentWithMaxAverageGrade() {
        return Collections.max(students, (o1, o2) -> (int) (o1.getAverageGrade() - o2.getAverageGrade()));
 }
     */

    public void expel(Student student) {
        students.remove(student);
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}