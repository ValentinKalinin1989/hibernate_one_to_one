package com.luv2code.demo;

import com.luv2code.demo_entity.Instructor;
import com.luv2code.demo_entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateDemo {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {
            /*
            Instructor tempInstructor =
                    new Instructor("Chad", "Darby", "darby@luv2code.come");
            InstructorDetail tempInstructorDetail = new InstructorDetail(
                    "http://www.luv2code.com",
                    "Luv 2 code!!!");

             */
            Instructor tempInstructor =
                    new Instructor("Madhu", "Patel", "madhuy@luv2code.come");
            InstructorDetail tempInstructorDetail = new InstructorDetail(
                    "http://youtube.com",
                    "Luv 2 code!!!");

            tempInstructor.setInstructorDetail(tempInstructorDetail);

            session.beginTransaction();

            System.out.println("Saving instructor: " + tempInstructor);
            session.save(tempInstructor);

            session.getTransaction().commit();
        } finally {
            session.close();
        }

    }

}

