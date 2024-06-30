package com.nikhil.DemoHibernate;
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
        a=(Alien) session1.get(Alien.class,01);
        System.out.println(a);
        session1.getTransaction().commit();
        a=(Alien) session1.get(Alien.class,01);
         
    }
}
