package com.HQLdemo;

import java.util.List;
import java.util.Random;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.hibernate.service.ServiceRegistry;
import com.HQLdemo.Student;
public class App {

	public static void main(String[] args) {
		
		Configuration con=new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class);	
        ServiceRegistry reg=new StandardServiceRegistryBuilder().applySettings(con.getProperties()).build();
        SessionFactory sf=con.buildSessionFactory(reg);
        Session session=sf.openSession();
        session.beginTransaction();
       
        SQLQuery q=session.createSQLQuery("select * from student where marks>60");
        
        List students=q.list();
        for(Object o:students) {
        	System.out.println(o);
        }
        
        
        session.getTransaction().commit();
        
        
        
        
	}

}
