package com.examly.springapp;

import java.util.List;

import com.examly.springapp.model.Student;

public class SpringappApplication {
    public static void main(String[] args) {
        StudentDAO studentDAO = new StudentDAO();

        Student newStudent = new Student();
		newStudent.setId(100);
        newStudent.setName("Alice");
        newStudent.setDepartment("CSE");
		newStudent.setPhonenumber("1234567890");
		newStudent.setId(101);
        newStudent.setName("Arun");
        newStudent.setDepartment("CSE");
		newStudent.setPhonenumber("123456789");

        studentDAO.saveStudent(newStudent);

        List<Student> studentsNamedAlice = studentDAO.getStudentsByName("Arun");
        for (Student student : studentsNamedAlice) {
            System.out.println("Student: " + student.getName());
			System.out.println("Department: "+student.getDepartment());
        }
		

        studentDAO.closeSessionFactory();
    }
}

