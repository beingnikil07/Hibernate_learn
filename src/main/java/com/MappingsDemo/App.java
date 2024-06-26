package com.MappingsDemo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class App {

	public static void main(String[] args) {

		Laptop laptop=new Laptop();
		laptop.setLid(101);
		laptop.setLname("Asus");
		
		
		Student s=new Student();
		s.setRollno(1);
		s.setName("Nikhil Rana");
		s.setMarks(90);
		s.setLaptop(laptop);
		
		
		Configuration con=new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).addAnnotatedClass(Laptop.class);	
        ServiceRegistry reg=new StandardServiceRegistryBuilder().applySettings(con.getProperties()).build();
        SessionFactory sf=con.buildSessionFactory(reg);
        Session session=sf.openSession();
        Transaction tx=session.beginTransaction();
        session.save(s);
        session.save(laptop);
        session.getTransaction().commit();
	}

}
