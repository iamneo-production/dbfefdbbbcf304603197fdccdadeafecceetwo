package com.examly.springapp;

import com.examly.springapp.model.Student;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

public class SpringappApplicationTests {

    private StudentDAO studentDAO;

    @BeforeEach
    public void setUp() {
        studentDAO = new StudentDAO();
    }

    @AfterEach
    public void tearDown() {
        studentDAO.closeSessionFactory();
    }

    @Test
    public void testSaveAndGetStudentsByName() {
        Student newStudent = new Student();
        newStudent.setId(100);
        newStudent.setName("Alice");
        newStudent.setDepartment("CSE");
        newStudent.setPhonenumber("1234567890");

        studentDAO.saveStudent(newStudent);

        List<Student> studentsNamedAlice = studentDAO.getStudentsByName("Alice");

        assertEquals(1, studentsNamedAlice.size());
        assertEquals("Alice", studentsNamedAlice.get(0).getName());
        assertEquals("CSE", studentsNamedAlice.get(0).getDepartment());
    }

    // Add more test methods for other CRUD operations
}
