package com.HQLdemo;

import java.util.Random;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import com.HQLdemo.Student;
public class App {

	public static void main(String[] args) {
		
		Configuration con=new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class);	
        ServiceRegistry reg=new StandardServiceRegistryBuilder().applySettings(con.getProperties()).build();
        SessionFactory sf=con.buildSessionFactory(reg);
        Session session=sf.openSession();
        session.beginTransaction();
        
        Random r=new Random();
        
        for(int i=1;i<=50;i++) {
        	Student s=new Student();
        	s.setRollno(i);
        	s.setName("Name "+i);
        	s.setMarks(r.nextInt(100));
        	session.save(s);
        }
        
        session.getTransaction().commit();
        
        
        
        
	}

}
