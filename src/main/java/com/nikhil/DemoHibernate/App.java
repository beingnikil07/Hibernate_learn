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
        Alien nik=new Alien();
//        nik.setAid(03);
//        nik.setAname("Anamika");
//        nik.setColor("black");
        
        Configuration con=new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Alien.class); 
        ServiceRegistry reg=new StandardServiceRegistryBuilder().applySettings(con.getProperties()).build();
        SessionFactory sf=con.buildSessionFactory(reg);
        Session session=sf.openSession();
        Transaction tx=session.beginTransaction();
//      session.save(nik);        
        nik=(Alien)session.get(Alien.class,01);  //passing the id  
        tx.commit();
        System.out.println(nik);
        
        
        
    }
}
