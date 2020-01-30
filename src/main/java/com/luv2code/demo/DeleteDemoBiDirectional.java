package com.luv2code.demo;

import com.luv2code.demo_entity.Instructor;
import com.luv2code.demo_entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteDemoBiDirectional {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {
            session.beginTransaction();

            int theId = 2;
            InstructorDetail tempInstructorDetail =
                    session.get(InstructorDetail.class, theId);

            //print the instructor detail
            System.out.println("tempInstructorDetail: " + tempInstructorDetail);

            //print the associated instructor
            System.out.println("the associated instructor: " + tempInstructorDetail.getInstructor());

            //delete instructor detail

            tempInstructorDetail.getInstructor().setInstructorDetail(null); //

            System.out.println("Deleting tempInstructorDetail: "
                    + tempInstructorDetail);
            session.delete(tempInstructorDetail);

            session.getTransaction().commit();

            System.out.println("Done!");

        } catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            session.close();
            session.close();
        }
    }
}
