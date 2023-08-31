package com.examly.springapp;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.examly.springapp.model.Student;

import java.util.List;

public class StudentDAO {
    private SessionFactory sessionFactory;

    public StudentDAO() {
        sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
    }

    public void saveStudent(Student student) {
        Session session = sessionFactory.openSession();
        Transaction tx = null;
    
        try {
            tx = session.beginTransaction();
            session.save(student);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
    
    
    
    
    

    // Other CRUD methods

    public List<Student> getStudentsByName(String name) {
        Session session = sessionFactory.openSession();
        String hql = "FROM Student WHERE name = :studentName";

        Query<Student> query = session.createQuery(hql);
        query.setParameter("studentName", name);
        

        List<Student> students = query.list();

        session.close();
        return students;
    }

    // Close session factory
    public void closeSessionFactory() {
        sessionFactory.close();
    }
}

