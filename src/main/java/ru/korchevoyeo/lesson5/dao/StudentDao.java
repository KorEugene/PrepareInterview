package ru.korchevoyeo.lesson5.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.korchevoyeo.lesson5.entity.Student;

import java.util.List;

@Repository
public class StudentDao {

    private final SessionFactory sessionFactory;

    @Autowired
    public StudentDao(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public Student findById(Long id) {
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            Student student = session.get(Student.class, id);
            session.getTransaction().commit();
            return student;
        }
    }

    public List<Student> findAll() {
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            List<Student> students = session.createQuery("select s from Student s", Student.class).getResultList();
            session.getTransaction().commit();
            return students;
        }
    }

    public Student save(Student student) {
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            session.save(student);
            session.getTransaction().commit();
            return student;
        }
    }

    public void update(Student student) {
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            session.update(student);
            session.getTransaction().commit();
        }
    }

    public void deleteById(Long id) {
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            session.createQuery("delete from Student s where s.id = :id")
                    .setParameter("id", id)
                    .executeUpdate();
            session.getTransaction().commit();
        }
    }
}
