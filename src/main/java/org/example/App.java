package org.example;


import org.example.entity.Student;
import org.example.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class App {
    public static void main(String[] args) {

//        HibernateUtil.getSessionFactory();
//        Student student = new Student("Alihan",9);
//        create(student);
//        System.out.println(getById(2));
//        System.out.println(read());
//        update(2,"Alihanchik",10);
//        System.out.println(read());
//        Student student = new Student("Spiderman",9);
//        create(student);
//        System.out.println(read());
//        delete(3);
//        System.out.println(read());
        deleteAll();



    }

    public static int create(Student student) {
        Session session =
                HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(student);
        session.getTransaction().commit();
        session.close();
        System.out.println("Added successfully " + student);
        return student.getId();

    }

    public static Student getById(int id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Student student = session.get(Student.class, id);
        session.getTransaction().commit();
        session.close();
        return student;
    }

    public static List<Student> read() {
        Session session =
                HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        List<Student> students = session.createQuery("FROM Student").getResultList();
        session.getTransaction().commit();
        session.close();
        System.out.println("Finded " + students.size() + "students");
        return students;
    }

    public static void update(int id, String name, int age) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Student student = session.get(Student.class, id);
        student.setName(name);
        student.setAge(age);
        session.getTransaction().commit();
        session.close();
        System.out.println("Successfully updated!");
    }

    public static void delete(int id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Student student = session.get(Student.class, id);
        session.delete(student);
        session.getTransaction().commit();
        session.close();
        System.out.println("Successfully deleted " + student);
    }

    public static void deleteAll() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Query query = session.createQuery("DELETE FROM Student ");
        query.executeUpdate();
        session.getTransaction().commit();
        session.close();
        System.out.println("Successfully deleted all datas in Students");


    }

}
