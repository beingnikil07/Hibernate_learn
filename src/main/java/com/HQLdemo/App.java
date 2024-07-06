package com.HQLdemo;

import java.util.List;
import java.util.Random;

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
       
        
        
        int value=60;
        //using the Prepared statement 
        Query q=session.createQuery("select sum(marks) from Student s where s.marks> :value");
        q.setParameter("value",value);
        Long marks=(Long)q.uniqueResult();  
        
       System.out.println(marks);
            
        session.getTransaction().commit();
        
        
        
        
	}

}
