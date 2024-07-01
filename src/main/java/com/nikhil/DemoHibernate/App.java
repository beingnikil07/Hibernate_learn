package com.nikhil.DemoHibernate;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class App 
{
    public static void main( String[] args )
    {
    	AlienName an=new AlienName();
    	an.setFname("Anamika");
    	an.setMname("RAI");
    	an.setLname("Rana");
    	Alien a=new Alien();
    	a.setAid(03);
    	a.setName(an);
    	
    	
        Configuration con=new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Alien.class); 
        ServiceRegistry reg=new StandardServiceRegistryBuilder().applySettings(con.getProperties()).build();
        SessionFactory sf=con.buildSessionFactory(reg);
        
        Session session1=sf.openSession();
        session1.beginTransaction();
        //Fetching data from database using query
        Query q1=session1.createQuery("from Alien where aid=1");
        
        a=(Alien)q1.uniqueResult();
        System.out.println(a);
        
        session1.getTransaction().commit(); 
        session1.close();
        
        Session session2=sf.openSession();
        session2.beginTransaction();
        Query q2=session2.createQuery("from Alien where aid=1");
        
        a=(Alien)q2.uniqueResult();
        System.out.println(a);
        
        session2.getTransaction().commit();
        session2.close();
       
         
    }
}
