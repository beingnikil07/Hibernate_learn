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
        
        
        //Query q=session.createQuery("from Student");
        
        Query q=session.createQuery("select rollno,name,marks from Student where rollno=7");
        //We are using Object array becz rollno,name,marks sabke datatypes different hai,if we not use Object data type it will shows error for this query
        
        Object[] student=(Object[]) q.uniqueResult();  
        
        for(Object o:student) {
        	System.out.println(o);
        }
        
        
        session.getTransaction().commit();
        
        
        
        
	}

}
