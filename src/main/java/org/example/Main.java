package org.example;

import org.example.model.Employee;
import org.example.model.Presence;
import org.example.model.SchoolClass;
import org.example.model.Student;
import org.hibernate.Session;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Main {
    public static void main(String[] args) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        Student s1 = Student.builder()
                .firstName("NameTest1")
                .surName("SurTest1")
                .albumNumber("w66666")
                .build();

        Student s2 = Student.builder()
                .firstName("NameTest2")
                .surName("SurTest2")
                .albumNumber("w66667")
                .build();

        Student s3 = Student.builder()
                .firstName("NameTest3")
                .surName("SurTest3")
                .albumNumber("w66668")
                .build();


        Employee em1 = Employee.builder()
                .firstName("NameEmp1Test")
                .surName("SurEmp1Test")
                .build();

        Employee em2 = Employee.builder()
                .firstName("NameEmp2Test")
                .surName("SurEmp2Test")
                .build();

        SchoolClass sc1 = SchoolClass.builder()
                .employee(em1)
                .className("Programowanie")
                .build();

        try {
            Presence p1 = Presence.builder()
                    .startDate(new SimpleDateFormat("dd/MM/yyyy HH:mm:ss")
                            .parse("31/12/1998 12:12:12"))
                    .endDate(new SimpleDateFormat("dd/MM/yyyy HH:mm:ss")
                            .parse("31/12/1998 13:12:12"))
                    .schoolClass(sc1)
                    .student(s1)
                    .build();

            session.save(p1);
        }catch (Exception e){
            System.out.println(e);
        }

        session.save(s1);
        session.save(s2);
        session.save(s3);
        session.save(em1);
        session.save(em2);
        session.save(sc1);

        SchoolClass test1sc = session.get(SchoolClass.class, 1);

        System.out.println(test1sc);

        session.getTransaction().commit();
        HibernateUtil.shutdown();
    }
}